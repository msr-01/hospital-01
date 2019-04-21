<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色权限管理</title>		
		<LINK href="${pageContext.request.contextPath }/css/Style.css"  type="text/css" rel="stylesheet">
		<script language="javascript"  src="${pageContext.request.contextPath }/js/function.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/pub.js"></script>
		
		<script language="javascript">
		  
		 function saveRole(){
		 
           //document.Form2.roleid.value=document.Form1.role.value;
		   document.Form2.action="ElecUserRolePopedomServlet?roleid="+document.Form1.role.value;
		   document.Form2.submit();
		}
		
       
       function selectRole(){
          
          if(document.Form1.role.value=="0"){
             document.Form1.action="getAllRoleList.do";
             document.Form1.submit();            
          }else{
            Pub.submitActionWithForm('Form2','ElecRolePopedomServlet','Form1');
          }
       }
		
		</script>
	</HEAD>
		
	<body>
	 <Form name="Form1" id="Form1"  method="post" style="margin:0px;">
		<table cellSpacing="1" cellPadding="0" width="90%" align="center" bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" colspan=2 align="center" background="${pageContext.request.contextPath }/images/b-info.gif">
						<font face="宋体" size="2"><strong>角色管理</strong></font>
					</td>
				</tr>	
				<tr>
				   <td class="ta_01" colspan=2 align="right" width="100%"  height=10>
				   </td>
				</tr>		
				<tr>
					<td class="ta_01" align="right" width="35%">角色类型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class="ta_01" align="left"  width="65%" >
					
					
					  <select name="role" class="bg" style="width:180px"  onchange="selectRole()">
						 <option value="0">请选择</option>
						 
						<c:if test="${!empty elecRolePopedomList }">
								<c:forEach items="${elecRolePopedomList }" var="poped">
									<option value="${poped.roleID }">${poped.remark }</option>
								</c:forEach>
						</c:if>
						 
					  </select>  
					 
					 
					   
					  
					</td>				
				</tr>
			    
			    <tr>
				   <td class="ta_01" align="right" colspan=2 align="right" width="100%"  height=10></td>
				</tr>
				
			</TBODY>
		  </table>
 </Form>

