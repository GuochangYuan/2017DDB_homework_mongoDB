/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.vma.code.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.beanutils.PropertyUtils;
import cn.org.rapid_framework.page.Page;

import com.vma.code.domain.HyRole;
import com.vma.code.query.HyRoleQuery;
import common.base.BaseIbatisDao;


@Repository
public class HyRoleDao extends BaseIbatisDao<HyRole,java.lang.Integer>{
	
	private static Log log = LogFactory.getLog(HyRoleDao.class);
	
	@Override
	public String getIbatisSqlMapNamespace() {
		return "HyRole";
	}
	
	public void saveOrUpdate(HyRole entity) {
		if(entity.getRoleId() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findPage(HyRoleQuery query) {
		return pageQuery("HyRole.findPage",query);
	}
	
	public List findAll() {
		return findAll(null);
	}
	
	public List findAll(Map<String,String> orderMap) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("sortColumns", HyRoleQuery.getSortColumns(orderMap));
		return getSqlMapClientTemplate().queryForList("HyRole.findAll",map);		
	}
	
	public List find(Map<String,Object> queryMap) {
		return getSqlMapClientTemplate().queryForList("HyRole.findPage",queryMap);		
	}
	
	
	
	public List findByCondition(HyRoleQuery query) {
		return getSqlMapClientTemplate().queryForList("HyRole.findByCondition",query);		
	}

	@Override
	public boolean isUnique(HyRole entity, String ... uniquePropertyNames) {
		Assert.assertNotNull(uniquePropertyNames);
		HashMap<String,Object> params = new HashMap<String,Object>();
		for(String nuiquePropertyName : uniquePropertyNames){
			params.put(nuiquePropertyName,PropertyUtils.getProperty(entity, nuiquePropertyName));
		}
		if(entity.getRoleId() != null){
			params.put("roleId",entity.getRoleId());
		}
		long count = (Long)getSqlMapClientTemplate().queryForObject("HyRole.isUnique", params);
		return (count <= 0 ? true : false);
	}
	
	public void deleteByIds(Map<String, Object> params) {
		getSqlMapClientTemplate().delete("HyRole.deleteByIds",params);
	}
}
