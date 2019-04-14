<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" cellpadding="0">
          <tr>
            <td width="15"><img src="${pageContext.request.contextPath}/images/index_32.gif" width="9" height="9"></td>
            <td valign="bottom" class="title">挂号详情</td>
          </tr>
      </table></td>
    </tr>
  </table>
  <form name="form1" method="post" action="">
    <table width="95%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="90" height="24" class="td_form01">病人姓名</td>
        <td class="td_form02">张三</td>
         <td width="90" class="td_form01">病人性别</td>
          <td class="td_form02">男</td>
      </tr>
      
      
       <tr>  
        <td width="90" class="td_form01">科室名称</td>
        <td class="td_form02">骨科</td>
      
       <td width="90" class="td_form01">挂号类型</td>
        <td class="td_form02">急诊</td>        
        </tr>
      
     
        
          <td width="90" height="24" class="td_form01">挂号费用</td>
        <td class="td_form02">￥30</td>
         <td width="90" height="24" class="td_form01">挂号日期</td>
        <td class="td_form02"><input name="textfield24" type="text" class="input"></td>
      </tr>
      
        <tr>                 
        <td width="90" class="td_form01">操作人员</td>
        <td class="td_form02">习小平</td> 
        <td width="90" height="24" class="td_form01">就诊时间</td>
        <td class="td_form02"><input name="textfield24" type="text" class="input"></td>  
      </tr>  
      
         
        <tr>       
        <td width="90" height="24" class="td_form01">就诊地点</td>
        <td class="td_form02">二楼骨科室</td>
       
   
      </tr>  

      </tr>  
      
       
    </table>
    <br>
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center">
          <input name=save  type=button class=buttonface value= '  提交  '  onclick="location.href='${pageContext.request.contextPath}/html/media/applicationlist_1.jsp'">        
        <input name="Submit" type="submit" class="buttonface" value="  取消  " onClick="history.back(-1)"></td>
      </tr>
    </table>
    <p>&nbsp;</p>
    <p><br>
    </p>
  </form>
</center>
</body>
</html>
