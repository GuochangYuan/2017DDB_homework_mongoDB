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
              <form  action="${ctx}/taircraft/update" class="jqtransform" method="post">
					<c:if test="${taircraft.aircraftId!=null}"><input type="hidden" id="aircraftId" name="aircraftId" value="${taircraft.aircraftId}"/></c:if>
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td><%=Taircraft.ALIAS_AIRCRAFT_NAME%>:</td>
								<td>
									<input value="${taircraft.aircraftName}" name="aircraftName" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td><%=Taircraft.ALIAS_AIRCRAFT_STANDARD%>:</td>
								<td>
									<input value="${taircraft.aircraftStandard}" name="aircraftStandard" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td><%=Taircraft.ALIAS_ENGINE_STANDARD%>:</td>
								<td>
									<input value="${taircraft.engineStandard}" name="engineStandard" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td><%=Taircraft.ALIAS_AIRCRAFT_FACTORY%>:</td>
								<td>
									<input value="${taircraft.aircraftFactory}" name="aircraftFactory" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td><%=Taircraft.ALIAS_ENGINE_FACTORY%>:</td>
								<td>
									<input value="${taircraft.engineFactory}" name="engineFactory" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td><%=Taircraft.ALIAS_LENGTH%>:</td>
								<td>
									<input value="${taircraft.length}" name="length" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td><%=Taircraft.ALIAS_WIDTH%>:</td>
								<td>
									<input value="${taircraft.width}" name="width" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td><%=Taircraft.ALIAS_WEIGHT%>:</td>
								<td>
									<input value="${taircraft.weight}" name="weight" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td><%=Taircraft.ALIAS_CONTAIN%>:</td>
								<td>
									<input value="${taircraft.contain}" name="contain" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td><%=Taircraft.ALIAS_LIFETIME%>:</td>
								<td>
									<input value="${taircraft.lifetime}" name="lifetime" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td><%=Taircraft.ALIAS_FLYTIME%>:</td>
								<td>
									<input value="${taircraft.flytime}" name="flytime" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td><%=Taircraft.ALIAS_DISTANCE%>:</td>
								<td>
									<input value="${taircraft.distance}" name="distance" type="text" class="input-text lh30" size="40" />
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
