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


public class Tgood implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Tgood";
	public static final String ALIAS_GOOD_ID = "goodId";
	public static final String ALIAS_GOOD_NAME = "商品名称";
	public static final String ALIAS_GOOD_TYPE = "商品类型";
	public static final String ALIAS_GOOD_UNIT = "商品单位";
	public static final String ALIAS_MIN_STOCK = "最小库存量";
	public static final String ALIAS_STOCK = "实际库存量";
	public static final String ALIAS_FIELD1 = "采购单位";
	public static final String ALIAS_FIELD2 = "转换比";
	public static final String ALIAS_FIELD3 = "规格";
	public static final String ALIAS_FIELD4 = "field4";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * goodId       db_column: good_id 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer goodId;
	
    /**
     * 商品名称       db_column: good_name 
     */ 	
	@Length(max=100)
	private java.lang.String goodName;
	
    /**
     * 商品类型       db_column: good_type 
     */ 	
	@Length(max=50)
	private java.lang.String goodType;
	
    /**
     * 商品单位       db_column: good_unit 
     */ 	
	@Length(max=10)
	private java.lang.String goodUnit;
	
    /**
     * 最小库存量       db_column: min_stock 
     */ 	
	
	private java.lang.Double minStock;
	
    /**
     * 实际库存量       db_column: stock 
     */ 	
	
	private java.lang.Double stock;
	
    /**
     * 采购单位       db_column: field1 
     */ 	
	@Length(max=10)
	private java.lang.String field1;
	
    /**
     * 转换比       db_column: field2 
     */ 	
	@Length(max=10)
	private java.lang.String field2;
	
    /**
     * 规格       db_column: field3 
     */ 	
	@Length(max=50)
	private java.lang.String field3;
	
    /**
     * field4       db_column: field4 
     */ 	
	@Length(max=10)
	private java.lang.String field4;
	
	//columns END

	public Tgood(){
	}

	public Tgood(
		java.lang.Integer goodId
	){
		this.goodId = goodId;
	}

		
	public void setGoodId(java.lang.Integer value) {
		this.goodId = value;
	}
	
	public java.lang.Integer getGoodId() {
		return this.goodId;
	}		
	
		
	public void setGoodName(java.lang.String value) {
		this.goodName = value;
	}
	
	public java.lang.String getGoodName() {
		return this.goodName;
	}		
	
		
	public void setGoodType(java.lang.String value) {
		this.goodType = value;
	}
	
	public java.lang.String getGoodType() {
		return this.goodType;
	}		
	
		
	public void setGoodUnit(java.lang.String value) {
		this.goodUnit = value;
	}
	
	public java.lang.String getGoodUnit() {
		return this.goodUnit;
	}		
	
		
	public void setMinStock(java.lang.Double value) {
		this.minStock = value;
	}
	
	public java.lang.Double getMinStock() {
		return this.minStock;
	}		
	
		
	public void setStock(java.lang.Double value) {
		this.stock = value;
	}
	
	public java.lang.Double getStock() {
		return this.stock;
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
	
		
	public void setField4(java.lang.String value) {
		this.field4 = value;
	}
	
	public java.lang.String getField4() {
		return this.field4;
	}		
	
	

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("GoodId",getGoodId())
			.append("GoodName",getGoodName())
			.append("GoodType",getGoodType())
			.append("GoodUnit",getGoodUnit())
			.append("MinStock",getMinStock())
			.append("Stock",getStock())
			.append("Field1",getField1())
			.append("Field2",getField2())
			.append("Field3",getField3())
			.append("Field4",getField4())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getGoodId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tgood == false) return false;
		if(this == obj) return true;
		Tgood other = (Tgood)obj;
		return new EqualsBuilder()
			.append(getGoodId(),other.getGoodId())
			.isEquals();
	}
}

