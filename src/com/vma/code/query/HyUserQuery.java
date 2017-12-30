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

import com.vma.code.domain.HyUser;
import common.dwz.DwzPageQuery;
import common.util.DateFormats;


public class HyUserQuery extends DwzPageQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    
  //date formats
	public static final String FORMAT_FTIME =DateFormats.DATE_FORMAT;
    

	/** userId */
	private java.lang.Integer userId;
	/** 工号 */
	private java.lang.String userNo;
	/** 姓名 */
	private java.lang.String realName;
	/** 手机号码 */
	private java.lang.String phoneNum;
	/** 联系地址 */
	private java.lang.String address;
	/** 部门名称 */
	private java.lang.Integer dtId;
	/** 岗位名称 */
	private java.lang.Integer workId;
	/** 角色id */
	private java.lang.Integer roleId;
	/** 是否可用 */
	private java.lang.String userStatus;
	/** 备注 */
	private java.lang.String userRemark;
	/** 创建时间 */
	private java.util.Date createTimeBegin;
	private java.util.Date createTimeEnd;
	/** 密码 */
	private java.lang.String field1;
	/** 部门名称 */
	private java.lang.String dtName;
	/** 岗位名称 */
	private java.lang.String emTypeWork;
	/** 基本工资 */
	private java.lang.Double baseSalary;
	/** 是否超级管理员 */
	private java.lang.String isAdmin;
	/** field2 */
	private java.lang.String field2;
	/** field3 */
	private java.lang.String field3;

	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.String getUserNo() {
		return this.userNo;
	}
	
	public void setUserNo(java.lang.String value) {
		this.userNo = value;
	}
	
	public java.lang.String getRealName() {
		return this.realName;
	}
	
	public void setRealName(java.lang.String value) {
		this.realName = value;
	}
	
	public java.lang.String getPhoneNum() {
		return this.phoneNum;
	}
	
	public void setPhoneNum(java.lang.String value) {
		this.phoneNum = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.Integer getDtId() {
		return this.dtId;
	}
	
	public void setDtId(java.lang.Integer value) {
		this.dtId = value;
	}
	
	public java.lang.Integer getWorkId() {
		return this.workId;
	}
	
	public void setWorkId(java.lang.Integer value) {
		this.workId = value;
	}
	
	public java.lang.Integer getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(java.lang.Integer value) {
		this.roleId = value;
	}
	
	public java.lang.String getUserStatus() {
		return this.userStatus;
	}
	
	public void setUserStatus(java.lang.String value) {
		this.userStatus = value;
	}
	
	public java.lang.String getUserRemark() {
		return this.userRemark;
	}
	
	public void setUserRemark(java.lang.String value) {
		this.userRemark = value;
	}
	
	public java.util.Date getCreateTimeBegin() {
		return this.createTimeBegin;
	}
	
	public String getCreateTimeBeginString() {
		return DateConvertUtils.format(getCreateTimeBegin(), HyUser.FORMAT_CREATE_TIME);
	}
	
	public void setCreateTimeBegin(java.util.Date value) {
		this.createTimeBegin = value;
	}	
	
	public void setCreateTimeBeginString(String value) {
		setCreateTimeBegin(DateConvertUtils.parse(value, HyUser.FORMAT_CREATE_TIME,java.util.Date.class));
	}
	
	public java.util.Date getCreateTimeEnd() {
		return this.createTimeEnd;
	}
	
	public String getCreateTimeEndString() {
		return DateConvertUtils.format(getCreateTimeEnd(), HyUser.FORMAT_CREATE_TIME);
	}
	
	public void setCreateTimeEnd(java.util.Date value) {
		this.createTimeEnd = value;
	}
	public void setCreateTimeEndString(String value) {
		setCreateTimeEnd(DateConvertUtils.parse(value, HyUser.FORMAT_CREATE_TIME,java.util.Date.class));
	}
	
	public java.lang.String getField1() {
		return this.field1;
	}
	
	public void setField1(java.lang.String value) {
		this.field1 = value;
	}
	
	public java.lang.String getDtName() {
		return this.dtName;
	}
	
	public void setDtName(java.lang.String value) {
		this.dtName = value;
	}
	
	public java.lang.String getEmTypeWork() {
		return this.emTypeWork;
	}
	
	public void setEmTypeWork(java.lang.String value) {
		this.emTypeWork = value;
	}
	
	public java.lang.Double getBaseSalary() {
		return this.baseSalary;
	}
	
	public void setBaseSalary(java.lang.Double value) {
		this.baseSalary = value;
	}
	
	public java.lang.String getIsAdmin() {
		return this.isAdmin;
	}
	
	public void setIsAdmin(java.lang.String value) {
		this.isAdmin = value;
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
			if(orderField.equals("userId")){
				orderColumns.append("user_id");
			}
			if(orderField.equals("userNo")){
				orderColumns.append("user_no");
			}
			if(orderField.equals("realName")){
				orderColumns.append("real_name");
			}
			if(orderField.equals("phoneNum")){
				orderColumns.append("phone_num");
			}
			if(orderField.equals("address")){
				orderColumns.append("address");
			}
			if(orderField.equals("dtId")){
				orderColumns.append("dt_id");
			}
			if(orderField.equals("workId")){
				orderColumns.append("work_id");
			}
			if(orderField.equals("roleId")){
				orderColumns.append("role_id");
			}
			if(orderField.equals("userStatus")){
				orderColumns.append("user_status");
			}
			if(orderField.equals("userRemark")){
				orderColumns.append("user_remark");
			}
			if(orderField.equals("createTime")){
				orderColumns.append("create_time");
			}
			if(orderField.equals("field1")){
				orderColumns.append("field1");
			}
			if(orderField.equals("dtName")){
				orderColumns.append("dt_name");
			}
			if(orderField.equals("emTypeWork")){
				orderColumns.append("em_typeWork");
			}
			if(orderField.equals("baseSalary")){
				orderColumns.append("base_salary");
			}
			if(orderField.equals("isAdmin")){
				orderColumns.append("isAdmin");
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
		if(userId != null){
			str.append("&userId=").append(userId);
		}
		if(userNo != null){
			str.append("&userNo=").append(userNo);
		}
		if(realName != null){
			str.append("&realName=").append(realName);
		}
		if(phoneNum != null){
			str.append("&phoneNum=").append(phoneNum);
		}
		if(address != null){
			str.append("&address=").append(address);
		}
		if(dtId != null){
			str.append("&dtId=").append(dtId);
		}
		if(workId != null){
			str.append("&workId=").append(workId);
		}
		if(roleId != null){
			str.append("&roleId=").append(roleId);
		}
		if(userStatus != null){
			str.append("&userStatus=").append(userStatus);
		}
		if(userRemark != null){
			str.append("&userRemark=").append(userRemark);
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
		if(dtName != null){
			str.append("&dtName=").append(dtName);
		}
		if(emTypeWork != null){
			str.append("&emTypeWork=").append(emTypeWork);
		}
		if(baseSalary != null){
			str.append("&baseSalary=").append(baseSalary);
		}
		if(isAdmin != null){
			str.append("&isAdmin=").append(isAdmin);
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

