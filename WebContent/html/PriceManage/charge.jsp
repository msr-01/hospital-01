<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>划价收费</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css">
<script language="javascript"
	src="${pageContext.request.contextPath}/js/check.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/js/checkAll.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/js/clientSideApp.js"></script>
<SCRIPT language=JavaScript type=text/JavaScript>
	function windowOpen(theURL, winName, features, width, hight, scrollbars,
			top, left) {
		var parameter = "top=" + top + ",left=" + left + ",width=" + width
				+ ",height=" + hight;
		if (scrollbars == "no") {
			parameter += ",scrollbars=no";
		} else {
			parameter += ",scrollbars=yes";
		}
		window.open(theURL, winName, parameter);
	}
</SCRIPT>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"> </script>
<script type="text/javascript">
	$(function(){
		$("#piid").focus();
	});
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="25" align="center" valign="bottom" class="td06"><table
					width="98%" border="0" cellspacing="3" cellpadding="0">
					<tr>
						<td width="15"><img
							src="${pageContext.request.contextPath}/images/index_32.gif"
							width="9" height="9"></td>
						<td valign="bottom" class="title">划价收费</td>
					</tr>
				</table></td>
		</tr>
	</table>
	<br>
	<form action="${pageContext.request.contextPath}/PrescriptionSevlet?method=findOrderBypiid&site=0" method="post">
		<table width="95%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td class="td_page">
					就诊卡号：<input name="piid" size="10" type="text" class="input" id="piid">
					<input name="Submit" type="submit" class="buttonface" value=" 查询 ">
				</td>
			</tr>
		</table>	
	</form>
	<br>
	<table width="95%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table01">
		<tr align="center">
			<td class="td_top">处方编号</td>
			<td class="td_top">药品费用</td>
			<td class="td_top">医疗项目费用</td>
			<td class="td_top">处方总费用</td>
			<td class="td_top">下单时间</td>
			<td nowrap class="td_top">处方状态</td>
		</tr>
		<c:forEach var="p" items="${plist }">
			<tr align="center">
				<td class="td07">${p.ppid }</td>
				<td class="td07">${p.dltotal }元 <a href="${pageContext.request.contextPath}/PrescriptionSevlet?method=findDruglist&site=0&ppid=${p.ppid}" target="mainFrame">>>详情</a></td>
				<td class="td07">${p.mltotal }元 <a href="${pageContext.request.contextPath}/PrescriptionSevlet?method=findDruglist&site=1&ppid=${p.ppid}" target="mainFrame">>>详情</a></td>
				<td class="td07">${p.total }元</td>
				<td class="td07">${p.ppordertime }</td>
				<c:choose>
					<c:when test="${p.ppstatus ==0}">
						<td class="td07">未付款&nbsp;&nbsp;&nbsp;&nbsp;
							<input name=save type="button"class=buttonface  value="确认付款" onclick="location.href='${pageContext.request.contextPath}/PrescriptionSevlet?method=payOrder&site=0&ppid=${p.ppid}'">
						</td>
					</c:when>
					<c:otherwise>
						<td class="td07">已付款&nbsp;&nbsp;&nbsp;&nbsp;
							付款时间：${p.pppaymenttime }
						</td>
					</c:otherwise>
				</c:choose>
				
			</tr>
		</c:forEach>
		
		
		<tr align="center">
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
		</tr>
	</table>
	<table width="95%" border="0" cellpadding="0" cellspacing="0"
		class="table02" align="center">
		<tr>
			<td height="30" align="right"><img
				src="${pageContext.request.contextPath}/images/1.gif" width="4"
				height="5" align="absmiddle"> 首页 <img
				src="${pageContext.request.contextPath}/images/2.gif" width="3"
				height="5" align="absmiddle"> 上一页 <img
				src="${pageContext.request.contextPath}/images/2-2.gif" width="3"
				height="5" align="absmiddle"> 下一页 <img
				src="${pageContext.request.contextPath}/images/3.gif" width="4"
				height="5" align="absmiddle"> 末页 共 1 页 1 条记录</td>
		</tr>
	</table>
</body>
</html>
