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

import com.vma.code.domain.TbWork;
import com.vma.code.query.TbWorkQuery;
import common.base.BaseIbatisDao;


@Repository
public class TbWorkDao extends BaseIbatisDao<TbWork,java.lang.Integer>{
	
	private static Log log = LogFactory.getLog(TbWorkDao.class);
	
	@Override
	public String getIbatisSqlMapNamespace() {
		return "TbWork";
	}
	
	public void saveOrUpdate(TbWork entity) {
		if(entity.getWorkId() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findPage(TbWorkQuery query) {
		return pageQuery("TbWork.findPage",query);
	}
	
	public List findAll() {
		return findAll(null);
	}
	
	public List findAll(Map<String,String> orderMap) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("sortColumns", TbWorkQuery.getSortColumns(orderMap));
		return getSqlMapClientTemplate().queryForList("TbWork.findAll",map);		
	}
	
	public List find(Map<String,Object> queryMap) {
		return getSqlMapClientTemplate().queryForList("TbWork.findPage",queryMap);		
	}
	
	
	
	public List findByCondition(TbWorkQuery query) {
		return getSqlMapClientTemplate().queryForList("TbWork.findByCondition",query);		
	}

	@Override
	public boolean isUnique(TbWork entity, String ... uniquePropertyNames) {
		Assert.assertNotNull(uniquePropertyNames);
		HashMap<String,Object> params = new HashMap<String,Object>();
		for(String nuiquePropertyName : uniquePropertyNames){
			params.put(nuiquePropertyName,PropertyUtils.getProperty(entity, nuiquePropertyName));
		}
		if(entity.getWorkId() != null){
			params.put("workId",entity.getWorkId());
		}
		long count = (Long)getSqlMapClientTemplate().queryForObject("TbWork.isUnique", params);
		return (count <= 0 ? true : false);
	}
	
	public void deleteByIds(Map<String, Object> params) {
		getSqlMapClientTemplate().delete("TbWork.deleteByIds",params);
	}
}
