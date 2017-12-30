/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2017
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

import com.vma.code.domain.Taircraft;
import com.vma.code.query.TaircraftQuery;
import common.base.BaseIbatisDao;


@Repository
public class TaircraftDao extends BaseIbatisDao<Taircraft,java.lang.Integer>{
	
	private static Log log = LogFactory.getLog(TaircraftDao.class);
	
	@Override
	public String getIbatisSqlMapNamespace() {
		return "Taircraft";
	}
	
	public void saveOrUpdate(Taircraft entity) {
		if(entity.getAircraftId() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findPage(TaircraftQuery query) {
		return pageQuery("Taircraft.findPage",query);
	}
	
	public List findAll() {
		return findAll(null);
	}
	
	public List findAll(Map<String,String> orderMap) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("sortColumns", TaircraftQuery.getSortColumns(orderMap));
		return getSqlMapClientTemplate().queryForList("Taircraft.findAll",map);		
	}
	
	public List find(Map<String,Object> queryMap) {
		return getSqlMapClientTemplate().queryForList("Taircraft.findPage",queryMap);		
	}
	
	
	
	public List findByCondition(TaircraftQuery query) {
		return getSqlMapClientTemplate().queryForList("Taircraft.findByCondition",query);		
	}

	@Override
	public boolean isUnique(Taircraft entity, String ... uniquePropertyNames) {
		Assert.assertNotNull(uniquePropertyNames);
		HashMap<String,Object> params = new HashMap<String,Object>();
		for(String nuiquePropertyName : uniquePropertyNames){
			params.put(nuiquePropertyName,PropertyUtils.getProperty(entity, nuiquePropertyName));
		}
		if(entity.getAircraftId() != null){
			params.put("aircraftId",entity.getAircraftId());
		}
		long count = (Long)getSqlMapClientTemplate().queryForObject("Taircraft.isUnique", params);
		return (count <= 0 ? true : false);
	}
	
	public void deleteByIds(Map<String, Object> params) {
		getSqlMapClientTemplate().delete("Taircraft.deleteByIds",params);
	}
}
