<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>病历的录入</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="${pageContext.request.contextPath}/js/clientSideApp.js"></script>
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
        <td valign="bottom" class="title">病例的录入</td>
      </tr>
    </table></td>
  </tr>
</table>
<br>
<table width="95%" border="0" align="center" cellspacing="0" cellpadding="0">
    <tr>

        <td class="td_form01">就诊卡号</td>
        <td class="td_form02"><input name="textfield22" type="text" class="input" size="50"></td>   
         <td height="24" class="td_form01">病历编号</td>
        <td nowrap class=td_form02><input name="textfield2" type="text" class="input" size="50" ></td>    
      </tr>
       <tr>  
        <td width="120" class="td_form01">病人姓名</td>
        <td nowrap class=td_form02><input name="textfield2" type="text" class="input" size="50" ></td>
        <td height="24" class="td_form01">病人性别</td>
        <td nowrap class=td_form02><input type="radio"  class="ipt" name="sex" checked="checked"/>男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  class="ipt" name="sex"/>女</td>
       </tr>
        <td class="td_form01">病人年龄</td>
        <td class="td_form02"><input name="textfield22" type="text" class="input" size="50"></td>
        <td class="td_form01">就诊科室</td>
        <td class="td_form02">
          <select name="select">
            <option>内科</option>
            <option>外科</option>
            <option selected="selected">儿科</option>
            <option>妇产科</option>
            <option>骨科</option>
            <option>眼科</option>
            <option>口腔科</option>
            <option>五官科</option>
            <option>肿瘤科</option>
            <option>皮肤病科</option>
            <option>中医科</option>
          </select></td>
       
    </tr>
    
   <tr>
       <td class="td_form01">联系电话</td>
       <td class="td_form02"><input name="textfield2211" type="text" class="input" size="50"></td>
       <td class="td_form01">主治医生</td>
        <td class="td_form02"> <input name="textfield2" type="text" class="input" size="50"></td>
    </tr>
   
   
</table>
<br>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center"><input name="submit" type="button" class="buttonface" value="  提交  " onClick="window.location.href='P_infor.jsp'">
    &nbsp;&nbsp;&nbsp;&nbsp;   
    <input name="reset" type="button" class="buttonface" value="  返回  " onClick="window.location.href='P_infor.jsp'"></td>
  </tr>
</table>
<br>
</body>
</html>
   