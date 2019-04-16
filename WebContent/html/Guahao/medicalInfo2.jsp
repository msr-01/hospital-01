<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>药品信息查询</title>
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
						<td valign="bottom" class="title">药品信息查询</td>
					</tr>
				</table></td>
		</tr>
	</table>
	<br>
	<form action="${pageContext.request.contextPath}/DrugSevlet?method=drugfindAll" method="post">
	<table width="95%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td class="td_page">药品编号： <input id="drid" name="drid" size="20"
				type="text" class="input"> 药品名称：<input id="drname"
				name="drname" size="20" type="text" class="input"> <input
				id="chaxun" name="chaxun" type="submit" class="buttonface"
				value=" 查询 ">
			</td>
		</tr>
	</table>
	</form>
	<br>
	<table width="95%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table01">
		<tr align="center">
			<td class="td_top">药品编号</td>
			<td class="td_top">药品名称</td>
			<td class="td_top">药品规格</td>
			<td class="td_top">药品单价</td>
			<td class="td_top">药品功能</td>
			<td class="td_top">生产厂家</td>
			<td class="td_top">有效期</td>
			<td class="td_top">库存</td>
		</tr>
		<c:if test="${!empty drList}">
			<c:forEach var="drug" items="${drList}">
				<tr align="center">
					<td class="td07">${drug.drid}</td>
					<td class="td07">${drug.drname}</td>
					<td class="td07">${drug.drformat}12粒/片<br>2片/盒</td>
					<td class="td07">${drug.drunitprice}</td>
					<td class="td07">${drug.drfunction}</td>
					<td class="td07">${drug.drmanufacturer}</td>
					<td class="td07">${drug.dreffectiveperiod}</td>
					<td class="td07">${drug.drinstock}</td>
				</tr>
			</c:forEach>
		</c:if>
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
	<table width="95%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="center"><input name="Return" type="button"
				class="buttonface" value="返回" onClick="history.back(-1)"></td>
		</tr>
	</table>

</body>
</html>
