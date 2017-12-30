<%@page import="com.vma.code.domain.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>

 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <html lang="zh-CN">
 <head>
   <meta charset="UTF-8">

   
   <title>Document</title>
   
   <script type="text/javascript">
   function checkForm(){
   	count = 0;
   	$("input[name='menuIds']").each(function(){
   		if($(this).is(':checked')){
   			count++;
   		}
   	});
   	if(count==0){
   		alert("设置权限必选");
   		return false;
   	}
   	
   	$(".signupForm").submit();
   }
   
   $(function(){
		$(".signupForm").validate();
	});
   </script>
 </head>
 <body>
  <div class="container">
     
      
     <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_center">
              <form  action="${ctx}/hysw/hyrole/update" class="signupForm" method="post">
					<c:if test="${hyRole.roleId!=null}"><input type="hidden" id="roleId" name="roleId" value="${hyRole.roleId}"/></c:if>
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td align="right"><%=HyRole.ALIAS_ROLE_NAME%>:</td>
								<td>
									<input value="${hyRole.roleName}" name="roleName" type="text" class="input-text lh30 required" size="40" />
							</td>
							</tr>
							<tr>
								<td valign="top" align="right"><%=HyRole.ALIAS_MENU_IDS%>:</td>
								<td>
									<div style="width: auto;height: auto;border: 1px solid #fff;">
				                		<input type="checkbox"  <c:if test="${requestScope.all=='Y'}">checked</c:if> onclick="setAllCheckboxState('menuIds',this.checked)"/>所有权限<br>
				                		<c:forEach items="${requestScope.menuList}" var="menu" varStatus="status">
				                			<input type="checkbox" value="${menu.menuId}" name="menuIds" <c:if test="${menu.field1=='Y'}">checked</c:if>/>${menu.menuName}&nbsp;&nbsp;&nbsp;
				                			<c:if test="${(status.index+1)%3==0}"><br></c:if>
				                		</c:forEach>
				                	</div>
								</td>
							</tr>
							
							<tr>
								<td valign="top" align="right"><%=HyRole.ALIAS_ROLE_REMARK%>:</td>
								<td>
									<textarea rows="5" cols="50" name="roleRemark">${hyRole.roleRemark}</textarea>
								</td>
							</tr>
							
				 <tr>
				   <td class="td_right">&nbsp;</td>
				   <td class="">
					 <input type="button" name="button" class="btn btn82 btn_save2" value="保存" onclick="checkForm()"> 
					<input type="reset" name="button" class="btn btn82 btn_res" value="重置"> 
				   </td>
				 </tr>
			</table>
           </form>
            </div>
          </div>
        </div>
     </div>
     
  
   </div> 
 </body>
 </html>
