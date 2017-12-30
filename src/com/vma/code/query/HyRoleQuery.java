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

import cn.org.rapid_framework.util.DateConvertUtils;

import com.vma.code.domain.HyRole;
import common.dwz.DwzPageQuery;
import common.util.DateFormats;


public class HyRoleQuery extends DwzPageQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    
  //date formats
	public static final String FORMAT_FTIME =DateFormats.DATE_FORMAT;
    

	/** roleId */
	private java.lang.Integer roleId;
	/** roleName */
	private java.lang.String roleName;
	/** menuIds */
	private java.lang.String menuIds;
	/** roleStatus */
	private java.lang.String roleStatus;
	/** roleRemark */
	private java.lang.String roleRemark;
	/** createTime */
	private java.util.Date createTimeBegin;
	private java.util.Date createTimeEnd;
	/** field1 */
	private java.lang.String field1;
	/** field2 */
	private java.lang.String field2;
	/** field3 */
	private java.lang.String field3;

	public java.lang.Integer getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(java.lang.Integer value) {
		this.roleId = value;
	}
	
	public java.lang.String getRoleName() {
		return this.roleName;
	}
	
	public void setRoleName(java.lang.String value) {
		this.roleName = value;
	}
	
	public java.lang.String getMenuIds() {
		return this.menuIds;
	}
	
	public void setMenuIds(java.lang.String value) {
		this.menuIds = value;
	}
	
	public java.lang.String getRoleStatus() {
		return this.roleStatus;
	}
	
	public void setRoleStatus(java.lang.String value) {
		this.roleStatus = value;
	}
	
	public java.lang.String getRoleRemark() {
		return this.roleRemark;
	}
	
	public void setRoleRemark(java.lang.String value) {
		this.roleRemark = value;
	}
	
	public java.util.Date getCreateTimeBegin() {
		return this.createTimeBegin;
	}
	
	public String getCreateTimeBeginString() {
		return DateConvertUtils.format(getCreateTimeBegin(), HyRole.FORMAT_CREATE_TIME);
	}
	
	public void setCreateTimeBegin(java.util.Date value) {
		this.createTimeBegin = value;
	}	
	
	public void setCreateTimeBeginString(String value) {
		setCreateTimeBegin(DateConvertUtils.parse(value, HyRole.FORMAT_CREATE_TIME,java.util.Date.class));
	}
	
	public java.util.Date getCreateTimeEnd() {
		return this.createTimeEnd;
	}
	
	public String getCreateTimeEndString() {
		return DateConvertUtils.format(getCreateTimeEnd(), HyRole.FORMAT_CREATE_TIME);
	}
	
	public void setCreateTimeEnd(java.util.Date value) {
		this.createTimeEnd = value;
	}
	public void setCreateTimeEndString(String value) {
		setCreateTimeEnd(DateConvertUtils.parse(value, HyRole.FORMAT_CREATE_TIME,java.util.Date.class));
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
			if(orderField.equals("roleId")){
				orderColumns.append("role_id");
			}
			if(orderField.equals("roleName")){
				orderColumns.append("role_name");
			}
			if(orderField.equals("menuIds")){
				orderColumns.append("menu_ids");
			}
			if(orderField.equals("roleStatus")){
				orderColumns.append("role_status");
			}
			if(orderField.equals("roleRemark")){
				orderColumns.append("role_remark");
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
		if(roleId != null){
			str.append("&roleId=").append(roleId);
		}
		if(roleName != null){
			str.append("&roleName=").append(roleName);
		}
		if(menuIds != null){
			str.append("&menuIds=").append(menuIds);
		}
		if(roleStatus != null){
			str.append("&roleStatus=").append(roleStatus);
		}
		if(roleRemark != null){
			str.append("&roleRemark=").append(roleRemark);
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

