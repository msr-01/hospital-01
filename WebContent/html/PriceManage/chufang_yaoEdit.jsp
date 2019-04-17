<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>药品费用详情</title>
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
							<td valign="bottom" class="title">药品费用详情</td>
						</tr>
					</table></td>
			</tr>
		</table>
		<form name="form1" method="post" action="">
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0" class="table01">
				<tr>
					<td class="td_top">药品名称</td>
					<td class="td_top">药品编号</td>
					<td class="td_top">药品数量</td>
					<td class="td_top">药品单价</td>
				</tr>
				<c:forEach var="d" items="${prescription.druglist }">
					<tr>
						<td class="td07">${d.drug.drname }</td>
						<td class="td07">${d.drug.drid }</td>
						<td class="td07">${d.drnum }盒</td>
						<td class="td07">${d.drug.drunitprice }元</td>
					</tr>
				</c:forEach>
			</table>
			<table width="95%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="90" height="24" class="td_form01">药品总价</td>
					<td class="td_form02">${prescription.dltotal }元</td>
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