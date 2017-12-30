package common.dwz;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.org.rapid_framework.util.page.PageQuery;

public class DwzPageQuery extends PageQuery{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3223588616390795904L;
	protected String orderField;
	protected String orderDirection;
	protected String sortColumns;
	protected Integer numPerPage;
	protected Integer pageNum;
	protected LinkedHashMap<String,String> orderColumnsMap;
	
	public Integer getPageNum() {
		return this.getPage();
	}
	public void setPageNum(Integer pageNum) {
		this.setPage(pageNum);
	}
	public Integer getNumPerPage() {
		return this.getPageSize();
	}
	public void setNumPerPage(Integer numPerPage) {
		this.setPageSize(numPerPage);
	}
	public String getOrderField() {
		return orderField;
	}
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	public String getOrderDirection() {
		return orderDirection;
	}
	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}
	public String getSortColumns() {
		return sortColumns;
	}
	public void setSortColumns(String sortColumns) {
		this.sortColumns = sortColumns;
	}
	/**
	 * @return the orderColumnsMap
	 */
	public LinkedHashMap<String, String> getOrderColumnsMap() {
		return orderColumnsMap;
	}
	/**
	 * @param orderColumnsMap the orderColumnsMap to set
	 */
	public void setOrderColumnsMap(LinkedHashMap<String, String> orderColumnsMap) {
		this.orderColumnsMap = orderColumnsMap;
	}
	
}
