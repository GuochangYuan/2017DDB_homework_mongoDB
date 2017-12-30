/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
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


public class HyRole implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "HyRole";
	public static final String ALIAS_ROLE_ID = "roleId";
	public static final String ALIAS_ROLE_NAME = "角色名称";
	public static final String ALIAS_MENU_IDS = "权限";
	public static final String ALIAS_ROLE_STATUS = "角色状态";
	public static final String ALIAS_ROLE_REMARK = "备注";
	public static final String ALIAS_CREATE_TIME = "创建时间";
	public static final String ALIAS_FIELD1 = "field1";
	public static final String ALIAS_FIELD2 = "field2";
	public static final String ALIAS_FIELD3 = "field3";
	
	//date formats
	public static final String FORMAT_CREATE_TIME =DateFormats.DATE_TIME_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * roleId       db_column: role_id 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer roleId;
	
    /**
     * roleName       db_column: role_name 
     */ 	
	@Length(max=30)
	private java.lang.String roleName;
	
    /**
     * menuIds       db_column: menu_ids 
     */ 	
	@Length(max=300)
	private java.lang.String menuIds;
	
    /**
     * roleStatus       db_column: role_status 
     */ 	
	@Length(max=10)
	private java.lang.String roleStatus;
	
    /**
     * roleRemark       db_column: role_remark 
     */ 	
	@Length(max=200)
	private java.lang.String roleRemark = "";
	
    /**
     * createTime       db_column: create_time 
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
	@Length(max=10)
	private java.lang.String field2;
	
    /**
     * field3       db_column: field3 
     */ 	
	@Length(max=10)
	private java.lang.String field3;
	
	//columns END

	public HyRole(){
	}

	public HyRole(
		java.lang.Integer roleId
	){
		this.roleId = roleId;
	}

		
	public void setRoleId(java.lang.Integer value) {
		this.roleId = value;
	}
	
	public java.lang.Integer getRoleId() {
		return this.roleId;
	}		
	
		
	public void setRoleName(java.lang.String value) {
		this.roleName = value;
	}
	
	public java.lang.String getRoleName() {
		return this.roleName;
	}		
	
		
	public void setMenuIds(java.lang.String value) {
		this.menuIds = value;
	}
	
	public java.lang.String getMenuIds() {
		return this.menuIds;
	}		
	
		
	public void setRoleStatus(java.lang.String value) {
		this.roleStatus = value;
	}
	
	public java.lang.String getRoleStatus() {
		return this.roleStatus;
	}		
	
		
	public void setRoleRemark(java.lang.String value) {
		this.roleRemark = value;
	}
	
	public java.lang.String getRoleRemark() {
		return this.roleRemark;
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
			.append("RoleId",getRoleId())
			.append("RoleName",getRoleName())
			.append("MenuIds",getMenuIds())
			.append("RoleStatus",getRoleStatus())
			.append("RoleRemark",getRoleRemark())
			.append("CreateTime",getCreateTime())
			.append("Field1",getField1())
			.append("Field2",getField2())
			.append("Field3",getField3())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRoleId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof HyRole == false) return false;
		if(this == obj) return true;
		HyRole other = (HyRole)obj;
		return new EqualsBuilder()
			.append(getRoleId(),other.getRoleId())
			.isEquals();
	}
}

