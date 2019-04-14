<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的申报</title>
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
        <td valign="bottom" class="title">药品详细信息
          <a href="medicalInfo.jsp" style="list-style-type: none" class="buttonface11" id="buttonface2">返回</a>
        </td>
      </tr>
    </table></td>
  </tr>
</table>
<br>


<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
   <tr>
     <td width="90" height="24" class="td_form01">药品编号</td>
     <td class="td_form02">xy0012</td>
   </tr>	
      <tr>
        <td height="24" class="td_form01">药品名称</td>
        <td class="td_form02">感冒灵</td>
   </tr>	
      <tr>
        <td height="24" class="td_form01">药品规格</td>
        <td class="td_form02">12粒/片<br>2片/盒</td>
   </tr>	
      <tr>
        <td height="24" class="td_form01">药品单价</td>
        <td class="td_form02">15.0</td>
   </tr>	
      <tr>
        <td height="24" class="td_form01">药品功能</td>
        <td class="td_form02">主治感冒、发烧</td>
   </tr>	
      <tr>
        <td height="24" class="td_form01">有效期</td>
        <td class="td_form02">三年</td>
   </tr>	
      <tr>
        <td height="24" class="td_form01">药品库存</td>
        <td class="td_form02">1200盒</td>
   </tr>	
        
</table>
</body>
</html>
