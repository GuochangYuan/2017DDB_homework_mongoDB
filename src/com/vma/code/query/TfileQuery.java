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

import cn.org.rapid_framework.util.DateConvertUtils;

import com.vma.code.domain.Tfile;
import common.dwz.DwzPageQuery;
import common.util.DateFormats;


public class TfileQuery extends DwzPageQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    
  //date formats
	public static final String FORMAT_FTIME =DateFormats.DATE_FORMAT;
    

	/** fileId */
	private java.lang.Integer fileId;
	/** 文件名 */
	private java.lang.String fileName;
	/** 地址 */
	private java.lang.String address;
	/** 状态 */
	private java.lang.String status;
	/** 创建日期 */
	private java.util.Date createTimeBegin;
	private java.util.Date createTimeEnd;
	/** field1 */
	private java.lang.String field1;
	/** field2 */
	private java.lang.String field2;
	/** field3 */
	private java.lang.String field3;

	public java.lang.Integer getFileId() {
		return this.fileId;
	}
	
	public void setFileId(java.lang.Integer value) {
		this.fileId = value;
	}
	
	public java.lang.String getFileName() {
		return this.fileName;
	}
	
	public void setFileName(java.lang.String value) {
		this.fileName = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.util.Date getCreateTimeBegin() {
		return this.createTimeBegin;
	}
	
	public String getCreateTimeBeginString() {
		return DateConvertUtils.format(getCreateTimeBegin(), Tfile.FORMAT_CREATE_TIME);
	}
	
	public void setCreateTimeBegin(java.util.Date value) {
		this.createTimeBegin = value;
	}	
	
	public void setCreateTimeBeginString(String value) {
		setCreateTimeBegin(DateConvertUtils.parse(value, Tfile.FORMAT_CREATE_TIME,java.util.Date.class));
	}
	
	public java.util.Date getCreateTimeEnd() {
		return this.createTimeEnd;
	}
	
	public String getCreateTimeEndString() {
		return DateConvertUtils.format(getCreateTimeEnd(), Tfile.FORMAT_CREATE_TIME);
	}
	
	public void setCreateTimeEnd(java.util.Date value) {
		this.createTimeEnd = value;
	}
	public void setCreateTimeEndString(String value) {
		setCreateTimeEnd(DateConvertUtils.parse(value, Tfile.FORMAT_CREATE_TIME,java.util.Date.class));
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
			if(orderField.equals("fileId")){
				orderColumns.append("file_id");
			}
			if(orderField.equals("fileName")){
				orderColumns.append("file_name");
			}
			if(orderField.equals("address")){
				orderColumns.append("address");
			}
			if(orderField.equals("status")){
				orderColumns.append("status");
			}
			if(orderField.equals("createTime")){
				orderColumns.append("create_time");
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
		if(fileId != null){
			str.append("&fileId=").append(fileId);
		}
		if(fileName != null){
			str.append("&fileName=").append(fileName);
		}
		if(address != null){
			str.append("&address=").append(address);
		}
		if(status != null){
			str.append("&status=").append(status);
		}
		if(createTimeBegin != null){
			str.append("&createTimeBegin=").append(createTimeBegin);
		}
		if(createTimeBegin != null){
			str.append("&createTimeEnd=").append(createTimeEnd);
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

