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
<form id="pagerForm" method="post" action="${ctx}/taircraft">
	 <input type="hidden" name="pageNum" value="${query.pageNum}" /><!--【必须】value=1可以写死-->
      <input type="hidden" name="numPerPage" value="${query.numPerPage}" /><!--【可选】每页显示多少条-->
      <input type="hidden" name="orderField" value="${query.orderField}" /><!--【可选】查询排序-->
      <input type="hidden" name="orderDirection" value="${query.orderDirection}" /><!--【可选】升序降序-->
				<input type="hidden"  value="${query.aircraftName}" name="aircraftName" />
				<input type="hidden"  value="${query.aircraftStandard}" name="aircraftStandard" />
				<input type="hidden"  value="${query.engineStandard}" name="engineStandard" />
				<input type="hidden"  value="${query.aircraftFactory}" name="aircraftFactory" />
				<input type="hidden"  value="${query.engineFactory}" name="engineFactory" />
				<input type="hidden"  value="${query.length}" name="length" />
				<input type="hidden"  value="${query.width}" name="width" />
				<input type="hidden"  value="${query.weight}" name="weight" />
				<input type="hidden"  value="${query.contain}" name="contain" />
				<input type="hidden"  value="${query.lifetime}" name="lifetime" />
				<input type="hidden"  value="${query.flytime}" name="flytime" />
				<input type="hidden"  value="${query.distance}" name="distance" />
				<input type="hidden"  value="${query.field1}" name="field1" />
				<input type="hidden"  value="${query.field2}" name="field2" />
				<input type="hidden"  value="${query.field3}" name="field3" />
</form>
	<form onsubmit="return navTabSearch(this);" action="${ctx}/taircraft" method="post">
	<div id="search_bar" class="mt10">
       <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">搜索</b></div>
            <div class="box_center pt10 pb10">
		<table class="searchContent">
		<tr>	
				
				
			<td class="td_right">飞机名称：</td>
			<td>
			 <input type="text"  id="aircraftName" name="aircraftName" class="input-text lh30" value="${query.aircraftName}" />
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
				 <input type="button" class="ext_btn ext_btn_error" value="批量删除" onclick="batchDelete('${ctx}/taircraft','items')">
                 <input type="button" class="ext_btn ext_btn_success" value="新增" onclick="openEditDialog('新增','${ctx}/taircraft/new','600px','300px')">
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
				<th orderField="aircraftName" ><%=Taircraft.ALIAS_AIRCRAFT_NAME%></th>
				<th orderField="aircraftStandard" ><%=Taircraft.ALIAS_AIRCRAFT_STANDARD%></th>
				<th orderField="engineStandard" ><%=Taircraft.ALIAS_ENGINE_STANDARD%></th>
				<th orderField="aircraftFactory" ><%=Taircraft.ALIAS_AIRCRAFT_FACTORY%></th>
				<th orderField="engineFactory" ><%=Taircraft.ALIAS_ENGINE_FACTORY%></th>
				
				<th orderField="field1" >操作</th>
			
			  </tr>
		  </thead>
		<tbody>
			 <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  <tr class="tr">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.aircraftId}"></td>
				<td>${item.aircraftName}&nbsp;</td>
				<td>${item.aircraftStandard}&nbsp;</td>
				<td>${item.engineStandard}&nbsp;</td>
				<td>${item.aircraftFactory}&nbsp;</td>
				<td>${item.engineFactory}&nbsp;</td>
				
				<td>
				   <a href="javascript:openEditDialog('编辑','${ctx}/taircraft/${item.aircraftId}/edit','800px','400px');">修改</a>
				   
		
				   <a href="javascript:openEditDialog('故障','${ctx}/taircraft/${item.aircraftId}/toBreak','800px','400px');">报故障</a>
				   
				   <a href="javascript:openEditDialog('维修','${ctx}/taircraft/${item.aircraftId}/toRepaire','800px','400px');">维修</a>
				
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