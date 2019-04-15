<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果</title>
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
			<td height="25" align="center" valign="bottom" class="td06">
				<table width="98%" border="0" cellspacing="3" cellpadding="0">
					<tr>
						<td width="15"><img
							src="${pageContext.request.contextPath}/images/index_32.gif"
							width="9" height="9"></td>
						<td valign="bottom" class="title">挂号查询</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<br>
	<table width="95%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td class="td_page">就诊卡号： <input name="PARA_YM_NOW" size="10"
				type="text" class="input"> 患者姓名：<input name="PARA_YM_NOW2"
				size="10" type="text" class="input"> <input name="Submit"
				type="submit" class="buttonface" value="查询 "></td>
		</tr>
	</table>
	<br>
	<table width="95%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table01">
		<tr>
			<td class="td_top">就诊卡号</td>
			<td class="td_top">患者姓名</td>
			<td class="td_top">挂号科室</td>
			<td class="td_top">挂号日期</td>
			<td nowrap class="td_top">操作</td>

<<<<<<< HEAD
<input name="Submit" type="submit" class="buttonface" value=" 查询 "></td>
  </tr>
</table>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
  <tr>
    <td class="td_top">就诊卡号</td>
    <td class="td_top">病人姓名</td>
    <td class="td_top">挂号日期</td>
    <td class="td_top">挂号科室</td>
    <td nowrap class="td_top">操作</td>
  </tr>
  <tr>
    <td class="td07">1103</td>
    <td class="td07">朱佳宝</td>
    <td class="td07">2013-9-10</td>
    <td class="td07">脑残科</td>
    <td class="td07">
        <a href="guahaoEdit.jsp" target="mainFrame">&nbsp;&nbsp;详情</a>
        <a href="guahaoModify.jsp"  target="mainFrame">&nbsp;&nbsp;修改</a>
        <a href="tuihao.jsp"  target="mainFrame">&nbsp;&nbsp;退号</a>
    </td>
  </tr>
  <tr>
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
  </tr>
  <tr>
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
  </tr>
</table>
<table width="95%"  border="0" cellpadding="0" cellspacing="0" class="table02" align="center">
  <tr>
    <td height="30" align="right"><img src="${pageContext.request.contextPath}/images/1.gif" width="4" height="5" align="absmiddle"> 首页　 <img src="${pageContext.request.contextPath}/images/2.gif" width="3" height="5" align="absmiddle"> 上一页　 <img src="${pageContext.request.contextPath}/images/2-2.gif" width="3" height="5" align="absmiddle"> 下一页　 <img src="${pageContext.request.contextPath}/images/3.gif" width="4" height="5" align="absmiddle"> 末页　　共 1 页 1 条记录</td>
  </tr>
</table>
=======
		</tr>
		<tr>
			<td class="td07">1103</td>
			<td class="td07">朱佳宝</td>
			<td class="td07">脑残科</td>
			<td class="td07">2013-9-10</td>
			<td class="td07"><a href="guahaoEdit.jsp" target="mainFrame">&nbsp;&nbsp;详情</a>
				<a href="guahaoModify.jsp" target="mainFrame">&nbsp;&nbsp;修改</a> <a
				href="tuihao.jsp" target="mainFrame">&nbsp;&nbsp;退号</a></td>

		</tr>
		<tr>
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
		</tr>
		<tr>
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
		</tr>
	</table>
	<table width="95%" border="0" cellpadding="0" cellspacing="0"
		class="table02" align="center">
		<tr>
			<td height="30" align="right"><img
				src="${pageContext.request.contextPath}/images/1.gif" width="4"
				height="5" align="absmiddle"> 首页 <img
				src="${pageContext.request.contextPath}/images/2.gif" width="3"
				height="5" align="absmiddle"> 上一页 <img
				src="${pageContext.request.contextPath}/images/2-2.gif" width="3"
				height="5" align="absmiddle"> 下一页 <img
				src="${pageContext.request.contextPath}/images/3.gif" width="4"
				height="5" align="absmiddle"> 末页 共 1 页 1 条记录</td>
		</tr>
	</table>
	<table width="95%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="center"><input name="Return" type="button"
				class="buttonface" value="返回" onClick="history.back(-1)"></td>
		</tr>
	</table>
>>>>>>> branch 'liu' of https://github.com/msr-01/hospital-01.git
</body>
</html>
