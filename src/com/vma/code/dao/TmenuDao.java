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

import com.ffcs.newgeye.util.FFCSHashMap;
import com.vma.code.domain.Tmenu;
import com.vma.code.query.TmenuQuery;
import common.base.BaseIbatisDao;


@Repository
public class TmenuDao extends BaseIbatisDao<Tmenu,java.lang.Integer>{
	
	private static Log log = LogFactory.getLog(TmenuDao.class);
	
	@Override
	public String getIbatisSqlMapNamespace() {
		return "Tmenu";
	}
	
	public void saveOrUpdate(Tmenu entity) {
		if(entity.getMenuId() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findPage(TmenuQuery query) {
		return pageQuery("Tmenu.findPage",query);
	}
	
	public List findAll() {
		return findAll(null);
	}
	
	public List findAll(Map<String,String> orderMap) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("sortColumns", TmenuQuery.getSortColumns(orderMap));
		return getSqlMapClientTemplate().queryForList("Tmenu.findAll",map);		
	}
	
	public List find(Map<String,Object> queryMap) {
		return getSqlMapClientTemplate().queryForList("Tmenu.findPage",queryMap);		
	}
	
	
	
	public List findByCondition(TmenuQuery query) {
		return getSqlMapClientTemplate().queryForList("Tmenu.findByCondition",query);		
	}

	@Override
	public boolean isUnique(Tmenu entity, String ... uniquePropertyNames) {
		Assert.assertNotNull(uniquePropertyNames);
		FFCSHashMap params = new FFCSHashMap();
		for(String nuiquePropertyName : uniquePropertyNames){
			params.put(nuiquePropertyName,PropertyUtils.getProperty(entity, nuiquePropertyName));
		}
		if(entity.getMenuId() != null){
			params.put("menuId",entity.getMenuId());
		}
		long count = (Long)getSqlMapClientTemplate().queryForObject("Tmenu.isUnique", params);
		return (count <= 0 ? true : false);
	}
}
