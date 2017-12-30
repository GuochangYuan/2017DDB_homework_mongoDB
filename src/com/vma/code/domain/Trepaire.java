/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2017
 */

package com.vma.code.domain;

import javax.validation.constraints.Max;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

import cn.org.rapid_framework.util.DateConvertUtils;

import common.util.DateFormats;


public class Trepaire implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Trepaire";
	public static final String ALIAS_REPAIRE_ID = "repaireId";
	public static final String ALIAS_AIRCRAFT_ID = "飞机编号";
	public static final String ALIAS_AIRCRAFT_NAME = "飞机名称";
	public static final String ALIAS_BREAK_CONTENT = "故障描述";
	public static final String ALIAS_PALN = "维修方案";
	public static final String ALIAS_OPERATOR = "维修者";
	public static final String ALIAS_FIRST_TIME = "维修起始时间";
	public static final String ALIAS_LAST_TIME = "维修起始";
	public static final String ALIAS_USER_ID = "操作用户id";
	public static final String ALIAS_FIELD1 = "field1";
	public static final String ALIAS_FIELD2 = "field2";
	public static final String ALIAS_FIELD3 = "field3";
	
	//date formats
	public static final String FORMAT_FIRST_TIME =DateFormats.DATE_TIME_FORMAT;
	public static final String FORMAT_LAST_TIME =DateFormats.DATE_TIME_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * repaireId       db_column: repaire_id 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer repaireId;
	
    /**
     * 飞机编号       db_column: aircraft_id 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer aircraftId;
	
    /**
     * 飞机名称       db_column: aircraft_name 
     */ 	
	@Length(max=100)
	private java.lang.String aircraftName;
	
    /**
     * 故障描述       db_column: break_content 
     */ 	
	@Length(max=65535)
	private java.lang.String breakContent;
	
    /**
     * 维修方案       db_column: paln 
     */ 	
	@Length(max=65535)
	private java.lang.String paln;
	
    /**
     * 维修者       db_column: operator 
     */ 	
	@Length(max=50)
	private java.lang.String operator;
	
    /**
     * 维修起始时间       db_column: first_time 
     */ 	
	
	private java.util.Date firstTime;
	
	private String firstTimeString;
    /**
     * 维修起始       db_column: last_time 
     */ 	
	
	private java.util.Date lastTime;
	
	private String lastTimeString;
    /**
     * 操作用户id       db_column: user_id 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer userId;
	
    /**
     * field1       db_column: field1 
     */ 	
	@Length(max=10)
	private java.lang.String field1;
	
    /**
     * field2       db_column: field2 
     */ 	
	@Length(max=10)
	private java.lang.String field2;
	
    /**
     * field3       db_column: field3 
     */ 	
	@Length(max=10)
	private java.lang.String field3;
	
	//columns END

	public Trepaire(){
	}

	public Trepaire(
		java.lang.Integer repaireId
	){
		this.repaireId = repaireId;
	}

		
	public void setRepaireId(java.lang.Integer value) {
		this.repaireId = value;
	}
	
	public java.lang.Integer getRepaireId() {
		return this.repaireId;
	}		
	
		
	public void setAircraftId(java.lang.Integer value) {
		this.aircraftId = value;
	}
	
	public java.lang.Integer getAircraftId() {
		return this.aircraftId;
	}		
	
		
	public void setAircraftName(java.lang.String value) {
		this.aircraftName = value;
	}
	
	public java.lang.String getAircraftName() {
		return this.aircraftName;
	}		
	
		
	public void setBreakContent(java.lang.String value) {
		this.breakContent = value;
	}
	
	public java.lang.String getBreakContent() {
		return this.breakContent;
	}		
	
		
	public void setPaln(java.lang.String value) {
		this.paln = value;
	}
	
	public java.lang.String getPaln() {
		return this.paln;
	}		
	
		
	public void setOperator(java.lang.String value) {
		this.operator = value;
	}
	
	public java.lang.String getOperator() {
		return this.operator;
	}		
	
	public void setFirstTime(java.util.Date value) {
		this.firstTime = value;
		this.firstTimeString = getFirstTimeString();
	}
	
	public java.util.Date getFirstTime() {
		return this.firstTime;
	}
	
	public String getFirstTimeString() {
		return this.firstTimeString = DateConvertUtils.format(getFirstTime(), FORMAT_FIRST_TIME);
	}
	public void setFirstTimeString(String value) {
		setFirstTime(DateConvertUtils.parse(value, FORMAT_FIRST_TIME,java.util.Date.class));
	}
	public void setLastTime(java.util.Date value) {
		this.lastTime = value;
		this.lastTimeString = getLastTimeString();
	}
	
	public java.util.Date getLastTime() {
		return this.lastTime;
	}
	
	public String getLastTimeString() {
		return this.lastTimeString = DateConvertUtils.format(getLastTime(), FORMAT_LAST_TIME);
	}
	public void setLastTimeString(String value) {
		setLastTime(DateConvertUtils.parse(value, FORMAT_LAST_TIME,java.util.Date.class));
	}
		
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}		
	
		
	public void setField1(java.lang.String value) {
		this.field1 = value;
	}
	
	public java.lang.String getField1() {
		return this.field1;
	}		
	
		
	public void setField2(java.lang.String value) {
		this.field2 = value;
	}
	
	public java.lang.String getField2() {
		return this.field2;
	}		
	
		
	public void setField3(java.lang.String value) {
		this.field3 = value;
	}
	
	public java.lang.String getField3() {
		return this.field3;
	}		
	
	

	public String toString() {
		return new ToStringBuilder(this)
			.append("RepaireId",getRepaireId())
			.append("AircraftId",getAircraftId())
			.append("AircraftName",getAircraftName())
			.append("BreakContent",getBreakContent())
			.append("Paln",getPaln())
			.append("Operator",getOperator())
			.append("FirstTime",getFirstTime())
			.append("LastTime",getLastTime())
			.append("UserId",getUserId())
			.append("Field1",getField1())
			.append("Field2",getField2())
			.append("Field3",getField3())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRepaireId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Trepaire == false) return false;
		if(this == obj) return true;
		Trepaire other = (Trepaire)obj;
		return new EqualsBuilder()
			.append(getRepaireId(),other.getRepaireId())
			.isEquals();
	}
}

