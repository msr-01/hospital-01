<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告信息的修改</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">

<script language="javascript">
function display1()
{
if(document.getElementById("mycheckbox1").checked == true)
{
document.getElementById("droplist1").style.display="";
}
else
{
document.getElementById("droplist1").style.display="none";
}
}
</script>
<script language="javascript">
function display2()
{
if(document.getElementById("mycheckbox2").checked == true)
{
document.getElementById("droplist2").style.display="";
}
else
{
document.getElementById("droplist2").style.display="none";
}
}
</script>
<script language="javascript">
function display3()
{
if(document.getElementById("mycheckbox3").checked == true)
{
document.getElementById("droplist3").style.display="";
}
else
{
document.getElementById("droplist3").style.display="none";
}
}
</script>

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" 

cellpadding="0">
          <tr>
            <td width="15"><img src="${pageContext.request.contextPath}/images/index_32.gif" width="9" height="9"></td>
            <td valign="bottom">公告信息的修改</td>
          </tr>
      </table></td>
    </tr>
  </table>
  <form name="form1" method="post" action="">
    <table width=95% border=0 align=center cellpadding=0 cellspacing=0>
      <tr align="left" nowrap>
        <td width="78" height="24" align="center"  class=td_form01>公告类型</td>
        <td colspan="3" align="left"  class=td_form02><input name="textfield22" type="text" class="input" 

size="45"></td>
</tr>
<tr>
        <td width="146" align="center"  class=td_form01>公告内容</td>
        <td colspan="3" align="left"   class=td_form02>
        <textarea name="textarea" id="textarea" cols="100" rows="5"></textarea>
        </td>
      </tr>

</tr>
     
    </table>
    
    
  <table align="center">
       <tr>
        <td >
          <input name=save  type=button class=buttonface value= '  提交  '  onclick="   ">        
        <input name="Submit" type="submit" class="buttonface" value="  重置  " ></td>
      </tr>
   </table>



  </form>
</center>
</body>
</html>
