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

import com.vma.code.domain.TbDepartment;
import com.vma.code.query.TbDepartmentQuery;
import common.base.BaseIbatisDao;


@Repository
public class TbDepartmentDao extends BaseIbatisDao<TbDepartment,java.lang.Integer>{
	
	private static Log log = LogFactory.getLog(TbDepartmentDao.class);
	
	@Override
	public String getIbatisSqlMapNamespace() {
		return "TbDepartment";
	}
	
	public void saveOrUpdate(TbDepartment entity) {
		if(entity.getDtId() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findPage(TbDepartmentQuery query) {
		return pageQuery("TbDepartment.findPage",query);
	}
	
	public List findAll() {
		return findAll(null);
	}
	
	public List findAll(Map<String,String> orderMap) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("sortColumns", TbDepartmentQuery.getSortColumns(orderMap));
		return getSqlMapClientTemplate().queryForList("TbDepartment.findAll",map);		
	}
	
	public List find(Map<String,Object> queryMap) {
		return getSqlMapClientTemplate().queryForList("TbDepartment.findPage",queryMap);		
	}
	
	
	
	public List findByCondition(TbDepartmentQuery query) {
		return getSqlMapClientTemplate().queryForList("TbDepartment.findByCondition",query);		
	}

	@Override
	public boolean isUnique(TbDepartment entity, String ... uniquePropertyNames) {
		Assert.assertNotNull(uniquePropertyNames);
		HashMap<String,Object> params = new HashMap<String,Object>();
		for(String nuiquePropertyName : uniquePropertyNames){
			params.put(nuiquePropertyName,PropertyUtils.getProperty(entity, nuiquePropertyName));
		}
		if(entity.getDtId() != null){
			params.put("dtId",entity.getDtId());
		}
		long count = (Long)getSqlMapClientTemplate().queryForObject("TbDepartment.isUnique", params);
		return (count <= 0 ? true : false);
	}
	
	public void deleteByIds(Map<String, Object> params) {
		getSqlMapClientTemplate().delete("TbDepartment.deleteByIds",params);
	}
}
