package com.vma.code.util;

public class PageTool {
	
	
	/**
	 * 生成分页工具条
	 * @param currentPage    当前页
	 * @param advancePageNo  当前页左右展示的页码数，例如值为2，当前页为5时，页面展示的分页条为  【3】【4】[5]【6】【7】
	 * @param pageSize       每页显示几条
	 * @param totalCount     总的条数
	 * @param params         请求的查询条件拼装的参数字符串(不包含page与pageSize)
	 * @param listUrl        请求的index方法的地址
	 * @return
	 */
	public static String createPageToolBar(int currentPage,int advancePageNo,int pageSize,int totalCount){
		
		int totalPage = (totalCount/pageSize)+((totalCount%pageSize)>0?1:0);
		
		StringBuffer pageToolBar = new StringBuffer();
		pageToolBar.append("<li class='first-child'><a href='javascript:void(0)'>共").append(totalCount).append("条").append("</a></li>");
		if(currentPage > 1) {
			pageToolBar.append("<li><a href='javascript:pageChange("+1+","+pageSize+")' class='a1'>首页</a></li>");
			pageToolBar.append("<li><a href='javascript:pageChange("+(currentPage-1)+","+pageSize+")' class='a1'>上一页</a></li>");
		}
		
		if(advancePageNo > 0 && currentPage > 1) {
			for(int i=currentPage-advancePageNo<=0?1:currentPage-advancePageNo;i<currentPage;i++) {
				pageToolBar.append("<li><a href='javascript:pageChange("+i+","+pageSize+")'>"+i+"</a></li>");
			}
		}
		
		if(totalCount > 0) {
			pageToolBar.append("<li class='active'><span>").append(currentPage).append("</span></li>");
		}
		
		if(advancePageNo > 0 && currentPage < totalPage) {
			int lastIndex = currentPage+advancePageNo>totalPage?totalPage:(currentPage+advancePageNo);
			for(int i=currentPage+1;i<=lastIndex;i++) {
				pageToolBar.append("<li><a href='javascript:pageChange("+i+","+pageSize+")'>"+i+"</a></li>");
			}
		}
		
		if(currentPage < totalPage){
			pageToolBar.append("<li><a href='javascript:pageChange("+(currentPage+1)+","+pageSize+")' class='a1'>下一页</a></li>");
			pageToolBar.append("<li><a href='javascript:pageChange("+totalPage+","+pageSize+")' class='a1'>末页</a></li>");
		}
		pageToolBar.append("<li class='last-child'><a href='javascript:void(0)'>共").append(totalPage).append("页").append("</a></li>");
		
		System.out.println(pageToolBar.toString());
		return pageToolBar.toString();
	}
	
	private static String getPageUrl(int page,int pageSize,String params,String listUrl){
		String moreParams = params+"&page="+page+"&pageSize="+pageSize;
		return listUrl+"?"+moreParams;
	}
	
	
//	public static void main(String[] args) {
//		new PageUtils().createPageToolBar(1, 2, 5, 0, "", "www.baidu.com");
//	}
	
}
