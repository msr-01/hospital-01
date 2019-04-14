<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>北京天桥医院</title>
<style type="text/css">

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow:hidden;
}
.STYLE3 {font-size: 12px; color: #adc9d9; }

</style>


</head>

<body>
<form action="${pageContext.request.contextPath}/UserInfosServlet?method=login" method="post" name="LoginForm">
<table width="100%"  height="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td bgcolor="#1075b1">&nbsp;</td>
  </tr>
  <tr>
    <td height="608" background="${pageContext.request.contextPath}/html/images/login_03.gif"><table width="847" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="318" background="${pageContext.request.contextPath}/html/images/login_04.gif">&nbsp;</td>
      </tr>
      <tr>
        <td height="84"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="381" height="84" background="${pageContext.request.contextPath}/html/images/login_06.gif">&nbsp;</td>
            <td width="162" valign="middle" background="${pageContext.request.contextPath}/html/images/login_07.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="44" height="24" valign="bottom"><div align="right"><span class="STYLE3">工号</span></div></td>
                <td width="10" valign="bottom">&nbsp;</td>
                <td height="24" colspan="2" valign="bottom">
                  <div align="left">
                    <c:choose>
                    	<c:when test="${empty err }"></c:when>
                    	<c:otherwise>
                    		<c:choose>
                    			<c:when test="${err eq 1 }">
                    				工号不存在！
                    			</c:when>
                    			<c:otherwise>
                    				密码错误！！
                    			</c:otherwise>
                    		</c:choose>
                    	</c:otherwise>
                    </c:choose>
                    <input type="text" name="jobnumber" id="jobnumber" style="width:100px; height:17px; background-color:#87adbf; border:solid 1px #153966; font-size:12px; color:#283439; ">
                  </div></td>
              </tr>
              <tr>
                <td height="24" valign="bottom"><div align="right"><span class="STYLE3">密码</span></div></td>
                <td width="10" valign="bottom">&nbsp;</td>
                <td height="24" colspan="2" valign="bottom"><input type="password" name="upassword" id="upassword" style="width:100px; height:17px; background-color:#87adbf; border:solid 1px #153966; font-size:12px; color:#283439; "></td>
              </tr>
              <tr></tr>
            </table></td>
            <td width="26"><img src="${pageContext.request.contextPath}/html/images/login_08.gif" width="26" height="84"></td>
            <td width="67" background="${pageContext.request.contextPath}/html/images/login_09.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="25"><div align="center"><input type="submit" value="登录" width="57" height="20"></a></div></td>
              </tr>
              <tr>
                <td height="25"><div align="center"><input type="reset" value="重置" width="57" height="20"></div></td>
          
              </tr>
            </table></td>
            <td width="211" background="${pageContext.request.contextPath}/html/images/login_10.gif">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="206" background="${pageContext.request.contextPath}/html/images/login_11.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td bgcolor="#152753">&nbsp;</td>
  </tr>
</table>
</form>
</body>
</html>