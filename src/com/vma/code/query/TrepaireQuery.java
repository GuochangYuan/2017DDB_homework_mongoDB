/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2017
 */

package com.vma.code.query;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import cn.org.rapid_framework.util.DateConvertUtils;

import com.vma.code.domain.Trepaire;
import common.dwz.DwzPageQuery;
import common.util.DateFormats;


public class TrepaireQuery extends DwzPageQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    
  //date formats
	public static final String FORMAT_FTIME =DateFormats.DATE_FORMAT;
    

	/** repaireId */
	private java.lang.Integer repaireId;
	/** 飞机编号 */
	private java.lang.Integer aircraftId;
	/** 飞机名称 */
	private java.lang.String aircraftName;
	/** 故障描述 */
	private java.lang.String breakContent;
	/** 维修方案 */
	private java.lang.String paln;
	/** 维修者 */
	private java.lang.String operator;
	/** 维修起始时间 */
	private java.util.Date firstTimeBegin;
	private java.util.Date firstTimeEnd;
	/** 维修起始 */
	private java.util.Date lastTimeBegin;
	private java.util.Date lastTimeEnd;
	/** 操作用户id */
	private java.lang.Integer userId;
	/** field1 */
	private java.lang.String field1;
	/** field2 */
	private java.lang.String field2;
	/** field3 */
	private java.lang.String field3;

	public java.lang.Integer getRepaireId() {
		return this.repaireId;
	}
	
	public void setRepaireId(java.lang.Integer value) {
		this.repaireId = value;
	}
	
	public java.lang.Integer getAircraftId() {
		return this.aircraftId;
	}
	
	public void setAircraftId(java.lang.Integer value) {
		this.aircraftId = value;
	}
	
	public java.lang.String getAircraftName() {
		return this.aircraftName;
	}
	
	public void setAircraftName(java.lang.String value) {
		this.aircraftName = value;
	}
	
	public java.lang.String getBreakContent() {
		return this.breakContent;
	}
	
	public void setBreakContent(java.lang.String value) {
		this.breakContent = value;
	}
	
	public java.lang.String getPaln() {
		return this.paln;
	}
	
	public void setPaln(java.lang.String value) {
		this.paln = value;
	}
	
	public java.lang.String getOperator() {
		return this.operator;
	}
	
	public void setOperator(java.lang.String value) {
		this.operator = value;
	}
	
	public java.util.Date getFirstTimeBegin() {
		return this.firstTimeBegin;
	}
	
	public String getFirstTimeBeginString() {
		return DateConvertUtils.format(getFirstTimeBegin(), Trepaire.FORMAT_FIRST_TIME);
	}
	
	public void setFirstTimeBegin(java.util.Date value) {
		this.firstTimeBegin = value;
	}	
	
	public void setFirstTimeBeginString(String value) {
		setFirstTimeBegin(DateConvertUtils.parse(value, Trepaire.FORMAT_FIRST_TIME,java.util.Date.class));
	}
	
	public java.util.Date getFirstTimeEnd() {
		return this.firstTimeEnd;
	}
	
	public String getFirstTimeEndString() {
		return DateConvertUtils.format(getFirstTimeEnd(), Trepaire.FORMAT_FIRST_TIME);
	}
	
	public void setFirstTimeEnd(java.util.Date value) {
		this.firstTimeEnd = value;
	}
	public void setFirstTimeEndString(String value) {
		setFirstTimeEnd(DateConvertUtils.parse(value, Trepaire.FORMAT_FIRST_TIME,java.util.Date.class));
	}
	
	public java.util.Date getLastTimeBegin() {
		return this.lastTimeBegin;
	}
	
	public String getLastTimeBeginString() {
		return DateConvertUtils.format(getLastTimeBegin(), Trepaire.FORMAT_LAST_TIME);
	}
	
	public void setLastTimeBegin(java.util.Date value) {
		this.lastTimeBegin = value;
	}	
	
	public void setLastTimeBeginString(String value) {
		setLastTimeBegin(DateConvertUtils.parse(value, Trepaire.FORMAT_LAST_TIME,java.util.Date.class));
	}
	
	public java.util.Date getLastTimeEnd() {
		return this.lastTimeEnd;
	}
	
	public String getLastTimeEndString() {
		return DateConvertUtils.format(getLastTimeEnd(), Trepaire.FORMAT_LAST_TIME);
	}
	
	public void setLastTimeEnd(java.util.Date value) {
		this.lastTimeEnd = value;
	}
	public void setLastTimeEndString(String value) {
		setLastTimeEnd(DateConvertUtils.parse(value, Trepaire.FORMAT_LAST_TIME,java.util.Date.class));
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.String getField1() {
		return this.field1;
	}
	
	public void setField1(java.lang.String value) {
		this.field1 = value;
	}
	
	public java.lang.String getField2() {
		return this.field2;
	}
	
	public void setField2(java.lang.String value) {
		this.field2 = value;
	}
	
	public java.lang.String getField3() {
		return this.field3;
	}
	
	public void setField3(java.lang.String value) {
		this.field3 = value;
	}
	
	public String getSortColumns(){
		return (getSortColumns(orderField,orderDirection) == null?
				getSortColumns(orderColumnsMap):getSortColumns(orderField,orderDirection));
	}

	static public String getSortColumns(String orderField,String orderDirection){
		if(StringUtils.isNotBlank(orderField)){
			StringBuffer orderColumns = new StringBuffer();
			if(orderField.equals("repaireId")){
				orderColumns.append("repaire_id");
			}
			if(orderField.equals("aircraftId")){
				orderColumns.append("aircraft_id");
			}
			if(orderField.equals("aircraftName")){
				orderColumns.append("aircraft_name");
			}
			if(orderField.equals("breakContent")){
				orderColumns.append("break_content");
			}
			if(orderField.equals("paln")){
				orderColumns.append("paln");
			}
			if(orderField.equals("operator")){
				orderColumns.append("operator");
			}
			if(orderField.equals("firstTime")){
				orderColumns.append("first_time");
			}
			if(orderField.equals("lastTime")){
				orderColumns.append("last_time");
			}
			if(orderField.equals("userId")){
				orderColumns.append("user_id");
			}
			if(orderField.equals("field1")){
				orderColumns.append("field1");
			}
			if(orderField.equals("field2")){
				orderColumns.append("field2");
			}
			if(orderField.equals("field3")){
				orderColumns.append("field3");
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
		if(repaireId != null){
			str.append("&repaireId=").append(repaireId);
		}
		if(aircraftId != null){
			str.append("&aircraftId=").append(aircraftId);
		}
		if(aircraftName != null){
			str.append("&aircraftName=").append(aircraftName);
		}
		if(breakContent != null){
			str.append("&breakContent=").append(breakContent);
		}
		if(paln != null){
			str.append("&paln=").append(paln);
		}
		if(operator != null){
			str.append("&operator=").append(operator);
		}
		if(firstTimeBegin != null){
			str.append("&firstTimeBegin=").append(firstTimeBegin);
		}
		if(firstTimeBegin != null){
			str.append("&firstTimeEnd=").append(firstTimeEnd);
		}
		if(lastTimeBegin != null){
			str.append("&lastTimeBegin=").append(lastTimeBegin);
		}
		if(lastTimeBegin != null){
			str.append("&lastTimeEnd=").append(lastTimeEnd);
		}
		if(userId != null){
			str.append("&userId=").append(userId);
		}
		if(field1 != null){
			str.append("&field1=").append(field1);
		}
		if(field2 != null){
			str.append("&field2=").append(field2);
		}
		if(field3 != null){
			str.append("&field3=").append(field3);
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

