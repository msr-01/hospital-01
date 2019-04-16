<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改医生信息</title>
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
						<td valign="bottom" class="title">修改医生信息 </td>
					</tr>
				</table></td>
		</tr>
	</table>
	<form name="form1" method="post" action="">
		<table width="95%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="90" height="24" class="td_form01">医生工号</td>
				<td class="td_form02"><input name="textfield24" type="text"
					class="input"></td>
				<td width="90" height="24" class="td_form01">医生职称</td>
				<td class="td_form02"><select name="select3">
						<option>--请选择--</option>
						<option>院长</option>
						<option>主任</option>
						<option>专家</option>
						<option>主治医师</option>
				</select></td>
			</tr>
			<tr>
				<td width="90" height="24" class="td_form01">医生姓名</td>
				<td class="td_form02"><input name="textfield24" type="text"
					class="input"></td>
				<td width="90" height="24" class="td_form01">医生性别</td>
				<td class="td_form02"><select name="select3">
						<option>--请选择--</option>
						<option>男</option>
						<option>女</option>
				</select></td>
			</tr>
			<tr>
				<td width="90" height="24" class="td_form01">医生年龄</td>
				<td class="td_form02"><input name="textfield24" type="text"
					class="input"></td>
				<td width="90" height="24" class="td_form01">医生科室</td>
				<td class="td_form02"><select name="select3">
						<option>--请选择--</option>
						<option>耳鼻喉科</option>
						<option>内科</option>
						<option>肛肠科</option>
						<option>妇科</option>
						<option>外科</option>
				</select></td>
			</tr>
			<tr>
				<td width="90" height="24" class="td_form01">挂号类型</td>
				<td class="td_form02"><select name="select3">
						<option>--请选择--</option>
						<option>院长</option>
						<option>主任</option>
						<option>专家</option>
						<option>主治医师</option>
				</select></td>
				<td width="90" height="24" class="td_form01">电话</td>
				<td class="td_form02"><input name="textfield24" type="text"
					class="input"></td>
			</tr>
			<tr>
				<td width="90" height="24" class="td_form01">状态</td>
				<td class="td_form02"><select name="select3">
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
