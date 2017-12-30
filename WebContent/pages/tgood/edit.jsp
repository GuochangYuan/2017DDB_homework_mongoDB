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
              <form  action="${ctx}/tgood/update" class="jqtransform" method="post">
					<c:if test="${tgood.goodId!=null}"><input type="hidden" id="goodId" name="goodId" value="${tgood.goodId}"/></c:if>
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr >
								<td>零件名称:</td>
								<td>
									<input value="${tgood.goodName}" name="goodName" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td>类别:</td>
								<td>
								
								    <input value="${tgood.goodType}" name="goodType" type="text" class="input-text lh30" size="40" />
									
							</td>
							</tr>
							<tr>
								<td>库存单位:</td>
								<td>
								<input value="${tgood.goodUnit}" name="goodUnit" type="text" class="input-text lh30" size="40" />
									
							</td>
							</tr>
							<tr>
								<td><%=Tgood.ALIAS_MIN_STOCK%>:</td>
								<td>
									<input value="${tgood.minStock}" name="minStock" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td><%=Tgood.ALIAS_STOCK%>:</td>
								<td>
									<input value="${tgood.stock}" name="stock" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td>采购单位:</td>
								<td>
								    <input value="${tgood.field1}" name="field1" type="text" class="input-text lh30" size="40" />
								
							</td>
							</tr>
							<tr>
								<td>转换比:</td>
								<td>
									<input value="${tgood.field2}" name="field2" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td>规格:</td>
								<td>
									<input value="${tgood.field3}" name="field3" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td>是否需要采购:</td>
								<td>
								    <select id="field4" name="field4" class="select">
								       <option value="否" <c:if test="${tgood.field4=='否' }">selected="selected"</c:if>  >否</option>
								       <option value="是" <c:if test="${tgood.field4=='是' }">selected="selected"</c:if>>是</option>
								    </select>
									
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