<Form  name="Form2" id="Form2"  method="post" style="margin:0px;">
 
  <table cellSpacing="1" cellPadding="0" width="90%" align="center" bgColor="#f5fafe" border="0">
 <tr>
  <td>
   <fieldset style="width:100%; border : 1px solid #73C8F9;text-align:left;COLOR:#023726;FONT-SIZE: 12px;"><legend align="left">权限分配</legend>
 
     <table cellSpacing="0" cellPadding="0" width="90%" align="center" bgColor="#f5fafe" border="0">			 
			  <tr>
				 <td class="ta_01" colspan=2 align="left" width="100%" > 
				  
						<br>
				         
				          技术设施维护管理 : 
				       
				           
   	                         <input type="checkbox"  name="selectoper" value="a" >
				             仪器设备管理
						      
				                &nbsp;&nbsp;&nbsp;
				      	      
				          
				           
				     	 
   	                         <input type="checkbox"  name="selectoper" value="b" >
				             设备校准检修
				            
				              &nbsp;&nbsp;&nbsp;
				            
				        
				     
				     
				           
				     	 
   	                         <input type="checkbox"  name="selectoper" value="c" >
				             设备购置计划
				            
				              &nbsp;&nbsp;&nbsp;
				            
				        
				     
				     
				      
						<br>
				         
				          技术资料图纸管理 : 
				       
				           
   	                         <input type="checkbox"  name="selectoper" value="d" >
				             资料图纸管理
						      
				                &nbsp;&nbsp;&nbsp;
				      	      
				          
				      
						<br>
				         
				          站点设备运行管理 : 
				       
				           
   	                         <input type="checkbox"  name="selectoper" value="e" >
				             站点基本信息
						      
				                &nbsp;&nbsp;&nbsp;
				      	      
				          
				           
				     	 
   	                         <input type="checkbox"  name="selectoper" value="f" >
				             运行情况
				            
				              &nbsp;&nbsp;&nbsp;
				            
				              &nbsp;&nbsp;&nbsp;
				            
				              &nbsp;&nbsp;&nbsp;
				            
				        
				     
				     
				           
				     	 
   	                         <input type="checkbox"  name="selectoper" value="g" >
				             维护情况
				            
				              &nbsp;&nbsp;&nbsp;
				            
				              &nbsp;&nbsp;&nbsp;
				            
				              &nbsp;&nbsp;&nbsp;
				            
				        
				     
				     
				      
						<br>
				         
				           &nbsp;&nbsp;&nbsp;
				         
				         
				 
				         
				          监测台建筑管理 : 
				       
				           
   	                         <input type="checkbox"  name="selectoper" value="k" >
				             监测台建筑管理
						      
				          
				      
						<br>
				         
				           &nbsp;&nbsp;&nbsp;
				         
				           &nbsp;&nbsp;&nbsp;
				         
				           &nbsp;&nbsp;&nbsp;
				         
				           &nbsp;&nbsp;&nbsp;
				         
				        系统管理 : 
				       
				           
   	                         <input type="checkbox"  name="selectoper" value="l" >
				           角色管理
						      
				                &nbsp;&nbsp;&nbsp;
				      	      
				                &nbsp;&nbsp;&nbsp;
				      	      
				                &nbsp;&nbsp;&nbsp;
				      	      
				          
				           
				     	 
   	                         <input type="checkbox"  name="selectoper" value="m" >
				            待办事宜
				            
				              &nbsp;&nbsp;&nbsp;
				            
				              &nbsp;&nbsp;&nbsp;
				            
				              &nbsp;&nbsp;&nbsp;
				            
				        
				     
				     
				           
				     	 
   	                         <input type="checkbox"  name="selectoper" value="n" >
				           数据字典维护
				            
				              &nbsp;&nbsp;&nbsp;
				            
				        
				     
				     
				      
						<br>
				         
				           &nbsp;&nbsp;&nbsp;
				         
				           &nbsp;&nbsp;&nbsp;
				         
				          操作权限分配 : 
				       
				           
   	                         <input type="checkbox"  name="selectoper" value="o" >
				             新增功能
						      
				                &nbsp;&nbsp;&nbsp;
				      	      
				          
				           
				     	 
   	                         <input type="checkbox"  name="selectoper" value="p" >
				             删除功能
				            
				              &nbsp;&nbsp;&nbsp;
				            
				              &nbsp;&nbsp;&nbsp;
				            
				              &nbsp;&nbsp;&nbsp;
				            
				        
				     
				     
				           
				     	 
   	                         <input type="checkbox"  name="selectoper" value="q" >
				             编辑功能
				            
				              &nbsp;&nbsp;&nbsp;
				            
				              &nbsp;&nbsp;&nbsp;
				            
				              &nbsp;&nbsp;&nbsp;
				            
				        
				     
				     
				      
				   </td>
				</tr>						
				 <input type="hidden" name="roleStr" >
				 <input type="hidden" name="roleid" >						
		 </table>	
        </fieldset>
	  </td>
	 </tr>					
  </table>
  
  
  
  
  
  <fieldset style="width:80%; border : 0px solid #73C8F9;text-align:left;COLOR:#023726;FONT-SIZE: 12px;"><legend align="left">用户分配</legend>
 
	<table cellspacing="0" align="center" width="100%" cellpadding="1" rules="all" bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT:gray 1px solid; BORDER-TOP:gray 1px solid; BORDER-LEFT:gray 1px solid; WORD-BREAK:break-all; BORDER-BOTTOM:gray 1px solid; BORDER-COLLAPSE:collapse; BACKGROUND-COLOR:#f5fafe; WORD-WRAP:break-word">
		
        	    
	 <tr style="FONT-WEIGHT:bold;FONT-SIZE:12pt;HEIGHT:25px;BACKGROUND-COLOR:#afd1f3">
	    <td class="ta_01"  align="center" width="10%" height=20 background="images/tablehead.jpg">选中</td>
	    <td class="ta_01"  align="center" width="20%" height=20 background="images/tablehead.jpg">登录名</td>
	    <td class="ta_01"  align="center" width="20%" height=20 background="images/tablehead.jpg">用户姓名</td>
    </tr>
				 
				 
				
						
					<tr>	
						<td style="HEIGHT: 22px" class="ta_01" align="center" width="20%">
							
						</td>
						<td style="HEIGHT: 22px" class="ta_01" align="center" width="20%">
							
						</td>
                        <td style="HEIGHT: 22px" class="ta_01" align="center" width="20%">
							
						</td>
					</tr>
				
				 
				 
				
						
					<tr>	
						<td style="HEIGHT: 22px" class="ta_01" align="center" width="20%">
							
						</td>
						<td style="HEIGHT: 22px" class="ta_01" align="center" width="20%">
							
						</td>
                        <td style="HEIGHT: 22px" class="ta_01" align="center" width="20%">
							
						</td>
					</tr>
                   
				 
				 
				
						
						
						<td style="HEIGHT: 22px" class="ta_01" align="center" width="20%">
							
						</td>
						<td style="HEIGHT: 22px" class="ta_01" align="center" width="20%">
							
						</td>
                        <td style="HEIGHT: 22px" class="ta_01" align="center" width="20%">
							
						</td>
					</tr>
				 
				 
		</table>
    </fieldset>
	 </td>
	 </tr>
     <center>
			<tr>
		   <td class="ta_01" align="center" colspan=3 width="100%"  height=20>
		   <input type="button" name="saverole" onclick="saveRole()" style="font-size:12px; color:black; height=20;width=50" value="保存">
		   </td>
		</tr>
        </center>
   </table>
		    				    
	</Form>
	</body>
</HTML>
