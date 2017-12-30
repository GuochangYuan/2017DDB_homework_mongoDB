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

import com.vma.code.domain.Tbreak;
import com.vma.code.query.TbreakQuery;
import common.base.BaseIbatisDao;


@Repository
public class TbreakDao extends BaseIbatisDao<Tbreak,java.lang.Integer>{
	
	private static Log log = LogFactory.getLog(TbreakDao.class);
	
	@Override
	public String getIbatisSqlMapNamespace() {
		return "Tbreak";
	}
	
	public void saveOrUpdate(Tbreak entity) {
		if(entity.getBreakId() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findPage(TbreakQuery query) {
		return pageQuery("Tbreak.findPage",query);
	}
	
	public List findAll() {
		return findAll(null);
	}
	
	public List findAll(Map<String,String> orderMap) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("sortColumns", TbreakQuery.getSortColumns(orderMap));
		return getSqlMapClientTemplate().queryForList("Tbreak.findAll",map);		
	}
	
	public List find(Map<String,Object> queryMap) {
		return getSqlMapClientTemplate().queryForList("Tbreak.findPage",queryMap);		
	}
	
	
	
	public List findByCondition(TbreakQuery query) {
		return getSqlMapClientTemplate().queryForList("Tbreak.findByCondition",query);		
	}

	@Override
	public boolean isUnique(Tbreak entity, String ... uniquePropertyNames) {
		Assert.assertNotNull(uniquePropertyNames);
		HashMap<String,Object> params = new HashMap<String,Object>();
		for(String nuiquePropertyName : uniquePropertyNames){
			params.put(nuiquePropertyName,PropertyUtils.getProperty(entity, nuiquePropertyName));
		}
		if(entity.getBreakId() != null){
			params.put("breakId",entity.getBreakId());
		}
		long count = (Long)getSqlMapClientTemplate().queryForObject("Tbreak.isUnique", params);
		return (count <= 0 ? true : false);
	}
	
	public void deleteByIds(Map<String, Object> params) {
		getSqlMapClientTemplate().delete("Tbreak.deleteByIds",params);
	}
}
