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


public class TbDepartment implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TbDepartment";
	public static final String ALIAS_DT_ID = "dtId";
	public static final String ALIAS_DT_NAME = "部门名称";
	public static final String ALIAS_DT_CREATE_TIME = "创建时间";
	public static final String ALIAS_DT_BZ = "备注";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * dtId       db_column: dt_id 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer dtId;
	
    /**
     * 部门名称       db_column: dt_name 
     */ 	
	@Length(max=10)
	private java.lang.String dtName;
	
    /**
     * 创建时间       db_column: dt_createTime 
     */ 	
	@Length(max=20)
	private java.lang.String dtCreateTime;
	
    /**
     * 备注       db_column: dt_bz 
     */ 	
	@Length(max=50)
	private java.lang.String dtBz;
	
	//columns END

	public TbDepartment(){
	}

	public TbDepartment(
		java.lang.Integer dtId
	){
		this.dtId = dtId;
	}

		
	public void setDtId(java.lang.Integer value) {
		this.dtId = value;
	}
	
	public java.lang.Integer getDtId() {
		return this.dtId;
	}		
	
		
	public void setDtName(java.lang.String value) {
		this.dtName = value;
	}
	
	public java.lang.String getDtName() {
		return this.dtName;
	}		
	
		
	public void setDtCreateTime(java.lang.String value) {
		this.dtCreateTime = value;
	}
	
	public java.lang.String getDtCreateTime() {
		return this.dtCreateTime;
	}		
	
		
	public void setDtBz(java.lang.String value) {
		this.dtBz = value;
	}
	
	public java.lang.String getDtBz() {
		return this.dtBz;
	}		
	
	

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("DtId",getDtId())
			.append("DtName",getDtName())
			.append("DtCreateTime",getDtCreateTime())
			.append("DtBz",getDtBz())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDtId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TbDepartment == false) return false;
		if(this == obj) return true;
		TbDepartment other = (TbDepartment)obj;
		return new EqualsBuilder()
			.append(getDtId(),other.getDtId())
			.isEquals();
	}
}

