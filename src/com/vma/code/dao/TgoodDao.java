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

import com.vma.code.domain.Tgood;
import com.vma.code.query.TgoodQuery;
import common.base.BaseIbatisDao;


@Repository
public class TgoodDao extends BaseIbatisDao<Tgood,java.lang.Integer>{
	
	private static Log log = LogFactory.getLog(TgoodDao.class);
	
	@Override
	public String getIbatisSqlMapNamespace() {
		return "Tgood";
	}
	
	public void saveOrUpdate(Tgood entity) {
		if(entity.getGoodId() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findPage(TgoodQuery query) {
		return pageQuery("Tgood.findPage",query);
	}
	
	public List findAll() {
		return findAll(null);
	}
	
	public List findAll(Map<String,String> orderMap) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("sortColumns", TgoodQuery.getSortColumns(orderMap));
		return getSqlMapClientTemplate().queryForList("Tgood.findAll",map);		
	}
	
	public List find(Map<String,Object> queryMap) {
		return getSqlMapClientTemplate().queryForList("Tgood.findPage",queryMap);		
	}
	
	
	
	public List findByCondition(TgoodQuery query) {
		return getSqlMapClientTemplate().queryForList("Tgood.findByCondition",query);		
	}

	@Override
	public boolean isUnique(Tgood entity, String ... uniquePropertyNames) {
		Assert.assertNotNull(uniquePropertyNames);
		HashMap<String,Object> params = new HashMap<String,Object>();
		for(String nuiquePropertyName : uniquePropertyNames){
			params.put(nuiquePropertyName,PropertyUtils.getProperty(entity, nuiquePropertyName));
		}
		if(entity.getGoodId() != null){
			params.put("goodId",entity.getGoodId());
		}
		long count = (Long)getSqlMapClientTemplate().queryForObject("Tgood.isUnique", params);
		return (count <= 0 ? true : false);
	}
	
	public void deleteByIds(Map<String, Object> params) {
		getSqlMapClientTemplate().delete("Tgood.deleteByIds",params);
	}
}
