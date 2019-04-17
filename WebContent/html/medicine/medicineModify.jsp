<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改药品信息</title>
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
							<td valign="bottom" class="title">修改药品信息</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<form name="form1" action="${pageContext.request.contextPath}/DrugSevlet?method=ModifyDrug" method="post">
			<table width="95%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="90" height="24" class="td_form01">药品编号</td>
					<td class="td_form02"><input name="drid" type="text"
						class="input" value="${drug.drid }"></td>
					<td width="90" height="24" class="td_form01">药品名称</td>
					<td class="td_form02"><input name="drname" type="text"
						class="input" value="${drug.drname }"></td>
				</tr>
				<tr>
					<td width="90" height="24" class="td_form01">药品规格</td>
					<td class="td_form02"><input name="drformat" type="text"
						class="input" value="${drug.drformat }"></td>
					<td width="90" height="24" class="td_form01">药品单价</td>
					<td class="td_form02"><input name="drunitprice" type="text"
						class="input" value="${drug.drunitprice }"></td>
				</tr>
				<tr>
					<td width="90" height="24" class="td_form01">药品功能</td>
					<td class="td_form02"><input name="drfunction" type="text"
						class="input" value="${drug.drfunction }"></td>
					<td width="90" height="24" class="td_form01">生产厂家</td>
					<td class="td_form02"><input name="drmanufacturer" type="text"
						class="input" value="${drug.drmanufacturer }"></td>
				</tr>
				<tr>
					<td width="90" height="24" class="td_form01">有效期</td>
					<td class="td_form02"><input name="dreffectiveperiod" type="text"
						class="input" value="${drug.dreffectiveperiod }"></td>
					<td width="90" height="24" class="td_form01">库存</td>
					<td class="td_form02"><input name="drinstock" type="text"
						class="input" value="${drug.drinstock }"></td>
				</tr>
			</table>
			<br>
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td align="center">
					<input name=save type="submit" class=buttonface value="提交" >
					<input name="Reset" type="reset" class="buttonface" value="重置">
					<input name="Return" type="button" class="buttonface" value="返回"
						onClick="history.back(-1)"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
