<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医院门诊管理系统</title>
</head>

<frameset rows="78,*" cols="*" frameborder="no" border="0"
	framespacing="0">
	<frame src="${pageContext.request.contextPath}/html/top.jsp" name="topFrame" scrolling="No" noresize="noresize"
		id="topFrame" title="topFrame" />
	<frameset cols="250,10,*" frameborder="no" border="0" framespacing="0"
		id="oa_frame">
		<frame src="${pageContext.request.contextPath}/html/left.jsp" name="leftFrame" scrolling="yes"
			noresize="noresize" id="leftFrame" title="leftFrame" />
		<frame src="${pageContext.request.contextPath}/html/middle.jsp" name="middleFrame" scrolling="No"
			noresize="noresize" id="middleFrame" title="middleFrame" />
		<frame src="${pageContext.request.contextPath}/html/main.jsp" name="mainFrame" scrolling="yes" id="mainFrame"
			title="mainFrame" />
	</frameset>
</frameset>
<noframes>
	<body>
	</body>
</noframes>
</html>