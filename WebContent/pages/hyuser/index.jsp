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
<form id="pagerForm" method="post" action="${ctx}/hyuser">
	 <input type="hidden" name="pageNum" value="${query.pageNum}" /><!--【必须】value=1可以写死-->
      <input type="hidden" name="numPerPage" value="${query.numPerPage}" /><!--【可选】每页显示多少条-->
      <input type="hidden" name="orderField" value="${query.orderField}" /><!--【可选】查询排序-->
      <input type="hidden" name="orderDirection" value="${query.orderDirection}" /><!--【可选】升序降序-->
				<input type="hidden"  value="${query.userNo}" name="userNo" />
				<input type="hidden"  value="${query.realName}" name="realName" />
				<input type="hidden"  value="${query.phoneNum}" name="phoneNum" />
				<input type="hidden"  value="${query.address}" name="address" />
				<input type="hidden"  value="${query.dtId}" name="dtId" />
				<input type="hidden"  value="${query.workId}" name="workId" />
				<input type="hidden"  value="${query.roleId}" name="roleId" />
				<input type="hidden"  value="${query.userStatus}" name="userStatus" />
				<input type="hidden"  value="${query.userRemark}" name="userRemark" />
				<input type="hidden" value="${query.createTimeBeginString}" name="CreateTimeBeginString"/>
				<input type="hidden" value="${query.createTimeEndString}" name="CreateTimeEndString"/>
				<input type="hidden"  value="${query.field1}" name="field1" />
				<input type="hidden"  value="${query.dtName}" name="dtName" />
				<input type="hidden"  value="${query.emTypeWork}" name="emTypeWork" />
				<input type="hidden"  value="${query.baseSalary}" name="baseSalary" />
				<input type="hidden"  value="${query.isAdmin}" name="isAdmin" />
				<input type="hidden"  value="${query.field2}" name="field2" />
				<input type="hidden"  value="${query.field3}" name="field3" />
</form>
	<form onsubmit="return navTabSearch(this);" action="${ctx}/hyuser" method="post">
	<div id="search_bar" class="mt10">
       <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">搜索</b></div>
            <div class="box_center pt10 pb10">
		<table class="searchContent">
		<tr>	
			
			<td class="td_right">姓名：</td>
			<td>
			 <input type="text"  id="realName" name="realName" class="input-text lh30" value="${query.realName}" />
			 <input type="submit" class="ext_btn ext_btn_success" value="搜索" onclick="$('#seachForm').submit();">
			</td>	
	    		
			
			</tr>	
				
				
				
				
				
				
				
				
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
				 <input type="button" class="ext_btn ext_btn_error" value="批量删除" onclick="batchDelete('${ctx}/hyuser','items')">
                 <input type="button" class="ext_btn ext_btn_success" value="新增" onclick="openEditDialog('新增','${ctx}/hyuser/new','600px','300px')">
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
				<th orderField="userNo" ><%=HyUser.ALIAS_USER_NO%></th>
				<th orderField="realName" ><%=HyUser.ALIAS_REAL_NAME%></th>
				<th orderField="phoneNum" ><%=HyUser.ALIAS_PHONE_NUM%></th>
				
				<th orderField="dtId" ><%=HyUser.ALIAS_DT_ID%></th>
				<th orderField="workId" ><%=HyUser.ALIAS_WORK_ID%></th>
				<th orderField="baseSalary" ><%=HyUser.ALIAS_BASE_SALARY%></th>
				
				<th orderField="userRemark" ><%=HyUser.ALIAS_USER_REMARK%></th>
				<th orderField="createTime" ><%=HyUser.ALIAS_CREATE_TIME%></th>
				<th orderField="createTime" >操作</th>
				
			  </tr>
		  </thead>
		<tbody>
			 <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  <tr class="tr">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.userId}"></td>
				<td>${item.userNo}&nbsp;</td>
				<td>${item.realName}&nbsp;</td>
				<td>${item.phoneNum}&nbsp;</td>
			
				<td>${item.dtName}&nbsp;</td>
				<td>${item.emTypeWork}&nbsp;</td>
			
		        <td>${item.baseSalary}&nbsp;</td>
				<td>${item.userRemark}&nbsp;</td>
				
				<td>${item.createTimeString}&nbsp;</td>
				<td>
				<a href="javascript:openEditDialog('编辑','${ctx}/hyuser/${item.userId}/edit','800px','600px');">修改</a>
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