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

import com.vma.code.domain.Tfile;
import com.vma.code.query.TfileQuery;
import common.base.BaseIbatisDao;


@Repository
public class TfileDao extends BaseIbatisDao<Tfile,java.lang.Integer>{
	
	private static Log log = LogFactory.getLog(TfileDao.class);
	
	@Override
	public String getIbatisSqlMapNamespace() {
		return "Tfile";
	}
	
	public void saveOrUpdate(Tfile entity) {
		if(entity.getFileId() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findPage(TfileQuery query) {
		return pageQuery("Tfile.findPage",query);
	}
	
	public List findAll() {
		return findAll(null);
	}
	
	public List findAll(Map<String,String> orderMap) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("sortColumns", TfileQuery.getSortColumns(orderMap));
		return getSqlMapClientTemplate().queryForList("Tfile.findAll",map);		
	}
	
	public List find(Map<String,Object> queryMap) {
		return getSqlMapClientTemplate().queryForList("Tfile.findPage",queryMap);		
	}
	
	
	
	public List findByCondition(TfileQuery query) {
		return getSqlMapClientTemplate().queryForList("Tfile.findByCondition",query);		
	}

	@Override
	public boolean isUnique(Tfile entity, String ... uniquePropertyNames) {
		Assert.assertNotNull(uniquePropertyNames);
		HashMap<String,Object> params = new HashMap<String,Object>();
		for(String nuiquePropertyName : uniquePropertyNames){
			params.put(nuiquePropertyName,PropertyUtils.getProperty(entity, nuiquePropertyName));
		}
		if(entity.getFileId() != null){
			params.put("fileId",entity.getFileId());
		}
		long count = (Long)getSqlMapClientTemplate().queryForObject("Tfile.isUnique", params);
		return (count <= 0 ? true : false);
	}
	
	public void deleteByIds(Map<String, Object> params) {
		getSqlMapClientTemplate().delete("Tfile.deleteByIds",params);
	}
}
