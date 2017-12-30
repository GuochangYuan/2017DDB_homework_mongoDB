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
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

import cn.org.rapid_framework.util.DateConvertUtils;

import common.util.DateFormats;


public class Tfile implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Tfile";
	public static final String ALIAS_FILE_ID = "fileId";
	public static final String ALIAS_FILE_NAME = "文件名";
	public static final String ALIAS_ADDRESS = "地址";
	public static final String ALIAS_STATUS = "状态";
	public static final String ALIAS_CREATE_TIME = "创建日期";
	public static final String ALIAS_FIELD1 = "field1";
	public static final String ALIAS_FIELD2 = "field2";
	public static final String ALIAS_FIELD3 = "field3";
	
	//date formats
	public static final String FORMAT_CREATE_TIME =DateFormats.DATE_TIME_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * fileId       db_column: file_id 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer fileId;
	
    /**
     * 文件名       db_column: file_name 
     */ 	
	@Length(max=100)
	private java.lang.String fileName;
	
    /**
     * 地址       db_column: address 
     */ 	
	@Length(max=200)
	private java.lang.String address;
	
    /**
     * 状态       db_column: status 
     */ 	
	@Length(max=10)
	private java.lang.String status;
	
    /**
     * 创建日期       db_column: create_time 
     */ 	
	
	private java.util.Date createTime;
	
	private String createTimeString;
    /**
     * field1       db_column: field1 
     */ 	
	@Length(max=10)
	private java.lang.String field1;
	
    /**
     * field2       db_column: field2 
     */ 	
	@Length(max=50)
	private java.lang.String field2;
	
    /**
     * field3       db_column: field3 
     */ 	
	@Length(max=10)
	private java.lang.String field3;
	
	//columns END

	public Tfile(){
	}

	public Tfile(
		java.lang.Integer fileId
	){
		this.fileId = fileId;
	}

		
	public void setFileId(java.lang.Integer value) {
		this.fileId = value;
	}
	
	public java.lang.Integer getFileId() {
		return this.fileId;
	}		
	
		
	public void setFileName(java.lang.String value) {
		this.fileName = value;
	}
	
	public java.lang.String getFileName() {
		return this.fileName;
	}		
	
		
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}		
	
		
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
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
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("FileId",getFileId())
			.append("FileName",getFileName())
			.append("Address",getAddress())
			.append("Status",getStatus())
			.append("CreateTime",getCreateTime())
			.append("Field1",getField1())
			.append("Field2",getField2())
			.append("Field3",getField3())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getFileId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tfile == false) return false;
		if(this == obj) return true;
		Tfile other = (Tfile)obj;
		return new EqualsBuilder()
			.append(getFileId(),other.getFileId())
			.isEquals();
	}
}

