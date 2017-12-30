/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
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


public class TgoodQuery extends DwzPageQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    
  //date formats
	public static final String FORMAT_FTIME =DateFormats.DATE_FORMAT;
    

	/** goodId */
	private java.lang.Integer goodId;
	/** 商品名称 */
	private java.lang.String goodName;
	/** 商品类型 */
	private java.lang.String goodType;
	/** 商品单位 */
	private java.lang.String goodUnit;
	/** 最小库存量 */
	private java.lang.Double minStock;
	/** 实际库存量 */
	private java.lang.Double stock;
	/** 采购单位 */
	private java.lang.String field1;
	/** 转换比 */
	private java.lang.String field2;
	/** 规格 */
	private java.lang.String field3;
	/** field4 */
	private java.lang.String field4;

	public java.lang.Integer getGoodId() {
		return this.goodId;
	}
	
	public void setGoodId(java.lang.Integer value) {
		this.goodId = value;
	}
	
	public java.lang.String getGoodName() {
		return this.goodName;
	}
	
	public void setGoodName(java.lang.String value) {
		this.goodName = value;
	}
	
	public java.lang.String getGoodType() {
		return this.goodType;
	}
	
	public void setGoodType(java.lang.String value) {
		this.goodType = value;
	}
	
	public java.lang.String getGoodUnit() {
		return this.goodUnit;
	}
	
	public void setGoodUnit(java.lang.String value) {
		this.goodUnit = value;
	}
	
	public java.lang.Double getMinStock() {
		return this.minStock;
	}
	
	public void setMinStock(java.lang.Double value) {
		this.minStock = value;
	}
	
	public java.lang.Double getStock() {
		return this.stock;
	}
	
	public void setStock(java.lang.Double value) {
		this.stock = value;
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
	
	public java.lang.String getField4() {
		return this.field4;
	}
	
	public void setField4(java.lang.String value) {
		this.field4 = value;
	}
	
	public String getSortColumns(){
		return (getSortColumns(orderField,orderDirection) == null?
				getSortColumns(orderColumnsMap):getSortColumns(orderField,orderDirection));
	}

	static public String getSortColumns(String orderField,String orderDirection){
		if(StringUtils.isNotBlank(orderField)){
			StringBuffer orderColumns = new StringBuffer();
			if(orderField.equals("goodId")){
				orderColumns.append("good_id");
			}
			if(orderField.equals("goodName")){
				orderColumns.append("good_name");
			}
			if(orderField.equals("goodType")){
				orderColumns.append("good_type");
			}
			if(orderField.equals("goodUnit")){
				orderColumns.append("good_unit");
			}
			if(orderField.equals("minStock")){
				orderColumns.append("min_stock");
			}
			if(orderField.equals("stock")){
				orderColumns.append("stock");
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
			if(orderField.equals("field4")){
				orderColumns.append("field4");
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
		if(goodId != null){
			str.append("&goodId=").append(goodId);
		}
		if(goodName != null){
			str.append("&goodName=").append(goodName);
		}
		if(goodType != null){
			str.append("&goodType=").append(goodType);
		}
		if(goodUnit != null){
			str.append("&goodUnit=").append(goodUnit);
		}
		if(minStock != null){
			str.append("&minStock=").append(minStock);
		}
		if(stock != null){
			str.append("&stock=").append(stock);
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
		if(field4 != null){
			str.append("&field4=").append(field4);
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

