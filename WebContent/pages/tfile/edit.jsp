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
   
   <script src="<%=request.getContextPath()%>/js/jquery-1.7.min.js" type="text/javascript"></script>
   <script src="<%=request.getContextPath()%>/js/Area.js" type="text/javascript"></script>
   <script src="<%=request.getContextPath()%>/js/AreaData_min.js" type="text/javascript"></script>
   
   <link rel="stylesheet" href="${ctx}/kindeditor/themes/default/default.css" />
   <link rel="stylesheet" href="${ctx}/kindeditor/plugins/code/prettify.css" />
   <script charset="utf-8" src="${ctx}/kindeditor/kindeditor.js"></script>
   <script charset="utf-8" src="${ctx}/kindeditor/lang/zh_CN.js"></script>
   <script charset="utf-8" src="${ctx}/kindeditor/plugins/code/prettify.js"></script> 
   <script src="${ctx}/kindeditor/kindeditor-min.js"></script>
   
   <script>

			KindEditor.ready(function(K) {
				var uploadbutton = K.uploadbutton({
					button : K('#shangchuan1')[0],
					fieldName : 'imgFile',
					url : '${ctx}/kindeditor/jsp/picture_upload_json.jsp',
					allowImageRemote : false, 
					afterUpload : function(data) {
						if (data.error === 0) {
							var url = data.url;
							K('#address').val(url);
							//var fileAskPath = $("#fileAskPath").val();
							//$("#imgId1").attr('src',fileAskPath+url); 
						} else {
							alert(data.message);
						}
					},
					afterError : function(str) {
						alert('自定义错误信息: ' + str);
					}
				});
				uploadbutton.fileBox.change(function(e) {
					uploadbutton.submit();
				});
			});
   </script> 
   
 </head>
 <body>
  <div class="container">
     
      
     <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_center">
              <form  action="${ctx}/tfile/update" class="jqtransform" method="post">
					<c:if test="${tfile.fileId!=null}"><input type="hidden" id="fileId" name="fileId" value="${tfile.fileId}"/></c:if>
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td><%=Tfile.ALIAS_FILE_NAME%>:</td>
								<td>
									<input value="${tfile.fileName}" name="fileName" type="text" class="input-text lh30" size="40" />
							</td>
							</tr>
							<tr>
								<td>文件路径:</td>
								<td>
								
							        <input value="${tfile.address}" id="address" name="address" type="text"  class="input-text lh30" size="40" />
									<div class="upload">
									
		                            <input type="button" id="shangchuan1"   value="上传" />
			                        </div>
							
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
