<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" cellpadding="0">
      <tr>
        <td width="15"><img src="${pageContext.request.contextPath}/images/index_32.gif" width="9" height="9"></td>
        <td valign="bottom" class="title">修改用户
          <a href="medicalInfo.jsp" style="list-style-type: none" class="buttonface11" id="buttonface2">返回</a>
        </td>
      </tr>
    </table></td>
  </tr>
</table>
<br>


<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  
      <tr>
        <td height="24" class="td_form01">登录名</td>
        <td class="td_form02"><input name="textfield24" type="text" class="input" value="zs"></td>  
   </tr>	
   
      <tr>
        <td height="24" class="td_form01">用户姓名</td>
          <td class="td_form02"><input name="textfield24" type="text" class="input" value="张三"></td>
   </tr>	
	  
</table>


  <table align="center">
       <tr>
        <td >
          <input name=save  type=button class=buttonface value= '  提交  '  onclick="   ">        
        <input name="Submit" type="submit" class="buttonface" value="  重置  " ></td>
      </tr>
   </table>

</body>
</html>
