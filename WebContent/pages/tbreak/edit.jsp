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
              <form  action="${ctx}/tbreak/update" class="jqtransform" method="post">
					<c:if test="${tbreak.breakId!=null}"><input type="hidden" id="breakId" name="breakId" value="${tbreak.breakId}"/></c:if>
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
						
							
							<input value="${taircraft.aircraftId}" name="aircraftId" type="hidden" class="input-text lh30" size="40" />
							
							<tr>
								<td><%=Tbreak.ALIAS_BREAK_NAME%>:</td>
								<td>
									<input value="${tbreak.breakName}" name="breakName" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							
							<tr>
								<td><%=Tbreak.ALIAS_CREATE_TIME%>:</td>
								<td>
								<input value="${tbreak.createTimeString}" name="createTimeString"  maxlength="0" class="Wdate required" onfocus="WdatePicker({dateFmt:'<%= Tbreak.FORMAT_CREATE_TIME%>'})" />
							</td>
							</tr>
							
							<tr>
								<td><%=Tbreak.ALIAS_CONTENT%>:</td>
								<td>
								    <textarea rows="10" cols="40" id="content" name="content">${tbreak.content}</textarea>
									
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
