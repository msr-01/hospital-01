<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"> </script>
<script type="text/javascript">
	$(function(){
		$("#role").change(function(){
			
			location.href="${pageContext.request.contextPath}/CharacteServlet?method=getoneCaracte&site=0&cid="+$('#role').val();
		});
	});

</script>
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
				<select name="select3" id="role">
					<option>--请选择--</option>
					<c:forEach var="c" items="${clist }">
						<option value="${c.roleName.rid }">${c.roleName.rname }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
	</table>
	<br>
	<form action="${pageContext.request.contextPath}/CharacteServlet?method=changerole&site=0&cid=${characte.cid}" method="post">
	<table width="60%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table01">
		<tr align="center">
			<c:choose>
				<c:when test="${empty characte }">
					<td >当前角色</td>
					<td >未选中</td>
				</c:when>
					
				<c:otherwise>
					<td >当前角色</td>
					<td >${characte.roleName.rname }</td>
				</c:otherwise>
			</c:choose>
			
			
		</tr>
		<tr align="center">
			<td class="td_top" width="25%" style="border-right:1px solid white">根权限</td>
			<td class="td_top" width="70%">子权限</td>
		</tr>
		<tr align="center">
			<td class="td07" width="25%" style="border-right:1px solid #B3CFE8">挂号管理</td>
			<td class="td07" width="70%">
				<c:choose>
					<c:when test="${fn:contains(characte.rolepermissions.popedom , 'a')}">
						<input type="checkbox"  name="ra" value="0" checked="checked">挂号服务
						&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:otherwise>
						<input type="checkbox"  name="ra" value="0" >挂号服务
						&nbsp;&nbsp;&nbsp;
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${fn:contains(characte.rolepermissions.popedom , 'b')}">
						<input type="checkbox"  name="rb" value="0" checked="checked">查看患者信息
						&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:otherwise>
						<input type="checkbox"  name="rb" value="0" >查看患者信息
						&nbsp;&nbsp;&nbsp;
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${fn:contains(characte.rolepermissions.popedom , 'c')}">
						<input type="checkbox"  name="rc" value="0" checked="checked">信息查询
					</c:when>
					<c:otherwise>
						<input type="checkbox"  name="rc" value="0" >信息查询
					</c:otherwise>
				</c:choose>
				
				
			</td>
		</tr>
		<tr align="center">
			<td class="td07" width="25%" style="border-right:1px solid #B3CFE8">病历管理</td>
			<td class="td07" width="70%">
				<c:choose>
					<c:when test="${fn:contains(characte.rolepermissions.popedom , 'd')}">
						<input type="checkbox"  name="rd" value="0" checked="checked">病历信息查询
						&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:otherwise>
						<input type="checkbox"  name="rd" value="0" >病历信息查询
						&nbsp;&nbsp;&nbsp;
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${fn:contains(characte.rolepermissions.popedom , 'e')}">
						<input type="checkbox"  name="re" value="0" checked="checked">病历信息录入
					</c:when>
					<c:otherwise>
						<input type="checkbox"  name="re" value="0" >病历信息录入
					</c:otherwise>
				</c:choose>
				
			</td>
		</tr>
		<tr align="center">
			<td class="td07" width="25%" style="border-right:1px solid #B3CFE8">划价管理</td>
			<td class="td07" width="70%">
				<c:choose>
					<c:when test="${fn:contains(characte.rolepermissions.popedom , 'f')}">
						<input type="checkbox"  name="rf" value="0" checked="checked">划价查询
					</c:when>
					<c:otherwise>
						<input type="checkbox"  name="rf" value="0" >划价查询
					</c:otherwise>
				</c:choose>
				
			</td>
		</tr>
		<tr align="center">
			<td class="td07" width="25%" style="border-right:1px solid #B3CFE8">系统管理</td>
			<td class="td07" width="70%">
				<c:choose>
					<c:when test="${fn:contains(characte.rolepermissions.popedom , 'g')}">
						<input type="checkbox"  name="rg" value="0" checked="checked">用户管理
						&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:otherwise>
						<input type="checkbox"  name="rg" value="0" >用户管理
						&nbsp;&nbsp;&nbsp;
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${fn:contains(characte.rolepermissions.popedom , 'h')}">
						<input type="checkbox"  name="rh" value="0" checked="checked">医生管理
						&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:otherwise>
						<input type="checkbox"  name="rh" value="0" >医生管理
						&nbsp;&nbsp;&nbsp;
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${fn:contains(characte.rolepermissions.popedom , 'i')}">
						<input type="checkbox"  name="ri" value="0" checked="checked">科室管理
						&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:otherwise>
						<input type="checkbox"  name="ri" value="0" >科室管理
						&nbsp;&nbsp;&nbsp;
					</c:otherwise>
				</c:choose>
				<br>
				<c:choose>
					<c:when test="${fn:contains(characte.rolepermissions.popedom , 'j')}">
						<input type="checkbox"  name="rj" value="0" checked="checked">药品管理
						&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:otherwise>
						<input type="checkbox"  name="rj" value="0" >药品管理
						&nbsp;&nbsp;&nbsp;
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${fn:contains(characte.rolepermissions.popedom , 'k')}">
						<input type="checkbox"  name="rk" value="0" checked="checked">医疗项目管理
						&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:otherwise>
						<input type="checkbox"  name="rk" value="0" >医疗项目管理
						&nbsp;&nbsp;&nbsp;
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${fn:contains(characte.rolepermissions.popedom , 'l')}">
						<input type="checkbox"  name="rl" value="0" checked="checked">权限管理
						&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:otherwise>
						<input type="checkbox"  name="rl" value="0" >权限管理
						&nbsp;&nbsp;&nbsp;
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
	<br>
	<br>
	<table width="60%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">
					<input name=save type="submit" class=buttonface value="保存" onclick="location.href='#'">
				</td>
			</tr>
	</table>
	</form>
</body>
</html>

