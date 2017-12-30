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
              <form  action="${ctx}/trepaire/update" class="jqtransform" method="post">
					<c:if test="${trepaire.repaireId!=null}"><input type="hidden" id="repaireId" name="repaireId" value="${trepaire.repaireId}"/></c:if>
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
							
							<input value="${taircraft.aircraftId}" name="aircraftId" type="hidden" class="input-text lh30" size="40" />
							
							
							<tr>
								<td><%=Trepaire.ALIAS_BREAK_CONTENT%>:</td>
								<td>
								<textarea rows="10" cols="40" id="breakContent" name="breakContent">${trepaire.breakContent}</textarea>
									
									
							</td>
							</tr>
							<tr>
								<td><%=Trepaire.ALIAS_PALN%>:</td>
								<td>
									<input value="${trepaire.paln}" name="paln" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td><%=Trepaire.ALIAS_OPERATOR%>:</td>
								<td>
									<input value="${trepaire.operator}" name="operator" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td>维修起始时间:</td>
								<td>
								<input value="${trepaire.firstTimeString}" name="firstTimeString"  maxlength="0" class="Wdate required" onfocus="WdatePicker({dateFmt:'<%= Trepaire.FORMAT_FIRST_TIME%>'})" />
							</td>
							</tr>
							<tr>
								<td>维修结束时间:</td>
								<td>
								<input value="${trepaire.lastTimeString}" name="lastTimeString"  maxlength="0" class="Wdate required" onfocus="WdatePicker({dateFmt:'<%= Trepaire.FORMAT_LAST_TIME%>'})" />
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
