<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">

<title>无标题文档</title>
</head>
     <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="td_page">病人姓名：
    <input name="PARA_YM_NOW" size="10" type="text" class="input"   id="PARA_YM_NOW" next="A001014" alt="查询年月|0|d|||" value="" onFocus="{obtainFocus(this),this.select()}" onKeyPress="gotoNextInput(this)" onBlur="matchInput(this)" readonly>
<input name="Submit" type="submit" class="buttonface" value=" 查询 "></td>
  </tr>
</table>

<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
   <tr>
      <td class="td_top">就诊卡号</td>
      <td class="td_top">病历编号</td>
      <td class="td_top">姓名</td>
   </tr>
   
   <tr>
    <td class="td07">1103</td>
    <td class="td07">309</td>
    <td class="td07">张三
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;
    <a href="patientInfo.jsp">详情</a></td>
  </tr>



</table>

<body>
</body>
</html>
