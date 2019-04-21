<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医生信息查询</title>
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
						<td valign="bottom" class="title">医生信息管理</td>
					</tr>
				</table></td>
		</tr>
	</table>
	<br>
	<form action="${pageContext.request.contextPath}/DoctorsSevlet?method=searchdoctors&site=0" method="post">
	<table width="95%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td class="td_page">
				医生工号： <input name="jobnumber" size="10" type="text" class="input">
				医生姓名：<input name="uname" size="10" type="text" class="input">
				<input name="Submit" type="submit" class="buttonface" value=" 查询 ">
				<a href="${pageContext.request.contextPath}/DoctorsSevlet?method=findinfomation&site=0" target="mainFrame">&nbsp;&nbsp;添加医生信息</a>
			</td>
		</tr>
	</table>
	</form>
	<br>
	<table width="95%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table01">
		<tr align="center">
			<td class="td_top">医生工号</td>
			<td class="td_top">医生职称</td>
			<td class="td_top">医生姓名</td>
			<td class="td_top">医生性别</td>
			<td class="td_top">医生年龄</td>
			<td class="td_top">医生科室</td>
			<td class="td_top">挂号类型</td>
			<td class="td_top">电话</td>
			<td class="td_top">状态</td>
			<td class="td_top">操作</td>
		</tr>
		
		<c:forEach var="d" items="${dList }">
			<tr align="center">
				<td class="td07">${d.userInfos.jobnumber }</td>
				<td class="td07">${d.doctortitle.dtname }</td>
				<td class="td07">${d.userInfos.uname }</td>
				<td class="td07">${d.userInfos.usex }</td>
				<td class="td07">${d.userInfos.uage }</td>
				<td class="td07">${d.branch.brname }</td>
				<td class="td07">${d.typeoftreatment.tyname }</td>
				<td class="td07">${d.userInfos.uphonenumber }</td>
				<td class="td07">${d.userInfos.ustatus }</td>
				<td class="td07">
					<a href="${pageContext.request.contextPath}/DoctorsSevlet?method=modifyDoctors&site=0&jobnumber=${d.userInfos.jobnumber }">修改</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/DoctorsSevlet?method=deleteDoctors&site=0&doid=${d.doid }">删除</a></td>
			</tr>
		</c:forEach>
		
		<tr align="center">
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
		</tr>
		<tr align="center">
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
		</tr>
		<tr align="center">
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
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

