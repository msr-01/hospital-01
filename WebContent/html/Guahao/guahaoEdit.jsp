<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css">
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
							<td valign="bottom" class="title">挂号详情</td>
						</tr>
					</table></td>
			</tr>
		</table>
		<form name="form1" method="post" action="">
			<table width="95%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="90" height="24" class="td_form01">就诊卡号</td>
					<td class="td_form02">${registered.patientinformation.piid }</td>
					<td width="90" height="24" class="td_form01">患者姓名</td>
					<td class="td_form02">${registered.patientinformation.piname }</td>
				</tr>
				<tr>
					<td width="90" height="24" class="td_form01">患者性别</td>
					<td class="td_form02">${registered.patientinformation.pisex }</td>
					<td width="90" height="24" class="td_form01">患者年龄</td>
					<td class="td_form02">${registered.patientinformation.piage }</td>
				</tr>
				<tr>
					<td width="90" height="24" class="td_form01">就诊科室</td>
					<td class="td_form02">${registered.branch.brname }</td>

					<td width="90" height="24" class="td_form01">挂号类型</td>
					<td class="td_form02">${registered.typeoftreatment.tyname }</td>
				</tr>
				<tr>
					<td width="90" height="24" class="td_form01">就诊医生</td>
					<td class="td_form02">${registered.doctors.userInfos.uname }</td>
					<td width="90" height="24" class="td_form01">挂号费用</td>
					<td class="td_form02">${registered.registrationfee.rfcost }</td>
				</tr>
				<tr>
					<td width="90" height="24" class="td_form01">就诊地点</td>
					<td class="td_form02">${registered.branch.brlocation }</td>
					<td width="90" height="24" class="td_form01">挂号日期</td>
					<td class="td_form02">${registered.retime }</td>
				</tr>
			</table>
			<br>
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td align="center"><input name="Return" type="button"
						class="buttonface" value="返回" onClick="history.back(-1)"></td>
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
