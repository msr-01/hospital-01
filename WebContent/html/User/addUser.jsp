<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css">
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
						<td valign="bottom" class="title">添加用户</td>
					</tr>
				</table></td>
		</tr>
	</table>
	<form name="form1" method="post" action="${pageContext.request.contextPath}/UserInfosServlet?method=addUser" >
		<table width="95%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="90" height="24" class="td_form01">用户编码</td>
				<td class="td_form02"><input name="uid" type="text"
					class="input"></td>
				<td width="90" height="24" class="td_form01">登陆密码</td>
				<td class="td_form02"><input name="upassword" type="text"
					class="input"></td>
			</tr>
			<tr>
				<td width="90" height="24" class="td_form01">姓名</td>
				<td class="td_form02"><input name="uname" type="text"
					class="input"></td>
				<td width="90" height="24" class="td_form01">性别</td>
				<td class="td_form02"><input name="usex" type="text"
					class="input"></td>
			</tr>
			<tr>
				<td width="90" height="24" class="td_form01">年龄</td>
				<td class="td_form02"><input name="uage" type="text"
					class="input"></td>
				<td width="90" height="24" class="td_form01">工号</td>
				<td class="td_form02"><input name="jobnumber" type="text"
					class="input"></td>
			</tr>
			<tr>
				<td width="90" height="24" class="td_form01">职称</td>
				<td class="td_form02"><select name="ujobtitle">
						<option>--请选择--</option>
						<option>院长</option>
						<option>主任</option>
						<option>专家</option>
						<option>主治医师</option>
				</select></td>
				<td width="90" height="24" class="td_form01">电话</td>
				<td class="td_form02"><input name="uphonenumber" type="text"
					class="input"></td>
			</tr>
			<tr>
				<td width="90" height="24" class="td_form01">邮箱</td>
				<td class="td_form02"><input name="uemail" type="text"
					class="input"></td>
				<td width="90" height="24" class="td_form01">状态</td>
				<td class="td_form02"><select name="ustatus	">
						<option>--请选择--</option>
						<option>在职</option>
						<option>休假</option>
						<option>失踪</option>
				</select></td>
			</tr>
		</table>
		<br>
		<table width="95%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center">
					<input name=save type="button" class=buttonface value="提交" onclick="location.href='#'">
					<input name="Reset" type="button" class="buttonface" value="重置" onClick="location.href='#'">
					<input name="Return" type="button" class="buttonface" value="返回" onClick="history.back(-1)">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
