<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询诊断信息</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<SCRIPT language=JavaScript type=text/JavaScript>
function windowOpen(theURL,winName,features,width,hight,scrollbars,top,left) 
{
  var parameter="top="+top+",left="+left+",width="+width+",height="+hight;
  if(scrollbars=="no")
 {parameter+=",scrollbars=no";}
  else
 {parameter+=",scrollbars=yes";}
  window.open(theURL,winName,parameter);
}
</SCRIPT>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" cellpadding="0">
      <tr>
        <td width="15"><img src="${pageContext.request.contextPath}/images/index_32.gif" width="9" height="9"></td>
        <td valign="bottom" class="title">查询诊断信息
        <a href="Z_Record.jsp" style="list-style-type: none" class="buttonface11" id="buttonface2">返回</a>
        </td>
      </tr>
    </table></td>
  </tr>
</table>
<br>
<table  width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr class="td_page" >
    <td >
          就诊卡号：
      <input name="PARA_YM_NOW" size="20" type="text" class="input" id="PARA_YM_NOW" value="11"> &nbsp;&nbsp;
          病历编号：
      <input name="PARA_YM_NOW" size="20" type="text" class="input" id="PARA_YM_NOW" value="ZY0001"> &nbsp;&nbsp;
          姓名：
      <input name="PARA_YM_NOW" size="20" type="text" class="input" id="PARA_YM_NOW" value=""> &nbsp;&nbsp;
<input name="Submit" type="button" class="buttonface" onClick="window.location.href='Z_infor.jsp'" value="  查询  ">
    </td>
  </tr>
</table>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
  <tr> 
    <td width="24%" nowrap class="td_top">就诊卡号</td>
    <td width="24%" nowrap class="td_top">病历编号</td>
    <td width="24%" nowrap class="td_top">姓名</td>
   <td width="24%" nowrap class="td_top">查看详细</td>
  </tr>

  <tr> 
    <td class="td_02">11</td>
    <td class="td_02">ZY0001</td>
    <td class="td_02">东方不败</td>
   
    <td class="td_02"><a href="C_Z.jsp" target="mainFrame">&nbsp;&nbsp;>>详细</a></td>
  </tr>
  <tr> 
    <td class="td_02">12</td>
    <td class="td_02">ZY0002</td>
    <td class="td_02">西方必败</td>
   
    <td class="td_02"><a href="C_Z.jsp" target="mainFrame">&nbsp;&nbsp;>>详细</a></td>
  </tr>
  <tr> 
    <td class="td_02">13</td>
    <td class="td_02">ZY0003</td>
    <td class="td_02">饕餮</td>
   
    <td class="td_02"><a href="C_Z.jsp" target="mainFrame">&nbsp;&nbsp;>>详细</a></td>
  </tr>
</table>
<table width="95%"  border="0" cellpadding="0" cellspacing="0" class="table02" align="center">
  <tr>
    <td height="30" align="right"><img src="${pageContext.request.contextPath}/images/1.gif" width="4" height="5" align="absmiddle"> 首页　 <img src="${pageContext.request.contextPath}/images/2.gif" width="3" height="5" align="absmiddle"> 上一页　 <img src="${pageContext.request.contextPath}/images/2-2.gif" width="3" height="5" align="absmiddle"> 下一页　 <img src="${pageContext.request.contextPath}/images/3.gif" width="4" height="5" align="absmiddle"> 末页　　共 1 页 1 条记录</td>
  </tr>
</table>

</body>
</html>