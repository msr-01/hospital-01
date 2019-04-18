<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css">
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
						<td valign="bottom" class="title">添加用户</td>
					</tr>
				</table></td>
		</tr>
	</table>
	<form name="form1" method="post" action="${pageContext.request.contextPath}/UserInfosServlet?method=modifyUser&site=1&uid=${userinfos.uid}">
		<table width="95%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="90" height="24" class="td_form01">工号</td>
				<td class="td_form02"><input name="jobnumber" type="text"
					class="input" value="${userinfos.jobnumber }"></td>
				<td width="90" height="24" class="td_form01">登陆密码</td>
				<td class="td_form02"><input name="upassword" type="text"
					class="input" value="${userinfos.upassword }"></td>
			</tr>
			<tr>
				<td width="90" height="24" class="td_form01">姓名</td>
				<td class="td_form02"><input name="uname" type="text"
					class="input" value="${userinfos.uname }"></td>
				<td width="90" height="24" class="td_form01">性别</td>
				<td class="td_form02"><input name="usex" type="text"
					class="input" value="${userinfos.usex }"></td>
			</tr>
			<tr>
				<td width="90" height="24" class="td_form01">年龄</td>
				<td class="td_form02"><input name="uage" type="text"
					class="input" value="${userinfos.uage }"></td>
				<td width="90" height="24" class="td_form01">角色</td>
				<td class="td_form02"><select name="cid">
						<option>${userinfos.characte.roleName.rname }</option>
						<option value="3">前台</option>
						<option value="2">医生</option>
						<option value="1">系统管理员</option>
				</select></td>
			</tr>
			<tr>
				<td width="90" height="24" class="td_form01">职称</td>
				<td class="td_form02"><select name="ujobtitle">
						<option>${userinfos.ujobtitle }</option>
						<option>院长</option>
						<option>主任</option>
						<option>专家</option>
						<option>主治医师</option>
						<option>实习医生</option>
						<option>前台</option>
						<option>系统管理员</option>
				</select></td>
				<td width="90" height="24" class="td_form01">电话</td>
				<td class="td_form02"><input name="uphonenumber" type="text"
					class="input" value="${userinfos.uphonenumber }"></td>
			</tr>
			<tr>
				<td width="90" height="24" class="td_form01">邮箱</td>
				<td class="td_form02"><input name="uemail" type="text"
					class="input" value="${userinfos.uemail }"></td>
				<td width="90" height="24" class="td_form01">状态</td>
				<td class="td_form02"><select name="ustatus">
						<option>${userinfos.ustatus }</option>
						<option value="1">在职</option>
						<option value="0">休假</option>
						<option>失踪</option>
				</select></td>
			</tr>
			<tr>
				<td width="90" height="24" class="td_form01">用户描述</td>
				<td class="td_form02"><input name="udescription" type="text"
					class="input" value="${userinfos.udescription }"></td>
			</tr>
		</table>
		<br>
		<table width="95%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center">
					<input name=save type="submit" class=buttonface value="提交" onclick="location.href='#'">
					<input name="Reset" type="button" class="buttonface" value="重置" onClick="location.href='#'">
					<input name="Return" type="button" class="buttonface" value="返回" onClick="history.back(-1)">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
