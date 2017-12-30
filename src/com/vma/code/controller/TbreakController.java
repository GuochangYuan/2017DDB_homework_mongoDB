/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2017
 */


package com.vma.code.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import com.vma.code.dao.TbreakDao;
import com.vma.code.domain.HyUser;
import com.vma.code.domain.Tbreak;
import com.vma.code.query.TbreakQuery;
import com.vma.code.util.SystemContants;

import common.dwz.DwzBaseRestSpringController;

@Controller
@RequestMapping("/tbreak")
public class TbreakController extends DwzBaseRestSpringController<Tbreak,java.lang.Integer>{
	private static Log log = LogFactory.getLog(TbreakController.class);
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private TbreakDao tbreakDao;
	
	private final String LIST_ACTION = "redirect:/tbreak";
	
	
	
	/** 列表 */
	@RequestMapping
	public String index(ModelMap model,TbreakQuery query,HttpServletRequest request,HttpServletResponse response) {
		FFCSLinkMap orderColumnsMap = new FFCSLinkMap();
		orderColumnsMap.put("breakId","DESC");
		Page page = this.tbreakDao.findPage(query);
		
		model.addAllAttributes(toModelMap(page, query));
		return "/tbreak/index";
	}
	
	/** 显示 *//*
	@RequestMapping(value="/{id}")
	public String show(ModelMap model,@PathVariable java.lang.Integer id) throws Exception {
		Tbreak tbreak = (Tbreak)tbreakDao.getById(id);
		model.addAttribute("tbreak",tbreak);
		return "/tbreak/show";
	}*/

	/** 进入新增 */
	@RequestMapping(value="/new")
	public String _new(ModelMap model,Tbreak tbreak,HttpServletRequest request,HttpServletResponse response) throws Exception {
		model.addAttribute("tbreak",tbreak);
		return "/tbreak/edit";
	}
	
	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  *//*
	@RequestMapping(method=RequestMethod.POST)
	public String create(ModelMap model,@Valid Tbreak tbreak,BindingResult errors,HttpServletRequest request,HttpServletResponse response) throws Exception {
		if(errors.hasErrors()) {
			return  "/tbreak/new";
		}
		
		tbreakDao.save(tbreak);
		Flash.current().success(CREATED_SUCCESS); //存放在Flash中的数据,在下一次http请求中仍然可以读取数据,error()用于显示错误消息
		return LIST_ACTION;
	}*/
	
	/** 编辑 */
	@RequestMapping(value="/{id}/edit")
	public String edit(ModelMap model,@PathVariable java.lang.Integer id) throws Exception {
		Tbreak tbreak = (Tbreak)tbreakDao.getById(id);
		model.addAttribute("tbreak",tbreak);
		return "/tbreak/edit";
	}
	
	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping(value="/update")
	public String update(ModelMap model,@Valid Tbreak tbreak,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception {
		if(tbreak.getBreakId() != null){//修改
			super.NAVTABID = this.NAVTABID + "1";
		}else{//新增
			HyUser user=(HyUser)session.getAttribute(SystemContants.LOGIN_USER_KEY);
			tbreak.setUserId(user.getUserId());
		}
		tbreakDao.saveOrUpdate(tbreak);
		return "/saveSucc";
	}
	
	/** 删除 *//*
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String delete(ModelMap model,@PathVariable java.lang.Integer id) {
		tbreakDao.removeById(id);
		Flash.current().success(DELETE_SUCCESS);
		return LIST_ACTION;
	}*/

	/** 批量删除 
	@RequestMapping(method=RequestMethod.DELETE)
	public String batchDelete(ModelMap model,@RequestParam("items") java.lang.Integer[] items) {
		for(int i = 0; i < items.length; i++) {
			tbreakManager.removeById(items[i]);
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
		tbreakDao.deleteByIds(params);
		
		return map;
	}
	
	/** 单个删除 */
	@RequestMapping(value="/deleteRow",method=RequestMethod.POST)
	@ResponseBody
	public Object deleteRow(ModelMap model,String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("flag", true);
		map.put("msg", "删除成功");//flag与msg的组合可以处理某些条件下的无法删除的情况提示,在common.js的相应js会做处理
		
		tbreakDao.deleteById(Integer.parseInt(id));
		return map;
	}

}

