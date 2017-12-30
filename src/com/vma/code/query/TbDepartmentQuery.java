/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.vma.code.query;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import common.dwz.DwzPageQuery;
import common.util.DateFormats;


public class TbDepartmentQuery extends DwzPageQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    
  //date formats
	public static final String FORMAT_FTIME =DateFormats.DATE_FORMAT;
    

	/** dtId */
	private java.lang.Integer dtId;
	/** 部门名称 */
	private java.lang.String dtName;
	/** 创建时间 */
	private java.lang.String dtCreateTime;
	/** 备注 */
	private java.lang.String dtBz;

	public java.lang.Integer getDtId() {
		return this.dtId;
	}
	
	public void setDtId(java.lang.Integer value) {
		this.dtId = value;
	}
	
	public java.lang.String getDtName() {
		return this.dtName;
	}
	
	public void setDtName(java.lang.String value) {
		this.dtName = value;
	}
	
	public java.lang.String getDtCreateTime() {
		return this.dtCreateTime;
	}
	
	public void setDtCreateTime(java.lang.String value) {
		this.dtCreateTime = value;
	}
	
	public java.lang.String getDtBz() {
		return this.dtBz;
	}
	
	public void setDtBz(java.lang.String value) {
		this.dtBz = value;
	}
	
	public String getSortColumns(){
		return (getSortColumns(orderField,orderDirection) == null?
				getSortColumns(orderColumnsMap):getSortColumns(orderField,orderDirection));
	}

	static public String getSortColumns(String orderField,String orderDirection){
		if(StringUtils.isNotBlank(orderField)){
			StringBuffer orderColumns = new StringBuffer();
			if(orderField.equals("dtId")){
				orderColumns.append("dt_id");
			}
			if(orderField.equals("dtName")){
				orderColumns.append("dt_name");
			}
			if(orderField.equals("dtCreateTime")){
				orderColumns.append("dt_createTime");
			}
			if(orderField.equals("dtBz")){
				orderColumns.append("dt_bz");
			}
			if(StringUtils.isNotBlank(orderColumns.toString())){
				if(StringUtils.isNotBlank(orderDirection))
					orderColumns.append(" " + orderDirection);
				return orderColumns.toString();
			}
		}
		return null;
	}
	
	static public String getSortColumns(Map<String,String> orderColumnsMap){
		if(orderColumnsMap != null){
			StringBuffer orderColumnsStr = new StringBuffer();
			Set<String> orderColumnsNames = orderColumnsMap.keySet();
			int length = orderColumnsNames.size();
			int i = 0;
			
			for (String name : orderColumnsNames) {
				orderColumnsStr.append(getSortColumns(name,orderColumnsMap.get(name)));
				if(i<length-1){
					orderColumnsStr.append(",");
				}
				i++;
			}
			return orderColumnsStr.toString();
		}	
		return null;
	}
	public String getParamString(){
		StringBuffer str = new StringBuffer();
		if(dtId != null){
			str.append("&dtId=").append(dtId);
		}
		if(dtName != null){
			str.append("&dtName=").append(dtName);
		}
		if(dtCreateTime != null){
			str.append("&dtCreateTime=").append(dtCreateTime);
		}
		if(dtBz != null){
			str.append("&dtBz=").append(dtBz);
		}
		if(StringUtils.isNotBlank(orderField)){
			str.append("&orderField=").append(orderField);
		}
		if(StringUtils.isNotBlank(orderDirection)){
			str.append("&orderDirection=").append(orderDirection);
		}
		str.append("&pageNum=").append(getPageNum());
		str.append("&numPerPage=").append(getNumPerPage());
		return str.toString();
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

