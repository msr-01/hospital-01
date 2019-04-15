<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="${pageContext.request.contextPath}/js/check.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/checkAll.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/clientSideApp.js"></script>
<SCRIPT language=JavaScript type=text/JavaScript>
function windowOpen(theURL,winName,features,width,hight,scrollbars,top,left) 
{
  var parameter="top="+top+",left="+left+",width="+width+",height="+hight;
  if(scrollbars=="no")
 {parameter+=",scrollbars=no";}
  else
 {parameter+=",scrollbars=yes";}
  window.open(theURL,winName,parameter);
}
</SCRIPT>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
$(function(){
	$("#chaxun").click(function(){
		$.getJSON("DrugSevlet",{method:drugfindAll,name:"drid"},function(jsonObj){//json字符串数据
			//清空数据
			$("#td").empty();
			$.each(jsonObj,function(index,person){
				console.log("index:"+index);
				//把数据绑定到table的表格中去
				$("#drug").append("<tr><td>"+person.uid+"</td><td>"+person.uname+"</td><td>"+person.sex+"</td><td>"+person.address+"</td></tr>");
			});
	});
});

</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" cellpadding="0">
      <tr>
        <td width="15"><img src="${pageContext.request.contextPath}/images/index_32.gif" width="9" height="9"></td>
        <td valign="bottom" class="title">药品信息查询
         <a href="message.jsp" style="list-style-type: none" class="buttonface11" id="buttonface2">返回</a>
        </td>
      </tr>
    </table></td>
  </tr>
</table>
<br>
<form action="" method="get"></form>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr>
	    <td class="td_page" >
	    	输入药品编号：
	    	<input name="drid" size="20" type="text" class="input"   id="PARA_YM_NOW" next="A001014" value="" onFocus="{obtainFocus(this),this.select()}" onKeyPress="gotoNextInput(this)" onBlur="matchInput(this)" >
	                        药品名称：
			<input name="drname" size="20" type="text" class="input" id="PARA_YM_NOW2" next="A001014" value="" onFocus="{obtainFocus(this),this.select()}" onKeyPress="gotoNextInput(this)" onBlur="matchInput(this)">
	    	<input name="chaxun" id="chaxun" type="button" class="buttonface" value=" 查询 ">
		</td>
	  </tr>
</table><br>

<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
  <tr>
    <td class="td_top">药品编号</td>
    <td class="td_top">药品名称</td>
    <td class="td_top">药品规格</td>
    <td class="td_top">药品单价</td>
    <td class="td_top">药品功能</td>
    <td class="td_top">有效期</td>
    <td class="td_top">库存</td>
    <td nowrap class="td_top">操作</td>

  </tr>
  </table>
  <tbody id="drug">
  <tr>
    <td class="td07">xy0012</td>
    <td class="td07">感冒灵</td>
    <td class="td07">12粒/片<br>2片/盒</td>
    <td class="td07">15.0</td>
    <td class="td07">主治感冒、发烧</td>
    <td class="td07">3年</td>
    <td class="td07">1200盒</td>
    <td class="td07">
    <a href="medicalInfoList.jsp" target="mainFrame">>>详情</a>&nbsp;&nbsp;
    </td>
  </tr>
  </tbody>
  

<table width="95%"  border="0" cellpadding="0" cellspacing="0" class="table02" align="center">
  <tr>
    <td height="30" align="right"><img src="${pageContext.request.contextPath}/images/1.gif" width="4" height="5" align="absmiddle"> 首页　 <img src="${pageContext.request.contextPath}/images/2.gif" width="3" height="5" align="absmiddle"> 上一页　 <img src="${pageContext.request.contextPath}/images/2-2.gif" width="3" height="5" align="absmiddle"> 下一页　 <img src="${pageContext.request.contextPath}/images/3.gif" width="4" height="5" align="absmiddle"> 末页　　共 1 页 1 条记录</td>
  </tr>
</table>
</body>
</html>
