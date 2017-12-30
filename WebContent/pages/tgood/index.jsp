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
<form id="pagerForm" method="post" action="${ctx}/tgood">
	 <input type="hidden" name="pageNum" value="${query.pageNum}" /><!--【必须】value=1可以写死-->
      <input type="hidden" name="numPerPage" value="${query.numPerPage}" /><!--【可选】每页显示多少条-->
      <input type="hidden" name="orderField" value="${query.orderField}" /><!--【可选】查询排序-->
      <input type="hidden" name="orderDirection" value="${query.orderDirection}" /><!--【可选】升序降序-->
				<input type="hidden"  value="${query.goodName}" name="goodName" />
				<input type="hidden"  value="${query.goodType}" name="goodType" />
				<input type="hidden"  value="${query.goodUnit}" name="goodUnit" />
				<input type="hidden"  value="${query.minStock}" name="minStock" />
				<input type="hidden"  value="${query.stock}" name="stock" />
				<input type="hidden"  value="${query.field1}" name="field1" />
				<input type="hidden"  value="${query.field2}" name="field2" />
				<input type="hidden"  value="${query.field3}" name="field3" />
				<input type="hidden"  value="${query.field4}" name="field4" />
</form>
	<form onsubmit="return navTabSearch(this);" action="${ctx}/tgood" method="post">
	<div id="search_bar" class="mt10">
       <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">搜索</b></div>
            <div class="box_center pt10 pb10">
		<table class="searchContent">
		<tr>	
				
			<td class="td_right">零件名称：</td>
			<td>
			 <input type="text"  id="goodName" name="goodName" class="input-text lh30" value="${query.goodName}" />
			 <input type="submit" class="ext_btn ext_btn_success" value="搜索" onclick="$('#seachForm').submit();">
			</td>
				
				
				
				
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
				 <input type="button" class="ext_btn ext_btn_error" value="批量删除" onclick="batchDelete('${ctx}/tgood','items')">
                 <input type="button" class="ext_btn ext_btn_success" value="新增" onclick="openEditDialog('新增','${ctx}/tgood/new','600px','300px')">
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
				<th orderField="goodName" >零件名称</th>
				<th orderField="goodType" >类型</th>
				<th orderField="goodUnit" >库存单位</th>
				<th orderField="minStock" ><%=Tgood.ALIAS_MIN_STOCK%></th>
				<th orderField="stock" ><%=Tgood.ALIAS_STOCK%></th>
				<th orderField="field1" ><%=Tgood.ALIAS_FIELD1%></th>
				<th orderField="field2" ><%=Tgood.ALIAS_FIELD2%></th>
				<th orderField="field3" >规格</th>
				<th orderField="field3" >是否需要采购</th>
				<th orderField="field4" >操作</th>
			  </tr>
		  </thead>
		<tbody>
			 <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  <tr class="tr"  <c:if test="${item.stock<item.minStock }">style="color: red;"</c:if>  >
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.goodId}"></td>
				<td>${item.goodName}&nbsp;</td>
				<td>${item.goodType}&nbsp;</td>
				<td>${item.goodUnit}&nbsp;</td>
				<td>${item.minStock}&nbsp;</td>
				<td>${item.stock}&nbsp;</td>
				<td>${item.field1}&nbsp;</td>
				<td>${item.field2}&nbsp;</td>
				<td>${item.field3}&nbsp;</td>
				<td>${item.field4}&nbsp;</td>
				<td>
					<a href="javascript:openEditDialog('编辑','${ctx}/tgood/${item.goodId}/edit','800px','400px');">修改</a>
				    
				
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