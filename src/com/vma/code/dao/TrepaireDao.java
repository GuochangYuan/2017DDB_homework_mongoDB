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

import com.vma.code.domain.Trepaire;
import com.vma.code.query.TrepaireQuery;
import common.base.BaseIbatisDao;


@Repository
public class TrepaireDao extends BaseIbatisDao<Trepaire,java.lang.Integer>{
	
	private static Log log = LogFactory.getLog(TrepaireDao.class);
	
	@Override
	public String getIbatisSqlMapNamespace() {
		return "Trepaire";
	}
	
	public void saveOrUpdate(Trepaire entity) {
		if(entity.getRepaireId() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findPage(TrepaireQuery query) {
		return pageQuery("Trepaire.findPage",query);
	}
	
	public List findAll() {
		return findAll(null);
	}
	
	public List findAll(Map<String,String> orderMap) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("sortColumns", TrepaireQuery.getSortColumns(orderMap));
		return getSqlMapClientTemplate().queryForList("Trepaire.findAll",map);		
	}
	
	public List find(Map<String,Object> queryMap) {
		return getSqlMapClientTemplate().queryForList("Trepaire.findPage",queryMap);		
	}
	
	
	
	public List findByCondition(TrepaireQuery query) {
		return getSqlMapClientTemplate().queryForList("Trepaire.findByCondition",query);		
	}

	@Override
	public boolean isUnique(Trepaire entity, String ... uniquePropertyNames) {
		Assert.assertNotNull(uniquePropertyNames);
		HashMap<String,Object> params = new HashMap<String,Object>();
		for(String nuiquePropertyName : uniquePropertyNames){
			params.put(nuiquePropertyName,PropertyUtils.getProperty(entity, nuiquePropertyName));
		}
		if(entity.getRepaireId() != null){
			params.put("repaireId",entity.getRepaireId());
		}
		long count = (Long)getSqlMapClientTemplate().queryForObject("Trepaire.isUnique", params);
		return (count <= 0 ? true : false);
	}
	
	public void deleteByIds(Map<String, Object> params) {
		getSqlMapClientTemplate().delete("Trepaire.deleteByIds",params);
	}
}
