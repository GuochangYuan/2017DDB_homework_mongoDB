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


public class Tbreak implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Tbreak";
	public static final String ALIAS_BREAK_ID = "breakId";
	public static final String ALIAS_AIRCRAFT_ID = "飞机编号";
	public static final String ALIAS_AIRCRAFT_NAME = "飞机名称";
	public static final String ALIAS_BREAK_NAME = "故障名称";
	public static final String ALIAS_CONTENT = "故障描述";
	public static final String ALIAS_CREATE_TIME = "故障发生时间";
	public static final String ALIAS_USER_ID = "提交用户id";
	public static final String ALIAS_FIELD1 = "field1";
	public static final String ALIAS_FIELD2 = "field2";
	public static final String ALIAS_FIELD3 = "field3";
	
	//date formats
	public static final String FORMAT_CREATE_TIME =DateFormats.DATE_TIME_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * breakId       db_column: break_id 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer breakId;
	
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
     * 故障名称       db_column: break_name 
     */ 	
	@Length(max=200)
	private java.lang.String breakName;
	
    /**
     * 故障描述       db_column: content 
     */ 	
	@Length(max=65535)
	private java.lang.String content;
	
    /**
     * 故障发生时间       db_column: create_time 
     */ 	
	
	private java.util.Date createTime;
	
	private String createTimeString;
    /**
     * 提交用户id       db_column: user_id 
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

	public Tbreak(){
	}

	public Tbreak(
		java.lang.Integer breakId
	){
		this.breakId = breakId;
	}

		
	public void setBreakId(java.lang.Integer value) {
		this.breakId = value;
	}
	
	public java.lang.Integer getBreakId() {
		return this.breakId;
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
	
		
	public void setBreakName(java.lang.String value) {
		this.breakName = value;
	}
	
	public java.lang.String getBreakName() {
		return this.breakName;
	}		
	
		
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	
	public java.lang.String getContent() {
		return this.content;
	}		
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
		this.createTimeString = getCreateTimeString();
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public String getCreateTimeString() {
		return this.createTimeString = DateConvertUtils.format(getCreateTime(), FORMAT_CREATE_TIME);
	}
	public void setCreateTimeString(String value) {
		setCreateTime(DateConvertUtils.parse(value, FORMAT_CREATE_TIME,java.util.Date.class));
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
			.append("BreakId",getBreakId())
			.append("AircraftId",getAircraftId())
			.append("AircraftName",getAircraftName())
			.append("BreakName",getBreakName())
			.append("Content",getContent())
			.append("CreateTime",getCreateTime())
			.append("UserId",getUserId())
			.append("Field1",getField1())
			.append("Field2",getField2())
			.append("Field3",getField3())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getBreakId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tbreak == false) return false;
		if(this == obj) return true;
		Tbreak other = (Tbreak)obj;
		return new EqualsBuilder()
			.append(getBreakId(),other.getBreakId())
			.isEquals();
	}
}

