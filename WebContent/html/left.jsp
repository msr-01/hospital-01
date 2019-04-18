<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理系统</title>
<link rel="stylesheet" type="text/css" href="style/admin-all.css" />
<link rel="stylesheet" type="text/css" href="style/base.css" />
<link rel="stylesheet" type="text/css" href="style/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="style/jquery-ui-1.8.22.custom.css" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath}/js/tree.js"></script>
<script type="text/javascript" src="style/jquery-1.7.2.js"></script>
<script type="text/javascript"
	src="style/jquery-ui-1.8.22.custom.min.js"></script>
<script type="text/javascript" src="style/index.js"></script>
</head>
<body>
	<div>
		<div class="left_c left" style="top: 10px">
			<h1>系统操作菜单</h1>
			<div class="acc">
				<c:if test="${fn:contains(userInfos.characte.rolepermissions.popedom , 'a' ) or fn:contains(userInfos.characte.rolepermissions.popedom , 'b' ) or fn:contains(userInfos.characte.rolepermissions.popedom , 'c' )}">
					<div>
						<a class="one">挂号管理</a>
						<ul class="kid">
							<c:if test="${fn:contains(userInfos.characte.rolepermissions.popedom , 'a' )}">
								<li><b class="tip"></b><a href="Guahao/lists.jsp"
								target="mainFrame" class="a03">挂号服务</a></li>
							</c:if>
							<c:if test="${fn:contains(userInfos.characte.rolepermissions.popedom , 'b' )}">
								<li><b class="tip"></b><a href="${pageContext.request.contextPath}/PatientinformationServlet?method=findAll&site=0"
								target="mainFrame" class="a03">查看患者信息</a></li>
							</c:if>
							<c:if test="${fn:contains(userInfos.characte.rolepermissions.popedom , 'c' )}">
								<li><b class="tip"></b><a href="Guahao/message.jsp"
								target="mainFrame" class="a03">信息查询</a></li>
							</c:if>
							
						</ul>
					</div>
				</c:if>
				
				<c:if test="${fn:contains(userInfos.characte.rolepermissions.popedom , 'd' ) or fn:contains(userInfos.characte.rolepermissions.popedom , 'e' )}">
					<div>
						<a class="one">病历管理</a>
						<ul class="kid">
							<c:if test="${fn:contains(userInfos.characte.rolepermissions.popedom , 'd' )}">
								<li><b class="tip"></b><a href="${pageContext.request.contextPath}/MedicalrecordSevlet?method=findAllMrecord&site=0"
								target="mainFrame" class="a03">病历信息查询</a></li>
							</c:if>
							<c:if test="${fn:contains(userInfos.characte.rolepermissions.popedom , 'e' )}">
								<li><b class="tip"></b><a href="${pageContext.request.contextPath}/MedicalrecordSevlet?method=redirect&site=0"
								target="mainFrame" class="a03">病历信息录入</a></li>
							</c:if>
							
						</ul>
					</div>
				</c:if>
				<c:if test="${fn:contains(userInfos.characte.rolepermissions.popedom , 'f' )}">
					<div>
						<a class="one">划价管理</a>
						<ul class="kid">
							<li><b class="tip"></b><a href="${pageContext.request.contextPath}/PrescriptionSevlet?method=findAllPrescription&site=0"
								target="mainFrame" class="a03">划价收费</a></li>
						</ul>
					</div>
				</c:if>
				<c:if test="${fn:contains(userInfos.characte.rolepermissions.popedom , 'g' ) or fn:contains(userInfos.characte.rolepermissions.popedom , 'h' ) or fn:contains(userInfos.characte.rolepermissions.popedom , 'i' ) or fn:contains(userInfos.characte.rolepermissions.popedom , 'j' ) or fn:contains(userInfos.characte.rolepermissions.popedom , 'k' ) or fn:contains(userInfos.characte.rolepermissions.popedom , 'l' )}">
					<div>
						<a class="one">系统管理</a>
						<ul class="kid">
							<c:if test="${fn:contains(userInfos.characte.rolepermissions.popedom , 'g' )}">
								<li><b class="tip"></b><a href="${pageContext.request.contextPath}/UserInfosServlet?method=findAllUser&site=0"
								target="mainFrame" class="a03">用户管理</a></li>
							</c:if>
							<c:if test="${fn:contains(userInfos.characte.rolepermissions.popedom , 'h' )}">
								<li><b class="tip"></b><a
								href="${pageContext.request.contextPath}/DoctorsSevlet?method=findAllDoctors&site=1" target="mainFrame"
								class="a03">医生管理</a></li>
							</c:if>
							<c:if test="${fn:contains(userInfos.characte.rolepermissions.popedom , 'i' )}">
								<li><b class="tip"></b><a
								href="operationRoom/operationRoom.jsp" target="mainFrame"
								class="a03">科室管理</a></li>
							</c:if>
							<c:if test="${fn:contains(userInfos.characte.rolepermissions.popedom , 'i' )}">
								<li><b class="tip"></b><a
								href="medicine/medicine.jsp" target="mainFrame"
								class="a03">药品管理</a></li>
							</c:if>
							<c:if test="${fn:contains(userInfos.characte.rolepermissions.popedom , 'i' )}">
								<li><b class="tip"></b><a
								href="medicalproject/medicalproject.jsp" target="mainFrame"
								class="a03">医疗项目管理</a></li>
							</c:if>
							<c:if test="${fn:contains(userInfos.characte.rolepermissions.popedom , 'i' )}">
								<li><b class="tip"></b><a
								href="${pageContext.request.contextPath}/CharacteServlet?method=getAllCaracte&site=0" target="mainFrame"
								class="a03">权限管理</a>
							</li>
							</c:if>
							<li><b class="tip"></b><a
								href="${pageContext.request.contextPath}/OperationRecordServlet?method=findAllOR&site=0" target="mainFrame"
								class="a03">操作记录</a>
							</li>
						</ul>
					</div>
				</c:if>
				<div id="datepicker"></div>
			</div>
		</div>
		<!--左边菜单结束-->
		<!--右边框架开始-->
	</div>
</body>
</html>