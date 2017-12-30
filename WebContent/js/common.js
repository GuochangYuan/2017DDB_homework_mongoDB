$(function(){
	//表格行，鼠标放上去变色
	$(".tr:odd").css("background", "#FFFCEA");
	$(".tr:odd").each(function(){
		$(this).hover(function(){
			$(this).css("background-color", "#FFE1FF");
		}, function(){
			$(this).css("background-color", "#FFFCEA");
		});
	});
	$(".tr:even").each(function(){
		$(this).hover(function(){
			$(this).css("background-color", "#FFE1FF");
		}, function(){
			$(this).css("background-color", "#fff");
		});
	}); 

	/*ie6,7下拉框美化*/
    if ( $.browser.msie ){
    	if($.browser.version == '7.0' || $.browser.version == '6.0'){
    		$('.select').each(function(i){
			   $(this).parents('.select_border,.select_containers').width($(this).width()+5); 
			 });
    		
    	}
    }
 
});

//点击分页条时所调用的js
function pageChange(pageNum,numPerPage){
	$("input[name='pageNum']").eq(0).val(pageNum);
	$("input[name='numPerPage']").eq(0).val(numPerPage);
	var params = "?date="+Math.abs(5);
	$("#pagerForm").children().each(function(){
		params+="&"+$(this).attr("name")+"="+$(this).val();
	});
	//alert(params);
	window.location.href=$("#pagerForm").attr("action")+params;
}


function openEditDialog(title,url,width,height){
	$.dialog({id: url, title: title, content: 'url: '+url , lock: true, width: width, height: height, padding: '0px',close:function(){
		//window.location.reload();
	}});
}
//批量选中复选框
function setAllCheckboxState(items,checked){
	$("input[name='"+items+"']").attr("checked",checked)	
}
//统一的批量删除
function batchDelete(url,items){
	var temp = "";
	$("input[name='"+items+"']:checked").each(function(){
			temp+=$(this).val()+",";			
	});
	if(temp.length==0) {
		my_alert("请勾选记录");
		return;
	}
	if(my_confirm('确定删除选中的数据?')){
		$.ajax({
             type: "POST",
             url: url+'/batchDelete',
             data: {ids:temp},
             dataType: "json",
             success: function(data){
             	if(data.flag){
             		window.location.reload();
             	}else{
             		my_alert(data.msg);
             	}
             }
      });
	}
}
//删除单行
function deleteRow(url,rowId){
	if(my_confirm('确定删除选中的数据?')){
		$.ajax({
             type: "POST",
             url: url+'/deleteRow',
             data: {id:rowId},
             dataType: "json",
             success: function(data){
             	if(data.flag){
             		my_alert(data.msg);
             		window.location.reload();
             	}else{
             		my_alert(data.msg);
             	}
             }
      });
	}
}
//统一的确认方法
function my_confirm(msg){
	if(window.confirm(msg)){
		return true;
	}
	return false;
}
//统一的提示方法
function my_alert(msg){
	alert(msg);
}

function reloadCurrentList(){
	window.location.reload();
}

$(function() {
	$(".jqtransform").validate();
	
});