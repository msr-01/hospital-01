<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科室管理</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
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
						<td width="15"><img src="${pageContext.request.contextPath}/images/index_32.gif" width="9"
							height="9"></td>
						<td valign="bottom" class="title">科室管理</td>
					</tr>
				</table></td>
		</tr>
	</table>
	<br>
	<table width="95%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td class="td_page">
				科室编号： <input name="PARA_YM_NOW" size="10" type="text" class="input">
				科室名称：<input name="PARA_YM_NOW2" size="10" type="text" class="input">
				<input name="Submit" type="submit" class="buttonface" value=" 查询 ">
				<a href="addKeshi.jsp" target="mainFrame">&nbsp;&nbsp;添加科室信息</a>
			</td>
		</tr>
	</table>
	<br>
	<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
		<tr align="center">
			<td class="td_top">科室编号</td>
			<td class="td_top">科室名称</td>
			<td class="td_top">科室地址</td>
			<td class="td_top">操作</td>
		</tr>
		<tr align="center">
			<td class="td07">1103</td>
			<td class="td07">妇科</td>
			<td class="td07">天桥医院二楼201号</td>
			<td class="td07"><a href="keshiModify.jsp">修改</a>&nbsp;&nbsp;<a href="#">删除</a></td>
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