<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<div>
					<a class="one">挂号管理</a>
					<ul class="kid">
						<li><b class="tip"></b><a href="Guahao/lists.jsp"
							target="mainFrame" class="a03">挂号服务</a></li>
						<li><b class="tip"></b><a href="${pageContext.request.contextPath}/PatientinformationServlet?method=findAll&site=0"
							target="mainFrame" class="a03">查看患者信息</a></li>
						<li><b class="tip"></b><a href="Guahao/message.jsp"
							target="mainFrame" class="a03">信息查询</a></li>
					</ul>
				</div>
				<div>
					<a class="one">病历管理</a>
					<ul class="kid">
						<li><b class="tip"></b><a href="${pageContext.request.contextPath}/MedicalrecordSevlet?method=findAllMrecord&site=0"
							target="mainFrame" class="a03">病历信息查询</a></li>
						<li><b class="tip"></b><a href="${pageContext.request.contextPath}/MedicalrecordSevlet?method=redirect&site=0"
							target="mainFrame" class="a03">病历信息录入</a></li>
					</ul>
				</div>
				<div>
					<a class="one">划价管理</a>
					<ul class="kid">
						<li><b class="tip"></b><a href="${pageContext.request.contextPath}/PrescriptionSevlet?method=findAllPrescription&site=0"
							target="mainFrame" class="a03">划价收费</a></li>
					</ul>
				</div>
				<div>
					<a class="one">系统管理</a>
					<ul class="kid">
						<li><b class="tip"></b><a href="User/users.jsp"
							target="mainFrame" class="a03">用户管理</a></li>
						<li><b class="tip"></b><a
							href="doctor/doctor.jsp" target="mainFrame"
							class="a03">医生管理</a></li>
						<li><b class="tip"></b><a
							href="operationRoom/operationRoom.jsp" target="mainFrame"
							class="a03">科室管理</a></li>
						<li><b class="tip"></b><a
							href="medicine/medicine.jsp" target="mainFrame"
							class="a03">药品管理</a></li>
						<li><b class="tip"></b><a
							href="medicalproject/medicalproject.jsp" target="mainFrame"
							class="a03">医疗项目管理</a></li>
						<li><b class="tip"></b><a
							href="Popedom/popedomAttribute.jsp" target="mainFrame"
							class="a03">权限管理</a>
						</li>
					</ul>
				</div>
				<div id="datepicker"></div>
			</div>
		</div>
		<!--左边菜单结束-->
		<!--右边框架开始-->
	</div>
</body>
</html>