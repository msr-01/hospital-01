<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看病人信息</title>
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
						<td valign="bottom" class="title">查看病人信息</td>
					</tr>
				</table></td>
		</tr>
	</table>
	<br>
	<table width="95%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td class="td_page">就诊卡号：<input name="PARA_YM_NOW" size="10"
				type="text" class="input"> 患者姓名：<input name="PARA_YM_NOW2"
				size="10" type="text" class="input"> 患者手机号：<input
				name="PARA_YM_NOW3" size="10" type="text" class="input"> <input
				name="Submit" type="submit" class="buttonface" value="查询 ">
				<a href="addpatient.jsp" target="mainFrame">&nbsp;&nbsp;添加患者信息</a>
			</td>
		</tr>
	</table>
	<br>
	<table width="95%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table01">
		<tr>
			<td class="td_top">就诊卡号</td>
			<td class="td_top">患者姓名</td>
			<td class="td_top">患者性别</td>
			<td class="td_top">患者年龄</td>
			<td class="td_top">手机号</td>
			<td class="td_top">居住地址</td>
			<td nowrap class="td_top">操作</td>
		</tr>
		<tr>
			<td class="td07">1103</td>
			<td class="td07">朱佳宝</td>
			<td class="td07">女</td>
			<td class="td07">20</td>
			<td class="td07">110</td>
			<td class="td07">广西</td>
			<td class="td07"><a href="patientModify.jsp" target="mainFrame">修改</a>
				<a href="#" target="mainFrame">&nbsp;&nbsp;删除</a></td>
		</tr>
		<tr>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
		</tr>
		<tr>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
			<td class="td07">&nbsp;</td>
		</tr>
		<tr>
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
			<td height="30" align="right"><img src="${pageContext.request.contextPath}/images/1.gif"
				width="4" height="5" align="absmiddle"> 首页 <img
				src="${pageContext.request.contextPath}/images/2.gif" width="3" height="5" align="absmiddle">
				上一页 <img src="${pageContext.request.contextPath}/images/2-2.gif" width="3" height="5"
				align="absmiddle"> 下一页 <img src="${pageContext.request.contextPath}/images/3.gif" width="4"
				height="5" align="absmiddle"> 末页 共 1 页 1 条记录</td>
		</tr>
	</table>
</body>
</html>

