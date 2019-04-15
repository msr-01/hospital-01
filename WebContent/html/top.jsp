<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Untitled Document</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath}/js/win_center.js"></script>
</head>

<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/images/index_02.gif">
  <tr>
    <td width="40"><img src="${pageContext.request.contextPath}/images/index_001.png" width="260" height="40"></td>
    <td align="right" valign="bottom"><table border="0" cellspacing="7" cellpadding="0">
      <tr>
        <td width="50" valign="bottom"><img src="${pageContext.request.contextPath}/images/index_05.gif" width="20" height="16" align="absbottom"><a href="#"  class="a02">后退</a></td>
        <td width="50" valign="bottom"><img src="${pageContext.request.contextPath}/images/index_07.gif" width="20" height="16" align="absbottom"><a href="#" class="a02">前进</a></td>
        <td width="50" valign="bottom"><img src="${pageContext.request.contextPath}/images/index_09.gif" width="20" height="16" align="absbottom"><a href="${pageContext.request.contextPath}/html/main.jsp" target="mainFrame" class="a02">首页</a></td>
        <td width="50" valign="bottom"><img src="${pageContext.request.contextPath}/images/index_11.gif" width="20" height="16" align="absbottom"><a href="${pageContext.request.contextPath}/UserInfosServlet?method=outlogin" target="_parent" class="a02">退出</a></td>

        </tr>
    </table></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="8"><img src="${pageContext.request.contextPath}/images/spacer.gif" width="1" height="1"></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/images/index_21.gif">
<form name="form1" method="post" action="">
  <tr>
    <td width="20" height="30">&nbsp;</td>
    <td class="F02"><img src="${pageContext.request.contextPath}/images/index_23.gif" width="26" height="30" align="absmiddle">${userInfos.uname } ${userInfos.ujobtitle }，您好! </td>
    <td width="14" class="F02"></td>
  </tr>
</form>
</table>
</body>
</html>