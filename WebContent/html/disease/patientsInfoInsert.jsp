<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>病历信息录入</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"> </script>
<script type="text/javascript">
	$(function(){
		var d = new Date();
		var count = 0;
		$("#time").val( d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate()+" "+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds());
		$("#drug").click(function(){
			count = count + 100;
			$.post("JSONSevlet",{drid:$("#drid").val(),drname:$("#drname").val(),method:5},function(data){
				var JSONobj = JSON.parse(data);	
				
				$("#drugtable").empty();
				$("#drugtable").append("<tr><td class='td_top' align='center'>药品名称</td><td class='td_top' align='center'>药品编号</td><td class='td_top' align='center'>药品单价</td><td nowrap class='td_top' align='center'>操作</td></tr>");
				$.each(JSONobj,function(index,drug){
					$("#drugtable").append("<tr><td class='td07' align='center' id='drname"+(index+count)+"'>"+drug.drname+"</td><td class='td07' align='center' id='drid"+(index+count)+"'>"+drug.drid+"</td><td class='td07' align='center' id='drunitprice"+(index+count)+"'>"+drug.drunitprice+"</td><td class='td07' align='center'><input type='button' value='+' id='drbt"+(index+count)+"')></td></tr>");
					$("#drbt"+(index+count)).click(function(){
						$("#drretb").append("<tr id='drtr'><td class='td07' align='center'>"+$("#drname"+(index+count)).html()+"</td><td class='td07' align='center'>"+$("#drid"+(index+count)).html()+"</td><td class='td07' align='center'>"+$("#drunitprice"+(index+count)).html()+"</td><td class='td07' align='center'><input name='textfield24' type='text' class='input' id='drnum"+(index+count)+"'></td><td class='td07' align='center'><input type='button' value='-' id='drbtsub"+(index+count)+"'></td></tr>");
						$("#drbtsub"+(index+count)).click(function(){
							$("#drtr").remove();
						});
					});
				});
			});
		});
		
		$("#mp").click(function(){
			count = count + 100;
			$.post("JSONSevlet",{mpid:$("#mpid").val(),mpname:$("#mpname").val(),method:6},function(data){
				var JSONobj = JSON.parse(data);	
				$("#mptable").empty();
				$("#mptable").append("<tr><td class='td_top' align='center'>医疗项目名称</td><td class='td_top' align='center'>医疗项目编号</td><td class='td_top' align='center'>医疗项目费用</td><td nowrap class='td_top' align='center'>操作</td></tr>");
				$.each(JSONobj,function(index,mp){
					$("#mptable").append("<tr><td class='td07' align='center' id='mpname"+(index+count)+"'>"+mp.mpname+"</td><td class='td07' align='center' id='mpid"+(index+count)+"'>"+mp.mpid+"</td><td class='td07' align='center' id='mpprice"+(index+count)+"'>"+mp.mpprice+"</td><td class='td07' align='center'><input type='button' value='+' id='mpbt"+(index+count)+"')></td></tr>");
					$("#mpbt"+(index+count)).click(function(){
						$("#mpretb").append("<tr id='mptr'><td class='td07' align='center'>"+$("#mpname"+(index+count)).html()+"</td><td class='td07' align='center'>"+$("#mpid"+(index+count)).html()+"</td><td class='td07' align='center'>"+$("#mpprice"+(index+count)).html()+"</td><td class='td07' align='center'><input type='button' value='-' id='mpbtsub"+(index+count)+"'></td></tr>");
						$("#mpbtsub"+(index+count)).click(function(){
							$("#mptr").remove();
						});
					});
				});
			});
		});
		
		$("#doctor").change(function(){
			$.post("JSONSevlet",{doid:$("#doctor").val(),method:3},function(data){
				var cost = JSON.parse(data);	
				$("#cost").val(cost.rfcost);	
			});
		});
		
		$("#search").click(function(){
			$.post("JSONSevlet",{piid:$("#piid").val(),method:4},function(data){
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
							<td valign="bottom" class="title">病历信息录入</td>
						</tr>
					</table></td>
			</tr>
		</table>
		<br>
		<br>
		
		<form name="form1" method="post" action="">
			<table width="95%" border="0" cellspacing="0" cellpadding="0">
				<tr>

					<td width="90" class="td_form01">就诊卡号</td>
					<td class="td_form02">
					<input name="textfield24" type="text" class="input" id="piid">
					<input name="textfield24" type="button" class="buttonface" value="查询" id="search">
					</td>
					<td width="90" class="td_form01">患者姓名</td>
					<td class="td_form02"><input name="textfield24" type="text"
						class="input" id="piname"></td>
				</tr>
				<tr>
					<td width="90" class="td_form01">患者性别</td>
					<td class="td_form02"><select name="select3" id="pisex">
							<option>男</option>
							<option>女</option>
					</select></td>
					<td width="90" height="24" class="td_form01">患者年龄</td>
					<td class="td_form02"><input name="textfield24" type="text"
						class="input" id="piage"></td>
				</tr>
			</table>
			<br>
			<br>
			<table width="95%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="90" height="24" class="td_form01">医生编号</td>
					<td class="td_form02"><input name="textfield24" type="text"
						class="input" value="${userInfos.jobnumber }"></td>
					<td width="90" height="24" class="td_form01">诊断时间</td>
					<td class="td_form02"><input name="textfield24" type="text"
						class="input" id="time"></td>
				</tr>
				<tr>
					<td width="90" height="24" class="td_form01">诊断方法</td>
					<td class="td_form02"><input name="textfield24" type="text"
						class="input" id="meh"></td>
				</tr>
				<tr align="left" nowrap>
					<td height="24" align="center" class=td_form01>诊断结果：</td>
					<td height="24" colspan="5" align="left" valign="middle"
						class=td_form01><label> <textarea name="textarea"
								id="textarea" cols="100" rows="5"></textarea>
					</label></td>
				</tr>
			</table>
			<br>
			<br>
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td class="td_page">
						药品名称：<input name="PARA_YM_NOW" size="10" type="text" class="input" id="drname"> 
						药品编号：<input name="PARA_YM_NOW" size="10" type="text" class="input" id="drid">
						<input name="Submit" type="button" class="buttonface" value="查询 " id="drug">
					</td>
				</tr>
			</table>
			<br>
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0" id="drugtable">
				<tr>
					<td class="td_top" align="center">药品名称</td>
					<td class="td_top" align="center">药品编号</td>
					<td class="td_top" align="center">药品单价</td>
					<td nowrap class="td_top" align="center">操作</td>
				</tr>
			</table>
			<br>
			<table width="95%" border="" align="center" cellpadding="0"
				cellspacing="0" class="table01" id="drretb">
				<tr>
					<td class="td_top" align="center">药品名称</td>
					<td class="td_top" align="center">药品编号</td>
					<td class="td_top" align="center">药品单价</td>
					<td class="td_top" align="center">药品数量</td>
					<td nowrap class="td_top" align="center">操作</td>
				</tr>
			</table>
			<br>
			<br>
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td class="td_page">
						医疗项目名称：<input name="mpname" size="10" type="text" class="input" id="mpname">
						医疗项目编号：<input name="mpid" size="10" type="text" class="input" id="mpid">
						<input name="Submit" type="button" class="buttonface" value="查询 " id="mp">
					</td>
				</tr>
			</table>
			<br>
			<table width="95%" border="" align="center" cellpadding="0"
				cellspacing="0" class="table01" id="mptable">
				<tr>
					<td class="td_top" align="center">医疗项目名称</td>
					<td class="td_top" align="center">医疗项目编号</td>
					<td class="td_top" align="center">医疗项目费用</td>
					<td nowrap class="td_top" align="center">操作</td>
				</tr>
				<tr>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center">+</td>
				</tr>
				<tr>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center"></td>
					<td class="td07" align="center">+&nbsp;-</td>
				</tr>
			</table>
			<br>
			<table width="95%" border="" align="center" cellpadding="0"
				cellspacing="0" class="table01" id="mpretb">
				<tr>
					<td class="td_top" align="center">医疗项目名称</td>
					<td class="td_top" align="center">医疗项目编号</td>
					<td class="td_top" align="center">医疗项目费用</td>
					<td nowrap class="td_top" align="center">操作</td>
				</tr>
			</table>
			<br>
			<br>
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td align="center"><input name=save type="button"
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