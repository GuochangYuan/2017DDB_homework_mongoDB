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

import com.vma.code.domain.HyUser;
import com.vma.code.query.HyUserQuery;
import common.base.BaseIbatisDao;


@Repository
public class HyUserDao extends BaseIbatisDao<HyUser,java.lang.Integer>{
	
	private static Log log = LogFactory.getLog(HyUserDao.class);
	
	@Override
	public String getIbatisSqlMapNamespace() {
		return "HyUser";
	}
	
	public void saveOrUpdate(HyUser entity) {
		if(entity.getUserId() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findPage(HyUserQuery query) {
		return pageQuery("HyUser.findPage",query);
	}
	
	public List findAll() {
		return findAll(null);
	}
	
	public List findAll(Map<String,String> orderMap) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("sortColumns", HyUserQuery.getSortColumns(orderMap));
		return getSqlMapClientTemplate().queryForList("HyUser.findAll",map);		
	}
	
	public List find(Map<String,Object> queryMap) {
		return getSqlMapClientTemplate().queryForList("HyUser.findPage",queryMap);		
	}
	
	
	
	public List findByCondition(HyUserQuery query) {
		return getSqlMapClientTemplate().queryForList("HyUser.findByCondition",query);		
	}

	@Override
	public boolean isUnique(HyUser entity, String ... uniquePropertyNames) {
		Assert.assertNotNull(uniquePropertyNames);
		HashMap<String,Object> params = new HashMap<String,Object>();
		for(String nuiquePropertyName : uniquePropertyNames){
			params.put(nuiquePropertyName,PropertyUtils.getProperty(entity, nuiquePropertyName));
		}
		if(entity.getUserId() != null){
			params.put("userId",entity.getUserId());
		}
		long count = (Long)getSqlMapClientTemplate().queryForObject("HyUser.isUnique", params);
		return (count <= 0 ? true : false);
	}
	
	public void deleteByIds(Map<String, Object> params) {
		getSqlMapClientTemplate().delete("HyUser.deleteByIds",params);
	}

	public HyUser findLastOne() {
		// TODO Auto-generated method stub
		return (HyUser) getSqlMapClientTemplate().queryForObject("HyUser.findLastOne");
	}
}
