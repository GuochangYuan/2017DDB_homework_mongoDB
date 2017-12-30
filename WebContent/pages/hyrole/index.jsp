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
</head>
<body style="margin: 5px;">
<form id="pagerForm" method="post" action="${ctx}/hysw/hyrole">
	 <input type="hidden" name="pageNum" value="${query.pageNum}" /><!--【必须】value=1可以写死-->
      <input type="hidden" name="numPerPage" value="${query.numPerPage}" /><!--【可选】每页显示多少条-->
      <input type="hidden" name="orderField" value="${query.orderField}" /><!--【可选】查询排序-->
      <input type="hidden" name="orderDirection" value="${query.orderDirection}" /><!--【可选】升序降序-->
				<input type="hidden"  value="${query.roleName}" name="roleName" />
				<input type="hidden"  value="${query.menuIds}" name="menuIds" />
				<input type="hidden"  value="${query.roleStatus}" name="roleStatus" />
				<input type="hidden"  value="${query.roleRemark}" name="roleRemark" />
				<input type="hidden" value="${query.createTimeBeginString}" name="CreateTimeBeginString"/>
				<input type="hidden" value="${query.createTimeEndString}" name="CreateTimeEndString"/>
				<input type="hidden"  value="${query.field1}" name="field1" />
				<input type="hidden"  value="${query.field2}" name="field2" />
				<input type="hidden"  value="${query.field3}" name="field3" />
</form>
	<form onsubmit="return navTabSearch(this);" action="${ctx}/hyrole" method="post">
	<div id="search_bar" class="mt10">
       <div class="box">
          <div class="box_border">
            <div class="box_bottom pb5 pt5 pr10" style="border-top:1px solid #dadada;">
              <div class="search_bar_btn" style="text-align:right;">
			  <!--
                 <input type="submit" value="确定" class="ext_btn ext_btn_submit">
                 <input type="button" value="返回" onclick="location.href='javascript:history.go(-1)'" class="ext_btn">
				  <a href="" class="ext_btn"><span class="add"></span>添加</a>
				 <input type="button" class="ext_btn ext_btn_error" value="批量删除" onclick="batchDelete('${ctx}/hyrole','items')">
				 -->
                 <input type="button" class="ext_btn ext_btn_success" value="新增" onclick="openEditDialog('新增','${ctx}/hysw/hyrole/new','600px','400px')">
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
				<th style="width:1px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th orderField="roleName" ><%=HyRole.ALIAS_ROLE_NAME%></th>
				<th orderField="roleRemark" ><%=HyRole.ALIAS_ROLE_REMARK%></th>
				<th orderField="createTime" ><%=HyRole.ALIAS_CREATE_TIME%></th>
				<th >操作</th>
			  </tr>
		  </thead>
		<tbody>
			 <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  <tr class="tr">
				<td align="center"><input type="checkbox" name="items" value="${item.roleId}"></td>
				<td>${item.roleName}&nbsp;</td>
				<td>${item.roleRemark}&nbsp;</td>
				<td>${item.createTimeString}&nbsp;</td>
				<td align="center">
					<a href="javascript:openEditDialog('修改','${ctx}/hysw/hyrole/edit?id=${item.roleId}','600px','400px')">修改</a>
					&nbsp;&nbsp;|&nbsp;&nbsp;
					<a href="javascript:deleteRow('<%=request.getContextPath()%>/hysw/hyrole','${item.roleId}')">删除</a>
				&nbsp;</td>
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