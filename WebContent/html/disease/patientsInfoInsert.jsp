<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>病历信息录入</title>
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
							<td valign="bottom" class="title">病历信息录入</td>
						</tr>
					</table></td>
			</tr>
		</table>
		<br>
		<br>
		<form name="form1" method="post" action="">
			<table width="95%" border="0" cellspacing="0" cellpadding="0">
				<tr>

					<td width="90" class="td_form01">病历编号</td>
					<td class="td_form02"><input name="textfield24" type="text"
						class="input"></td>
					<td width="90" class="td_form01">患者姓名</td>
					<td class="td_form02"><input name="textfield24" type="text"
						class="input"></td>
				</tr>
				<tr>
					<td width="90" class="td_form01">患者性别</td>
					<td class="td_form02"><select name="select3">
							<option>男</option>
							<option>女</option>
					</select></td>
					<td width="90" height="24" class="td_form01">患者年龄</td>
					<td class="td_form02"><input name="textfield24" type="text"
						class="input"></td>
				</tr>
			</table>
			<br>
			<br>
			<table width="95%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="90" height="24" class="td_form01">医生编号</td>
					<td class="td_form02"><input name="textfield24" type="text"
						class="input"></td>
					<td width="90" height="24" class="td_form01">诊断时间</td>
					<td class="td_form02"><input name="textfield24" type="text"
						class="input"></td>
				</tr>
				<tr align="left" nowrap>
					<td height="24" align="center" class=td_form01>诊断结果：</td>
					<td height="24" colspan="5" align="left" valign="middle"
						class=td_form01><label> <textarea name="textarea"
								id="textarea" cols="100" rows="5"></textarea>
					</label></td>
				</tr>
			</table>
			<br>
			<br>
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td class="td_page">
						药品名称：<input name="PARA_YM_NOW" size="10" type="text" class="input"> 
						药品编号：<input name="PARA_YM_NOW" size="10" type="text" class="input">
						<input name="Submit" type="submit" class="buttonface" value="查询 ">
					</td>
				</tr>
			</table>
			<br>
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td class="td_top" align="center">药品名称</td>
					<td class="td_top" align="center">药品编号</td>
					<td class="td_top" align="center">药品单价</td>
					<td nowrap class="td_top" align="center">操作</td>
				</tr>
				<tr>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center">+</td>
				</tr>
				<tr>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center">+&nbsp;-</td>
				</tr>
			</table>
			<br>
			<table width="95%" border="" align="center" cellpadding="0"
				cellspacing="0" class="table01">
				<tr>
					<td class="td_top" align="center">药品名称</td>
					<td class="td_top" align="center">药品编号</td>
					<td class="td_top" align="center">药品单价</td>
					<td class="td_top" align="center">药品数量</td>
					<td nowrap class="td_top" align="center">操作</td>
				</tr>
				<tr>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center">
						<input name="textfield24" type="text" class="input">
					</td>
					<td class="td07" align="center">+</td>
				</tr>
				<tr>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center">
						<input name="textfield24" type="text" class="input">
					</td>
					<td class="td07" align="center">+&nbsp;-</td>
				</tr>
			</table>
			<table width="95%" border="" align="center" cellpadding="0"
				cellspacing="0" class="table01">
				<tr>
					<td width="15%" height="24" class="td_form01">药品总价</td>
					<td width="80%" align="left" class="td_form02">0元</td>
				</tr>
			</table>
			<br>
			<br>
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td class="td_page">
						医疗项目名称：<input name="PARA_YM_NOW" size="10" type="text" class="input">
						医疗项目编号：<input name="PARA_YM_NOW" size="10" type="text" class="input">
						<input name="Submit" type="submit" class="buttonface" value="查询 ">
					</td>
				</tr>
			</table>
			<br>
			<table width="95%" border="" align="center" cellpadding="0"
				cellspacing="0" class="table01">
				<tr>
					<td class="td_top" align="center">医疗项目名称</td>
					<td class="td_top" align="center">医疗项目编号</td>
					<td class="td_top" align="center">医疗项目费用</td>
					<td nowrap class="td_top" align="center">操作</td>
				</tr>
				<tr>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center">+</td>
				</tr>
				<tr>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center">+&nbsp;-</td>
				</tr>
			</table>
			<br>
			<table width="95%" border="" align="center" cellpadding="0"
				cellspacing="0" class="table01">
				<tr>
					<td class="td_top" align="center">医疗项目名称</td>
					<td class="td_top" align="center">医疗项目编号</td>
					<td class="td_top" align="center">医疗项目费用</td>
					<td nowrap class="td_top" align="center">操作</td>
				</tr>
				<tr>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center">+</td>
				</tr>
				<tr>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center">+&nbsp;-</td>
				</tr>
			</table>
			<table width="95%" border="" align="center" cellpadding="0"
				cellspacing="0" class="table01">
				<tr>
					<td width="15%" height="24" class="td_form01">医疗项目总价</td>
					<td width="80%" align="left" class="td_form02">0元</td>
				</tr>
			</table>
			<br>
			<br>
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td align="center"><input name=save type="button"
						class=buttonface value="提交" onclick="location.href='#'"> <input
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