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

import common.dwz.DwzPageQuery;
import common.util.DateFormats;


public class TaircraftQuery extends DwzPageQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    
  //date formats
	public static final String FORMAT_FTIME =DateFormats.DATE_FORMAT;
    

	/** aircraftId */
	private java.lang.Integer aircraftId;
	/** 飞机名称 */
	private java.lang.String aircraftName;
	/** 飞机型号 */
	private java.lang.String aircraftStandard;
	/** 发动机型号 */
	private java.lang.String engineStandard;
	/** 飞机生产厂家 */
	private java.lang.String aircraftFactory;
	/** 发动机生产厂家 */
	private java.lang.String engineFactory;
	/** 长度 */
	private java.lang.String length;
	/** 宽度 */
	private java.lang.String width;
	/** 重量 */
	private java.lang.String weight;
	/** 座位数 */
	private java.lang.String contain;
	/** 寿命 */
	private java.lang.String lifetime;
	/** 飞行时长 */
	private java.lang.String flytime;
	/** 最大航程 */
	private java.lang.String distance;
	/** field1 */
	private java.lang.String field1;
	/** field2 */
	private java.lang.String field2;
	/** field3 */
	private java.lang.String field3;

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
	
	public java.lang.String getAircraftStandard() {
		return this.aircraftStandard;
	}
	
	public void setAircraftStandard(java.lang.String value) {
		this.aircraftStandard = value;
	}
	
	public java.lang.String getEngineStandard() {
		return this.engineStandard;
	}
	
	public void setEngineStandard(java.lang.String value) {
		this.engineStandard = value;
	}
	
	public java.lang.String getAircraftFactory() {
		return this.aircraftFactory;
	}
	
	public void setAircraftFactory(java.lang.String value) {
		this.aircraftFactory = value;
	}
	
	public java.lang.String getEngineFactory() {
		return this.engineFactory;
	}
	
	public void setEngineFactory(java.lang.String value) {
		this.engineFactory = value;
	}
	
	public java.lang.String getLength() {
		return this.length;
	}
	
	public void setLength(java.lang.String value) {
		this.length = value;
	}
	
	public java.lang.String getWidth() {
		return this.width;
	}
	
	public void setWidth(java.lang.String value) {
		this.width = value;
	}
	
	public java.lang.String getWeight() {
		return this.weight;
	}
	
	public void setWeight(java.lang.String value) {
		this.weight = value;
	}
	
	public java.lang.String getContain() {
		return this.contain;
	}
	
	public void setContain(java.lang.String value) {
		this.contain = value;
	}
	
	public java.lang.String getLifetime() {
		return this.lifetime;
	}
	
	public void setLifetime(java.lang.String value) {
		this.lifetime = value;
	}
	
	public java.lang.String getFlytime() {
		return this.flytime;
	}
	
	public void setFlytime(java.lang.String value) {
		this.flytime = value;
	}
	
	public java.lang.String getDistance() {
		return this.distance;
	}
	
	public void setDistance(java.lang.String value) {
		this.distance = value;
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
			if(orderField.equals("aircraftId")){
				orderColumns.append("aircraft_id");
			}
			if(orderField.equals("aircraftName")){
				orderColumns.append("aircraft_name");
			}
			if(orderField.equals("aircraftStandard")){
				orderColumns.append("aircraft_standard");
			}
			if(orderField.equals("engineStandard")){
				orderColumns.append("engine_standard");
			}
			if(orderField.equals("aircraftFactory")){
				orderColumns.append("aircraft_factory");
			}
			if(orderField.equals("engineFactory")){
				orderColumns.append("engine_factory");
			}
			if(orderField.equals("length")){
				orderColumns.append("length");
			}
			if(orderField.equals("width")){
				orderColumns.append("width");
			}
			if(orderField.equals("weight")){
				orderColumns.append("weight");
			}
			if(orderField.equals("contain")){
				orderColumns.append("contain");
			}
			if(orderField.equals("lifetime")){
				orderColumns.append("lifetime");
			}
			if(orderField.equals("flytime")){
				orderColumns.append("flytime");
			}
			if(orderField.equals("distance")){
				orderColumns.append("distance");
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
		if(aircraftId != null){
			str.append("&aircraftId=").append(aircraftId);
		}
		if(aircraftName != null){
			str.append("&aircraftName=").append(aircraftName);
		}
		if(aircraftStandard != null){
			str.append("&aircraftStandard=").append(aircraftStandard);
		}
		if(engineStandard != null){
			str.append("&engineStandard=").append(engineStandard);
		}
		if(aircraftFactory != null){
			str.append("&aircraftFactory=").append(aircraftFactory);
		}
		if(engineFactory != null){
			str.append("&engineFactory=").append(engineFactory);
		}
		if(length != null){
			str.append("&length=").append(length);
		}
		if(width != null){
			str.append("&width=").append(width);
		}
		if(weight != null){
			str.append("&weight=").append(weight);
		}
		if(contain != null){
			str.append("&contain=").append(contain);
		}
		if(lifetime != null){
			str.append("&lifetime=").append(lifetime);
		}
		if(flytime != null){
			str.append("&flytime=").append(flytime);
		}
		if(distance != null){
			str.append("&distance=").append(distance);
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

