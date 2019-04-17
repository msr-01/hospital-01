<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改患者信息</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<center>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="25" align="center" valign="bottom" class="td06"><table
						width="98%" border="0" cellspacing="3" cellpadding="0">
						<tr>
							<td width="15"><img
								src="${pageContext.request.contextPath}/images/index_32.gif"
								width="9" height="9"></td>
							<td valign="bottom" class="title">修改患者信息</td>
						</tr>
					</table></td>
			</tr>
		</table>
		<form name="form1" method="post" action="${pageContext.request.contextPath}/PatientinformationServlet?method=ModifyPatientinformation&site=1">
			<table width="95%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="90" height="24" class="td_form01">就诊卡号</td>
					<td class="td_form02"><input name="piid" type="text"
						class="input" value="${patientinformation.piid }"></td>
					<td width="90" height="24" class="td_form01">患者姓名</td>
					<td class="td_form02"><input name="piname" type="text"
						class="input" value="${patientinformation.piname }"></td>
				</tr>
				<tr>
					<td width="90" height="24" class="td_form01">患者性别</td>
					<td class="td_form02"><select name="pisex">
							<option>${patientinformation.pisex }</option>
							<option>男</option>
							<option>女</option>
					</select></td>
					<td width="90" height="24" class="td_form01">患者年龄</td>
					<td class="td_form02"><input name="piage" type="text"
						class="input" value="${patientinformation.piage }"></td>
				</tr>
				<tr>
					<td width="90" height="24" class="td_form01">手机号</td>
					<td class="td_form02"><input name="piphonenumber" type="text"
						class="input" value="${patientinformation.piphonenumber }"></td>
				</tr>
			</table>
			<br>
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td align="center"><input name=save type="submit"
						class=buttonface value="提交" > <input
						name="Reset" type="button" class="buttonface" value="重置"
						onClick="location.href='#'"> <input name="Return"
						type="button" class="buttonface" value="返回"
						onClick="history.back(-1)"></td>
				</tr>
			</table>
			<p>&nbsp;</p>
			<p>
				<br>
			</p>
		</form>
	</center>
</body>
</html>