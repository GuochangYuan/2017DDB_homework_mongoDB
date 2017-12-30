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


public class Taircraft implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Taircraft";
	public static final String ALIAS_AIRCRAFT_ID = "aircraftId";
	public static final String ALIAS_AIRCRAFT_NAME = "飞机名称";
	public static final String ALIAS_AIRCRAFT_STANDARD = "飞机型号";
	public static final String ALIAS_ENGINE_STANDARD = "发动机型号";
	public static final String ALIAS_AIRCRAFT_FACTORY = "飞机生产厂家";
	public static final String ALIAS_ENGINE_FACTORY = "发动机生产厂家";
	public static final String ALIAS_LENGTH = "长度";
	public static final String ALIAS_WIDTH = "宽度";
	public static final String ALIAS_WEIGHT = "重量";
	public static final String ALIAS_CONTAIN = "座位数";
	public static final String ALIAS_LIFETIME = "寿命";
	public static final String ALIAS_FLYTIME = "飞行时长";
	public static final String ALIAS_DISTANCE = "最大航程";
	public static final String ALIAS_FIELD1 = "field1";
	public static final String ALIAS_FIELD2 = "field2";
	public static final String ALIAS_FIELD3 = "field3";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * aircraftId       db_column: aircraft_id 
     */ 	
	@Max(9999999999L)
	private java.lang.Integer aircraftId;
	
    /**
     * 飞机名称       db_column: aircraft_name 
     */ 	
	@Length(max=100)
	private java.lang.String aircraftName;
	
    /**
     * 飞机型号       db_column: aircraft_standard 
     */ 	
	@Length(max=100)
	private java.lang.String aircraftStandard;
	
    /**
     * 发动机型号       db_column: engine_standard 
     */ 	
	@Length(max=100)
	private java.lang.String engineStandard;
	
    /**
     * 飞机生产厂家       db_column: aircraft_factory 
     */ 	
	@Length(max=200)
	private java.lang.String aircraftFactory;
	
    /**
     * 发动机生产厂家       db_column: engine_factory 
     */ 	
	@Length(max=200)
	private java.lang.String engineFactory;
	
    /**
     * 长度       db_column: length 
     */ 	
	@Length(max=20)
	private java.lang.String length;
	
    /**
     * 宽度       db_column: width 
     */ 	
	@Length(max=20)
	private java.lang.String width;
	
    /**
     * 重量       db_column: weight 
     */ 	
	@Length(max=20)
	private java.lang.String weight;
	
    /**
     * 座位数       db_column: contain 
     */ 	
	@Length(max=20)
	private java.lang.String contain;
	
    /**
     * 寿命       db_column: lifetime 
     */ 	
	@Length(max=20)
	private java.lang.String lifetime;
	
    /**
     * 飞行时长       db_column: flytime 
     */ 	
	@Length(max=20)
	private java.lang.String flytime;
	
    /**
     * 最大航程       db_column: distance 
     */ 	
	@Length(max=20)
	private java.lang.String distance;
	
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

	public Taircraft(){
	}

	public Taircraft(
		java.lang.Integer aircraftId
	){
		this.aircraftId = aircraftId;
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
	
		
	public void setAircraftStandard(java.lang.String value) {
		this.aircraftStandard = value;
	}
	
	public java.lang.String getAircraftStandard() {
		return this.aircraftStandard;
	}		
	
		
	public void setEngineStandard(java.lang.String value) {
		this.engineStandard = value;
	}
	
	public java.lang.String getEngineStandard() {
		return this.engineStandard;
	}		
	
		
	public void setAircraftFactory(java.lang.String value) {
		this.aircraftFactory = value;
	}
	
	public java.lang.String getAircraftFactory() {
		return this.aircraftFactory;
	}		
	
		
	public void setEngineFactory(java.lang.String value) {
		this.engineFactory = value;
	}
	
	public java.lang.String getEngineFactory() {
		return this.engineFactory;
	}		
	
		
	public void setLength(java.lang.String value) {
		this.length = value;
	}
	
	public java.lang.String getLength() {
		return this.length;
	}		
	
		
	public void setWidth(java.lang.String value) {
		this.width = value;
	}
	
	public java.lang.String getWidth() {
		return this.width;
	}		
	
		
	public void setWeight(java.lang.String value) {
		this.weight = value;
	}
	
	public java.lang.String getWeight() {
		return this.weight;
	}		
	
		
	public void setContain(java.lang.String value) {
		this.contain = value;
	}
	
	public java.lang.String getContain() {
		return this.contain;
	}		
	
		
	public void setLifetime(java.lang.String value) {
		this.lifetime = value;
	}
	
	public java.lang.String getLifetime() {
		return this.lifetime;
	}		
	
		
	public void setFlytime(java.lang.String value) {
		this.flytime = value;
	}
	
	public java.lang.String getFlytime() {
		return this.flytime;
	}		
	
		
	public void setDistance(java.lang.String value) {
		this.distance = value;
	}
	
	public java.lang.String getDistance() {
		return this.distance;
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
			.append("AircraftId",getAircraftId())
			.append("AircraftName",getAircraftName())
			.append("AircraftStandard",getAircraftStandard())
			.append("EngineStandard",getEngineStandard())
			.append("AircraftFactory",getAircraftFactory())
			.append("EngineFactory",getEngineFactory())
			.append("Length",getLength())
			.append("Width",getWidth())
			.append("Weight",getWeight())
			.append("Contain",getContain())
			.append("Lifetime",getLifetime())
			.append("Flytime",getFlytime())
			.append("Distance",getDistance())
			.append("Field1",getField1())
			.append("Field2",getField2())
			.append("Field3",getField3())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getAircraftId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Taircraft == false) return false;
		if(this == obj) return true;
		Taircraft other = (Taircraft)obj;
		return new EqualsBuilder()
			.append(getAircraftId(),other.getAircraftId())
			.isEquals();
	}
}

