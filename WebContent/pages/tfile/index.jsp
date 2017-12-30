<%@page import="com.vma.code.domain.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<script src="<%=request.getContextPath() %>/js/lhgdialog/lhgdialog.min.js?skin=jtop" type="text/javascript"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<script type="text/javascript">
	function batchOperate(path,fileId,filePath)
	{
		if(my_confirm('是否确定执行该操作?')){
			
		
		var finalPath=path+"?fileId="+fileId;
			
			$.ajax({
	             type: "POST",
	             url: finalPath,
	             data: {"status":status},
	             dataType: "json",
	             success: function(data){
	             	if(data.flag){
	             		window.location.href=filePath;
	             		//window.location.reload(false);
	             	}else{
	             		window.alert(data.msg);
	             	}
	             }
	      });
		}
	}
	
	</script>
	
</head>
<body style="margin: 5px;">
<form id="pagerForm" method="post" action="${ctx}/tfile">
	 <input type="hidden" name="pageNum" value="${query.pageNum}" /><!--【必须】value=1可以写死-->
      <input type="hidden" name="numPerPage" value="${query.numPerPage}" /><!--【可选】每页显示多少条-->
      <input type="hidden" name="orderField" value="${query.orderField}" /><!--【可选】查询排序-->
      <input type="hidden" name="orderDirection" value="${query.orderDirection}" /><!--【可选】升序降序-->
				<input type="hidden"  value="${query.fileName}" name="fileName" />
				<input type="hidden"  value="${query.address}" name="address" />
				<input type="hidden"  value="${query.status}" name="status" />
				<input type="hidden" value="${query.createTimeBeginString}" name="CreateTimeBeginString"/>
				<input type="hidden" value="${query.createTimeEndString}" name="CreateTimeEndString"/>
				<input type="hidden"  value="${query.field1}" name="field1" />
				<input type="hidden"  value="${query.field2}" name="field2" />
				<input type="hidden"  value="${query.field3}" name="field3" />
</form>
	<form action="${ctx}/tfile" method="post">
	<div id="search_bar" class="mt10">
       <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">搜索</b></div>
            <div class="box_center pt10 pb10">
		<table class="searchContent">
		<tr>	
				
			<td class="td_right">文件名称：</td>
			<td>
			 <input type="text"  id="fileName" name="fileName" class="input-text lh30" value="${query.fileName}" />
			</td>
	
			
			
			<td style="">
		     
		     <input type="submit" class="ext_btn ext_btn_success" value="搜索" onclick="$('#seachForm').submit();">
				
					
				
				
			</tr>			
		</table>
		</div>
            <div class="box_bottom pb5 pt5 pr10" style="border-top:1px solid #dadada;">
              <div class="search_bar_btn" style="text-align:right;">
			  <!--
                 <input type="submit" value="确定" class="ext_btn ext_btn_submit">
                 <input type="button" value="返回" onclick="location.href='javascript:history.go(-1)'" class="ext_btn">
				  <a href="" class="ext_btn"><span class="add"></span>添加</a>
				 -->
				 <input type="button" class="ext_btn ext_btn_error" value="批量删除" onclick="batchDelete('${ctx}/tfile','items')">
                 <input type="button" class="ext_btn ext_btn_success" value="新增" onclick="openEditDialog('新增','${ctx}/tfile/new','600px','300px')">
              </div>
            </div>
          </div>
        </div>
    </div>
	</form>


 <div id="table" class="mt10">
	<div class="box span10 oh">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
		<thead>
			  <tr>
				<th style="width:1px;">&nbsp;&nbsp;&nbsp;</th>
				<th style="width:1px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th orderField="fileName" ><%=Tfile.ALIAS_FILE_NAME%></th>
				
				<th orderField="createTime" ><%=Tfile.ALIAS_CREATE_TIME%></th>
				<th orderField="createTime" >上传者姓名</th>
			     <th orderField="createTime" >下载次数</th>
				<th orderField="field3" >操作</th>
			  </tr>
		  </thead>
		<tbody>
			 <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  <tr class="tr">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.fileId}"></td>
				<td>${item.fileName}&nbsp;</td>
				
				<td>${item.createTimeString}&nbsp;</td>
				<td>${item.field2}&nbsp;</td>
				<td>${item.field3}&nbsp;</td>
				
				<td>
				<%-- <a href="${fileAskPath}${item.address}">下载</a> --%>
				<a href="javascript:batchOperate('${ctx}/tfile/batchOperate','${item.fileId }','${fileAskPath}${item.address}')">下载</a>
				<a href="javascript:openEditDialog('修改','${ctx}/tfile/${item.fileId}/edit','600px','400px')">修改</a>
				</td>
			  </tr>		  
		  	 </c:forEach>
		</tbody>
	</table>
	 <div class="page mt10">
		<div class="pagination">
		  <ul>
${pageToolBar}		  </ul>
		</div>

	  </div>
	</div>
 </div>
 </body>
 </html>