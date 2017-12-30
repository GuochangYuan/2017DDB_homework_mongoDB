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
 </head>
 <body>
  <div class="container">
     
      
     <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_center">
              <form  action="${ctx}/hyuser/update" class="jqtransform" method="post">
					<c:if test="${hyUser.userId!=null}"><input type="hidden" id="userId" name="userId" value="${hyUser.userId}"/></c:if>
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
							
							<tr>
								<td><%=HyUser.ALIAS_REAL_NAME%>:</td>
								<td>
									<input value="${hyUser.realName}" name="realName" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td>角色:</td>
								<td>
									<select name="roleId" id="roleId" class="select"> 
								
									 <c:forEach items="${roleList}" var="item" varStatus="status">
									  <option value="${item.roleId}" <c:if test="${item.roleId == hyUser.roleId}">selected="selected"</c:if> >${item.roleName}</option> 
									 </c:forEach>
									 </select> 
							</td>
							</tr>
							<tr>
								<td><%=HyUser.ALIAS_PHONE_NUM%>:</td>
								<td>
									<input value="${hyUser.phoneNum}" name="phoneNum" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							
							<tr>
								<td><%=HyUser.ALIAS_DT_ID%>:</td>
								<td>
									<select class="select" id="dtId" name="dtId">
										 <c:forEach items="${dtList}" var="item" varStatus="status">
										  <option value="${item.dtId}" <c:if test="${item.dtId == hyUser.dtId}">selected="selected"</c:if> >${item.dtName}</option> 
										 </c:forEach>
									</select>
							</td>
							</tr>
							<tr>
								<td><%=HyUser.ALIAS_WORK_ID%>:</td>
								<td>
									<select class="select" id="workId" name="workId">
										 <c:forEach items="${workList}" var="item" varStatus="status">
										  <option value="${item.workId}" <c:if test="${item.workId == hyUser.workId}">selected="selected"</c:if> >${item.workName}</option> 
										 </c:forEach>
									</select>
							</td>
							</tr>
							<tr>
								<td><%=HyUser.ALIAS_BASE_SALARY%>:</td>
								<td>
									<input value="${hyUser.baseSalary}" name="baseSalary" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td><%=HyUser.ALIAS_ADDRESS%>:</td>
								<td>
									<input value="${hyUser.address}" name="address" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							
							<tr>
								<td><%=HyUser.ALIAS_USER_REMARK%>:</td>
								<td>
									<input value="${hyUser.userRemark}" name="userRemark" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
	
				 <tr>
				   <td class="td_right">&nbsp;</td>
				   <td class="">
					 <input type="submit" name="button" class="btn btn82 btn_save2" value="保存"> 
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
