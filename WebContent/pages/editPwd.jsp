<%@page import="com.vma.code.domain.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>

 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <html lang="zh-CN">
 <head>
   <meta charset="UTF-8">
<script type="text/javascript">
function editPwd(path)
{
	var newPwd1=$("#newPwd1").val();
	var newPwd2=$("#newPwd2").val();
	
	
	if(newPwd1=='')
	{
		window.alert("请输入新密码");
		return false;
	}
	
	if(newPwd2=='')
	{
	    window.alert("请再次输入新密码");
		return false;
	}
	
	if(newPwd1==newPwd2)
	{
		$.post(path,{"newPwd1":newPwd1},
		  	  function(data)
		      {
		       
		          window.alert(data.message);
		      
		      }
		  );
	}
	else
	{
	    window.alert("两次密码输入不一致，请重新输入");
	}
	

}


</script>
   
   <title>Document</title>
 </head>
 <body>
  <div class="container">
     
      
     <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_center">
              <form   class="jqtransform" method="post">
					<c:if test="${tpush.pushId!=null}"><input type="hidden" id="pushId" name="pushId" value="${tpush.pushId}"/></c:if>
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>当前账号:</td>
								<td>${sessionScope.LOGIN_USER_KEY.userNo }
								
									
							</td>
							</tr>
							<tr>
								<td>请输入新密码</td>
								<td>
								   <input id="newPwd1"  name="newPwd1" type="password" class="input-text required lh30" size="40" />
								</td>
							</tr>
							<tr>
								<td>再次输入新密码</td>
								<td>
								   <input id="newPwd2"  name="newPwd2" type="password" class="input-text required lh30" size="40" />
								</td>
							</tr>
							<tr>
								说明：密码修改成功后将在下次登录时生效!
							</tr>
							
				 <tr>
				   <td class="td_right">&nbsp;</td>
				   <td class="">
					 <input type="button" name="button" class="btn btn82 btn_save2" value="保存" onclick="editPwd('${ctx}/hyuser/updatePwd');"> 
					
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
