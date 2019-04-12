<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试页面</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty uList }">
		
		</c:when>
		<c:otherwise>
		<c:forEach var="userInfos" items="${uList }">
			工号：${userInfos.jobnumber }
			<br>
			密码：${userInfos.upassword }
			<br>
		</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>