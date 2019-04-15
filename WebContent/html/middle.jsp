<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Untitled Document</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script>
function oa_tool(){
if(window.parent.oa_frame.cols=="0,10,*"){
frameshow.src="${pageContext.request.contextPath}/images/index_48.gif";
oa_tree.title="隐藏工具栏"
window.parent.oa_frame.cols="250,10,*";
}
else{
frameshow.src="${pageContext.request.contextPath}/images/index_2_48.gif";
oa_tree.title="显示工具栏"
window.parent.oa_frame.cols="0,10,*";}
}
</script>
</head>

<body>
<table width="10" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="td02"><div id=oa_tree onClick="oa_tool();" title=隐藏工具栏><img src="${pageContext.request.contextPath}/images/index_48.gif" name="frameshow" width="10" height="53" id=frameshow style="cursor:hand"></div></td>
  </tr>
</table>
</body>
</html>
