<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人设置</title>
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
<style type="text/css">
<!--
.style1 {font-size: 14px}
.style2 {color: #333333}
-->
</style>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" cellpadding="0">
      <tr>
        <td width="15" height="23"><img src="${pageContext.request.contextPath}/images/index_32.gif" width="9" height="9"></td>
        <td valign="bottom" class="title">个人设置</td>
      </tr>
    </table></td>
  </tr>
</table>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
<td width="79%" class="td_page style1">--基本信息-- <a href="lawset.jsp" class="style2">用户密码修改</a>--</td>
</table>

<table width="95%" border="0" cellpadding="2" cellspacing="0" align="center">
  <tr> 
    <td width="272" class="td_form01"><div align="right">用户名称：</div></td>
    <td width="481" class="td_form02"><div align="left">net</div></td> 
 </tr>
  
   <tr> 
    <td width="272" class="td_form01"><div align="right">所属单位：</div></td>
    <td width="481" class="td_form02"><div align="left">网络中心</div></td> 
 </tr>
   <tr> 
    <td width="272" class="td_form01"><div align="right">所属处室：</div></td>
    <td width="481" class="td_form02"><div align="left">网络中心</div></td> 
 </tr>
   <tr> 
    <td width="272" class="td_form01"><div align="right">性别：</div></td>
    <td width="481" class="td_form02"><div align="left">男</div></td> 
 </tr>
  
  
  
  
  
   <tr> 
    <td width="272" class="td_form01"><div align="right">手机：</div></td>
    <td width="481" class="td_form02"><div align="left"></div></td> 
 </tr>
   <tr> 
    <td width="272" class="td_form01"><div align="right">电子信箱：</div></td>
    <td width="481" class="td_form02"><div align="left">net@163.com</div></td> 
 </tr>
   <tr> 
    <td width="272" class="td_form01"><div align="right">当前状态：</div></td>
    <td width="481" class="td_form02"><div align="left">已注册</div></td> 
 </tr>
   
</table>
<br>
<br>
</body>
</html>