package common.base;

import java.io.Serializable;

/**
 * 
 * @Desctiption  
 * @Copyright Copyright (c) 2012 FFCS All Rights Reserved
 * @Company 北京福富软件有限公司
 * @author 李德昌  QQ:283924498
 * @date 2012-9-7
 * @version 1.0
 * @history
 * @param
 */
public abstract class BaseEntity implements  Serializable{
	private static final long serialVersionUID = 1L;

	public String keyId ;
	
	public String tableAlias ;
	
	public String entityInfo ; 
	
	protected abstract String initEntityInfo();
	
	protected abstract String initKeyId();

	protected abstract String initTableAlias();

	/**
	 * @return the keyId
	 */
	public String getKeyId() {
		return initKeyId();
	}

	/**
	 * @param keyId the keyId to set
	 */
	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	/**
	 * @return the tableAlias
	 */
	public String getTableAlias() {
		return initTableAlias();
	}

	/**
	 * @param tableAlias the tableAlias to set
	 */
	public void setTableAlias(String tableAlias) {
		this.tableAlias = tableAlias;
	}

	/**
	 * @return the entityInfo
	 */
	public String getEntityInfo() {
		return initEntityInfo();
	}

	/**
	 * @param entityInfo the entityInfo to set
	 */
	public void setEntityInfo(String entityInfo) {
		this.entityInfo = entityInfo;
	}

}
