<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>病历编号与信息</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">

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
							<td valign="bottom" class="title">病历信息查询</td>
						</tr>
					</table></td>
			</tr>
		</table>
		<form name="form1" method="post" action="">
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td class="td_page">
					就诊卡号：<input name="PARA_YM_NOW" size="10" type="text" class="input">
					<input name="Submit" type="submit" class="buttonface" value="查询 "></td>
				</tr>
			</table>
			<br>
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0" class="table01">
				<tr>
					<td class="td_top">病历编号</td>
					<td class="td_top">医生姓名</td>
					<td class="td_top">诊断时间</td>
					<td class="td_top">诊断结果</td>
					<td class="td_top">诊断方法</td>
					<td nowrap class="td_top">处方</td>
					<td nowrap class="td_top">操作</td>
				</tr>
				<tr>
					<td class="td07">0001</td>
					<td class="td07">张山</td>
					<td class="td07">2018-11-01</td>
					<td class="td07">脑残</td>
					<td class="td07">心电图</td>
					<td class="td07">
						<a href="chufangEdit.jsp" target="mainFrame">详情</a>
					</td>
					<td class="td07">
						<a href="patientModify.jsp" target="mainFrame">修改</a> 
						<a href="#" target="mainFrame">&nbsp;&nbsp;删除</a>
					</td>
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
								align="absmiddle"> 下一页 <img src="${pageContext.request.contextPath}./images/3.gif"
									width="4" height="5" align="absmiddle"> 末页 共 1 页 1 条记录</td>
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