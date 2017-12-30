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
              <form  action="${ctx}/tbdepartment/update" class="jqtransform" method="post">
					<c:if test="${tbDepartment.dtId!=null}"><input type="hidden" id="dtId" name="dtId" value="${tbDepartment.dtId}"/></c:if>
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td><%=TbDepartment.ALIAS_DT_NAME%>:</td>
								<td>
									<input value="${tbDepartment.dtName}" name="dtName" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td><%=TbDepartment.ALIAS_DT_BZ%>:</td>
								<td>
									<input value="${tbDepartment.dtBz}" name="dtBz" type="text" class="input-text lh30" size="40" />
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
