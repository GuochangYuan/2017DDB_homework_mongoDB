/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */


package com.vma.code.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.org.rapid_framework.page.Page;

import com.ffcs.newgeye.util.FFCSLinkMap;
import com.vma.code.dao.HyRoleDao;
import com.vma.code.dao.HyUserDao;
import com.vma.code.dao.TmenuDao;
import com.vma.code.domain.HyRole;
import com.vma.code.domain.HyUser;
import com.vma.code.domain.Tmenu;
import com.vma.code.query.HyRoleQuery;
import com.vma.code.query.HyUserQuery;
import com.vma.code.query.TmenuQuery;
import common.dwz.DwzBaseRestSpringController;

@Controller
@RequestMapping("/hysw/hyrole")
public class HyRoleController extends DwzBaseRestSpringController<HyRole,java.lang.Integer>{
	private static Log log = LogFactory.getLog(HyRoleController.class);
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private HyRoleDao hyRoleDao;
	
	@Autowired
	private TmenuDao tmenuDao;
	
	@Autowired
	private HyUserDao userDao;
	
	private final String LIST_ACTION = "redirect:/hyrole";
	
	
	
	/** 列表 */
	@RequestMapping
	public String index(ModelMap model,HyRoleQuery query,HttpServletRequest request,HttpServletResponse response) {
		FFCSLinkMap orderColumnsMap = new FFCSLinkMap();
		orderColumnsMap.put("roleId","DESC");
		Page page = this.hyRoleDao.findPage(query);
		
		model.addAllAttributes(toModelMap(page, query));
		return "/hyrole/index";
	}
	
	/** 显示 *//*
	@RequestMapping(value="/{id}")
	public String show(ModelMap model,@PathVariable java.lang.Integer id) throws Exception {
		HyRole hyRole = (HyRole)hyRoleDao.getById(id);
		model.addAttribute("hyRole",hyRole);
		return "/hyrole/show";
	}*/

	/** 进入新增 */
	@RequestMapping(value="/new")
	public String _new(ModelMap model,HyRole hyRole,HttpServletRequest request,HttpServletResponse response) throws Exception {
		model.addAttribute("hyRole",hyRole);
		
		TmenuQuery tmenuQuery = new TmenuQuery();
		tmenuQuery.setParentId(0);
		List<Tmenu> menuList = tmenuDao.findByCondition(tmenuQuery);
		request.setAttribute("menuList", menuList);
		return "/hyrole/edit";
	}
	
	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  *//*
	@RequestMapping(method=RequestMethod.POST)
	public String create(ModelMap model,@Valid HyRole hyRole,BindingResult errors,HttpServletRequest request,HttpServletResponse response) throws Exception {
		if(errors.hasErrors()) {
			return  "/hyrole/new";
		}
		
		hyRoleDao.save(hyRole);
		Flash.current().success(CREATED_SUCCESS); //存放在Flash中的数据,在下一次http请求中仍然可以读取数据,error()用于显示错误消息
		return LIST_ACTION;
	}*/
	
	/** 编辑 */
	@RequestMapping(value="/edit")
	public String edit(ModelMap model,java.lang.Integer id) throws Exception {
		HyRole hyRole = (HyRole)hyRoleDao.getById(id);
		model.addAttribute("hyRole",hyRole);
		
		String menuIds = hyRole.getMenuIds();
		TmenuQuery tmenuQuery = new TmenuQuery();
		tmenuQuery.setParentId(0);
		List<Tmenu> menuList = tmenuDao.findByCondition(tmenuQuery);
		for (Tmenu tmenu : menuList) {
			if(menuIds != null && menuIds.contains(","+tmenu.getMenuId()+",")){
				tmenu.setField1("Y");
			}else{
				tmenu.setField1("N");
			}
		}
		if(menuIds != null && !"".equals(menuIds)){
			int temp = menuIds.split(",").length;
			if((temp-1) == menuList.size()) {
				model.addAttribute("all", "Y");
			}else{
				model.addAttribute("all", "N");
			}
		}
		model.addAttribute("menuList", menuList);
		return "/hyrole/edit";
	}
	
	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping(value="/update")
	public String update(ModelMap model,@Valid HyRole hyRole,HttpServletRequest request,HttpServletResponse response) throws Exception {
		if(hyRole.getRoleId() != null){//修改
		}else{//新增
			hyRole.setCreateTime(new Date());
		}
		String [] menuIds = request.getParameterValues("menuIds");
		
		String menusId = StringUtils.join(menuIds, ",");
		hyRole.setMenuIds(","+menusId+",");
		
		
		hyRoleDao.saveOrUpdate(hyRole);
		return "/saveSucc";
	}
	
	/** 删除 *//*
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String delete(ModelMap model,@PathVariable java.lang.Integer id) {
		hyRoleDao.removeById(id);
		Flash.current().success(DELETE_SUCCESS);
		return LIST_ACTION;
	}*/

	/** 批量删除 
	@RequestMapping(method=RequestMethod.DELETE)
	public String batchDelete(ModelMap model,@RequestParam("items") java.lang.Integer[] items) {
		for(int i = 0; i < items.length; i++) {
			hyRoleManager.removeById(items[i]);
		}
		Flash.current().success(DELETE_SUCCESS);
		return AJAXDONE(model);
	}
	*/
	/** 批量删除 */
	@RequestMapping(value="/batchDelete",method=RequestMethod.POST)
	@ResponseBody
	public Object batchDelete(ModelMap model,String ids) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("flag", true);
		map.put("msg", "删除成功");//flag与msg的组合可以处理某些条件下的无法删除的情况提示,在common.js的相应js会做处理
		String temp = ids;
		if(ids.endsWith(",")) {
			temp = ids.substring(0, ids.lastIndexOf(","));
		}
		String [] idArray = temp.split(",");
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("items", idArray);
		hyRoleDao.deleteByIds(params);
		
		return map;
	}
	
	/** 单个删除 */
	@RequestMapping(value="/deleteRow",method=RequestMethod.POST)
	@ResponseBody
	public Object deleteRow(ModelMap model,String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		HyUserQuery query = new HyUserQuery();
		query.setRoleId(Integer.parseInt(id));
		List<HyUser> list = userDao.findByCondition(query);
		if(list != null && list.size() > 0) {
			map.put("flag", false);
			map.put("msg", "当前角色有用户使用，不可删除");
		}else{
			hyRoleDao.deleteById(Integer.parseInt(id));
			map.put("flag", true);
			map.put("msg", "删除成功");//flag与msg的组合可以处理某些条件下的无法删除的情况提示,在common.js的相应js会做处理
		}
		return map;
	}

}

