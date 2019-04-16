<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"> </script>
<script type="text/javascript">
	$(function(){
		var d = new Date();
		$("#time").val( d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate()+" "+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds());
		
		$("#branch").change(function(){
			$.post("../../JSONSevlet",{tyid:$("#type").val(),brid:$("#branch").val(),method:1},function(data){
				var JSONobj = JSON.parse(data);	
				
				$("#doctor").empty();
				$("#doctor").append("<option value=''>"+"请选择"+"</option>");
				$.each(JSONobj,function(index,doctors){
					$("#doctor").append("<option value='"+doctors.doid+"'>"+doctors.userInfos.uname+"</option>");
				});
			});
			
			$.post("../../JSONSevlet",{brid:$("#branch").val(),method:2},function(data){
				var br = JSON.parse(data);	
				$("#location").val(br.brlocation);
			});
		});
		
		$("#type").change(function(){
			$.post("../../JSONSevlet",{tyid:$("#type").val(),brid:$("#branch").val(),method:1},function(data){
				var JSONobj = JSON.parse(data);	
				$("#doctor").empty();
				$("#doctor").append("<option value=''>"+"请选择"+"</option>");
				$.each(JSONobj,function(index,doctors){
					$("#doctor").append("<option value='"+doctors.doid+"'>"+doctors.userInfos.uname+"</option>");
				});
			});
		});
		
		$("#doctor").change(function(){
			$.post("../../JSONSevlet",{doid:$("#doctor").val(),method:3},function(data){
				var cost = JSON.parse(data);	
				$("#cost").val(cost.rfcost);	
			});
		});
		
		$("#search").click(function(){
			$.post("../././JSONSevlet",{piid:$("#piid").val(),method:4},function(data){
				if(data == ''){
					alert("不存在这个就诊卡号，请重新输入或申请新卡");
				}else{
					var pd = JSON.parse(data);	
					$("#piname").val(pd.piname);	
					$("#pisex").val(pd.pisex);	
					$("#piage").val(pd.piage);
				}
					
			});
		});
	});
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<center>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="25" align="center" valign="bottom" class="td06"><table
						width="98%" border="0" cellspacing="3" cellpadding="0">
						<tr>
							<td width="15"><img
								src="${pageContext.request.contextPath}/images/index_32.gif"
								width="9" height="9"></td>
							<td valign="bottom" class="title">挂号服务</td>
						</tr>
					</table></td>
			</tr>
		</table>
		<form name="form1" method="post" action="${pageContext.request.contextPath}/RegisteredServlet?method=addRegistered&site=0">
			<table width="95%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="90" height="24" class="td_form01">就诊卡号</td>
					<td width="400" class="td_form02">
					<input name="piid" type="text" class="input" id="piid">
					<input name="button" type="button" class="buttonface" value="查询" id="search">
						</td>
					<td width="90" height="24" class="td_form01">患者姓名</td>
					<td class="td_form02"><input name="piname" type="text"
						class="input" id="piname"></td>
				</tr>
				<tr>
					<td width="90" height="24" class="td_form01">患者性别</td>
					<td class="td_form02"><select name="pisex" id="pisex">
							<option>--请选择--</option>
							<option>男</option>
							<option>女</option>
					</select></td>
					<td width="90" height="24" class="td_form01">患者年龄</td>
					<td class="td_form02"><input name="piage" type="text"
						class="input" id="piage"></td>
				</tr>
				<tr>
					<td width="90" height="24" class="td_form01">科室名称</td>
					<td class="td_form02"><select name="branch" id="branch">
							<option value="">--请选择--</option>
							<c:forEach var="b" items="${blist }">
								<option value="${b.brid }">${b.brname }</option>
							</c:forEach>
					</select></td>
					<td width="90" height="24" class="td_form01">挂号类型</td>
					<td class="td_form02"><select name="type" id="type">
							<option value="">--请选择--</option>
							<c:forEach var="t" items="${tlist }">
								<option value="${t.tyid }">${t.tyname }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td width="90" height="24" class="td_form01">医生姓名</td>
					<td class="td_form02"><select name="doctor" id="doctor">
					</select></td>
					<td width="90" height="24" class="td_form01" >挂号费用</td>
					<td class="td_form02"><input name="cost" type="text"
						class="input" id="cost"></td>
				</tr>
				<tr>
					<td width="90" height="24" class="td_form01">就诊地点</td>
					<td class="td_form02"><input name="textfield24" type="text"
						class="input" id="location"></td>
					<td width="90" height="24" class="td_form01">挂号日期</td>
					<td class="td_form02"><input name="time" type="text"
						class="input" id="time"></td>
				</tr>
				<tr>
					<td width="90" height="24" class="td_form01">操作人员</td>
					<td class="td_form02"><input name="textfield24" type="text"
						class="input" value="${userInfos.uname }"></td>
				</tr>
			</table>
			<br>
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td align="center"><input name=save type="submit"
						class=buttonface value="提交" onclick="location.href='#'"> <input
						name="Reset" type="button" class="buttonface" value="重置"
						onClick="location.href='#'"> <input name="Return"
						type="button" class="buttonface" value="返回"
						onClick="history.back(-1)"></td>
				</tr>
			</table>
			<p>&nbsp;</p>
			<p>
				<br>
			</p>
		</form>
	</center>
</body>
</html>
