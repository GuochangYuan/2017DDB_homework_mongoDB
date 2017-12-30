/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.vma.code.domain;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;
import common.base.*;
import common.util.*;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.util.page.*;
import cn.org.rapid_framework.page.*;


import com.vma.code.domain.*;
import com.vma.code.dao.*;

import com.vma.code.query.*;


public class TbWork implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbWork";
	public static final String ALIAS_WORK_ID = "workId";
	public static final String ALIAS_WORK_NAME = "workName";
	public static final String ALIAS_FIELD1 = "field1";
	public static final String ALIAS_FIELD2 = "field2";
	public static final String ALIAS_FIELD3 = "field3";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * workId       db_column: work_id 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer workId;
	
    /**
     * workName       db_column: work_name 
     */ 	
	@Length(max=50)
	private java.lang.String workName;
	
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

	public TbWork(){
	}

	public TbWork(
		java.lang.Integer workId
	){
		this.workId = workId;
	}

		
	public void setWorkId(java.lang.Integer value) {
		this.workId = value;
	}
	
	public java.lang.Integer getWorkId() {
		return this.workId;
	}		
	
		
	public void setWorkName(java.lang.String value) {
		this.workName = value;
	}
	
	public java.lang.String getWorkName() {
		return this.workName;
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
			.append("WorkId",getWorkId())
			.append("WorkName",getWorkName())
			.append("Field1",getField1())
			.append("Field2",getField2())
			.append("Field3",getField3())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getWorkId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TbWork == false) return false;
		if(this == obj) return true;
		TbWork other = (TbWork)obj;
		return new EqualsBuilder()
			.append(getWorkId(),other.getWorkId())
			.isEquals();
	}
}

