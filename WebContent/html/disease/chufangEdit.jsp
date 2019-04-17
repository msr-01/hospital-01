<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处方详情</title>
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
							<td width="15"><img src="${pageContext.request.contextPath}/images/index_32.gif"
								width="9" height="9"></td>
							<td valign="bottom" class="title">处方详情</td>
						</tr>
					</table></td>
			</tr>
		</table>
		<form name="form1" method="post" action="">
			<table width="95%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="90" height="24" class="td_form01">处方编号</td>
					<td class="td_form02">cf0001</td>
				</tr>
			</table>
			<br>
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0" class="table01">
				<tr>
					<td class="td_top">药品名称</td>
					<td class="td_top">药品编号</td>
					<td class="td_top">药品数量</td>
					<td class="td_top">药品单价</td>
				</tr>
				<tr>
					<td class="td07">999感冒冲剂</td>
					<td class="td07">y0001</td>
					<td class="td07">2盒</td>
					<td class="td07">28元</td>
				</tr>
				<tr>
					<td class="td07">多邦消炎片</td>
					<td class="td07">y0002</td>
					<td class="td07">1盒</td>
					<td class="td07">9元</td>
				</tr>
			</table>
			<table width="95%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="90" height="24" class="td_form01">药品总价</td>
					<td class="td_form02">65元</td>
				</tr>
			</table>
			<br>
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0" class="table01">
				<tr>
					<td class="td_top">医疗项目名称</td>
					<td class="td_top">医疗项目编号</td>
					<td class="td_top">医疗项目费用</td>
				</tr>
				<tr>
					<td class="td07">心电图</td>
					<td class="td07">yl001</td>
					<td class="td07">200元</td>
				</tr>
			</table>
			<table width="95%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="90" height="24" class="td_form01">医疗项目总价</td>
					<td class="td_form02">200元</td>
				</tr>
			</table>
			<br>
			<table width="95%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="90" height="24" class="td_form01">处方总价</td>
					<td class="td_form02">265元</td>
				</tr>
			</table>
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