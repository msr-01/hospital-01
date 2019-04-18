<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css">
<script language="javascript"
	src="${pageContext.request.contextPath}/js/check.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/js/checkAll.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/js/clientSideApp.js"></script>
<SCRIPT language=JavaScript type=text/JavaScript>
	function windowOpen(theURL, winName, features, width, hight, scrollbars,
			top, left) {
		var parameter = "top=" + top + ",left=" + left + ",width=" + width
				+ ",height=" + hight;
		if (scrollbars == "no") {
			parameter += ",scrollbars=no";
		} else {
			parameter += ",scrollbars=yes";
		}
		window.open(theURL, winName, parameter);
	}
</SCRIPT>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="25" align="center" valign="bottom" class="td06"><table
					width="98%" border="0" cellspacing="3" cellpadding="0">
					<tr>
						<td width="15"><img
							src="${pageContext.request.contextPath}/images/index_32.gif"
							width="9" height="9"></td>
						<td valign="bottom" class="title">权限管理</td>
					</tr>
				</table></td>
		</tr>
	</table>
	<br>
	<table width="60%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td class="td_page">
				角色类型：
				<select name="select3">
					<option>--请选择--</option>
					<option>前台</option>
					<option>医生</option>
					<option>管理员</option>
				</select>
			</td>
		</tr>
	</table>
	<br>
	<table width="60%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table01">
		<tr align="center">
			<td class="td_top" width="25%" style="border-right:1px solid white">根权限</td>
			<td class="td_top" width="70%">子权限</td>
		</tr>
		<tr align="center">
			<td class="td07" width="25%" style="border-right:1px solid #B3CFE8">挂号管理</td>
			<td class="td07" width="70%">
				<input type="checkbox"  name="guahao" value="a" >挂号服务
				&nbsp;&nbsp;&nbsp;
				<input type="checkbox"  name="chakanhuanzhe" value="a" >查看患者信息
				&nbsp;&nbsp;&nbsp;
				<input type="checkbox"  name="xinxichaxun" value="a" >信息查询
			</td>
		</tr>
		<tr align="center">
			<td class="td07" width="25%" style="border-right:1px solid #B3CFE8">病历管理</td>
			<td class="td07" width="70%">
				<input type="checkbox"  name="binglichaxun" value="a" >病历信息查询
				&nbsp;&nbsp;&nbsp;
				<input type="checkbox"  name="bingliluru" value="a" >病历信息录入
			</td>
		</tr>
		<tr align="center">
			<td class="td07" width="25%" style="border-right:1px solid #B3CFE8">划价管理</td>
			<td class="td07" width="70%">
				<input type="checkbox"  name="huajiachaxun" value="a" >划价查询
			</td>
		</tr>
		<tr align="center">
			<td class="td07" width="25%" style="border-right:1px solid #B3CFE8">系统管理</td>
			<td class="td07" width="70%">
				<input type="checkbox"  name="user" value="a" >用户管理
				&nbsp;&nbsp;&nbsp;
				<input type="checkbox"  name="doctor" value="a" >医生管理
				&nbsp;&nbsp;&nbsp;
				<input type="checkbox"  name="operationRoom" value="a" >科室管理
				&nbsp;&nbsp;&nbsp;
				<input type="checkbox"  name="medicine" value="a" >药品管理
				&nbsp;&nbsp;&nbsp;
				<input type="checkbox"  name="medicalproject" value="a" >医疗项目管理
				&nbsp;&nbsp;&nbsp;
				<input type="checkbox"  name="popedom" value="a" >权限管理
				&nbsp;&nbsp;&nbsp;
				<input type="checkbox"  name="operationRecord" value="a" >操作记录
			</td>
		</tr>
	</table>
	<br>
	<br>
	<table width="60%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">
					<input name=save type="button" class=buttonface value="保存" onclick="location.href='#'">
				</td>
			</tr>
	</table>
</body>
</html>

