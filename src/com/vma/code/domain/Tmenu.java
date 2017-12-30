/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.vma.code.domain;

import java.util.List;

import javax.validation.constraints.Max;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;


public class Tmenu implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Tmenu";
	public static final String ALIAS_MENU_ID = "menuId";
	public static final String ALIAS_MENU_NAME = "menuName";
	public static final String ALIAS_MENU_URL = "menuUrl";
	public static final String ALIAS_PARENT_ID = "parentId";
	public static final String ALIAS_FIELD1 = "field1";
	public static final String ALIAS_FIELD2 = "field2";
	public static final String ALIAS_FIELD3 = "field3";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * menuId       db_column: menu_id 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer menuId;
	
    /**
     * menuName       db_column: menu_name 
     */ 	
	@Length(max=100)
	private java.lang.String menuName;
	
    /**
     * menuUrl       db_column: menu_url 
     */ 	
	@Length(max=100)
	private java.lang.String menuUrl;
	
    /**
     * parentId       db_column: parent_id 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer parentId;
	
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
	
	private List<Tmenu> sonList;
	
	//columns END

	public Tmenu(){
	}

	public Tmenu(
		java.lang.Integer menuId
	){
		this.menuId = menuId;
	}

		
	public void setMenuId(java.lang.Integer value) {
		this.menuId = value;
	}
	
	public java.lang.Integer getMenuId() {
		return this.menuId;
	}		
	
		
	public void setMenuName(java.lang.String value) {
		this.menuName = value;
	}
	
	public java.lang.String getMenuName() {
		return this.menuName;
	}		
	
		
	public void setMenuUrl(java.lang.String value) {
		this.menuUrl = value;
	}
	
	public java.lang.String getMenuUrl() {
		return this.menuUrl;
	}		
	
		
	public void setParentId(java.lang.Integer value) {
		this.parentId = value;
	}
	
	public java.lang.Integer getParentId() {
		return this.parentId;
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
			.append("MenuId",getMenuId())
			.append("MenuName",getMenuName())
			.append("MenuUrl",getMenuUrl())
			.append("ParentId",getParentId())
			.append("Field1",getField1())
			.append("Field2",getField2())
			.append("Field3",getField3())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getMenuId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tmenu == false) return false;
		if(this == obj) return true;
		Tmenu other = (Tmenu)obj;
		return new EqualsBuilder()
			.append(getMenuId(),other.getMenuId())
			.isEquals();
	}

	public List<Tmenu> getSonList() {
		return sonList;
	}

	public void setSonList(List<Tmenu> sonList) {
		this.sonList = sonList;
	}
}

