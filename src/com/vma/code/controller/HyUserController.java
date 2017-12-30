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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.org.rapid_framework.page.Page;

import com.ffcs.newgeye.util.FFCSLinkMap;
import com.vma.code.dao.HyRoleDao;
import com.vma.code.dao.HyUserDao;
import com.vma.code.dao.TbDepartmentDao;
import com.vma.code.dao.TbWorkDao;
import com.vma.code.domain.HyRole;
import com.vma.code.domain.HyUser;
import com.vma.code.domain.TbDepartment;
import com.vma.code.domain.TbWork;
import com.vma.code.query.HyUserQuery;
import com.vma.code.util.SystemContants;
import common.dwz.DwzBaseRestSpringController;

@Controller
@RequestMapping("/hyuser")
public class HyUserController extends DwzBaseRestSpringController<HyUser,java.lang.Integer>{
	private static Log log = LogFactory.getLog(HyUserController.class);
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private HyUserDao hyUserDao;
	
	@Autowired
	private TbWorkDao tbWorkDao;
	
	@Autowired
	private HyRoleDao hyRoleDao;
	
	@Autowired
	private TbDepartmentDao tbDepartmentDao;
	
	private final String LIST_ACTION = "redirect:/hyuser";
	
	
	
	/** 列表 */
	@RequestMapping
	public String index(ModelMap model,HyUserQuery query,HttpServletRequest request,HttpServletResponse response) {
		FFCSLinkMap orderColumnsMap = new FFCSLinkMap();
		orderColumnsMap.put("userId","DESC");
		Page page = this.hyUserDao.findPage(query);
		
		model.addAllAttributes(toModelMap(page, query));
		return "/hyuser/index";
	}
	
	/** 显示 *//*
	@RequestMapping(value="/{id}")
	public String show(ModelMap model,@PathVariable java.lang.Integer id) throws Exception {
		HyUser hyUser = (HyUser)hyUserDao.getById(id);
		model.addAttribute("hyUser",hyUser);
		return "/hyuser/show";
	}*/

	/** 进入新增 */
	@RequestMapping(value="/new")
	public String _new(ModelMap model,HyUser hyUser,HttpServletRequest request,HttpServletResponse response) throws Exception {
		model.addAttribute("hyUser",hyUser);
		
		List<TbWork> workList=tbWorkDao.findAll();
		request.setAttribute("workList", workList);
		
		List<TbDepartment> dtList= tbDepartmentDao.findAll();
		request.setAttribute("dtList", dtList);
		
		List<HyRole> roleList=hyRoleDao.findAll();
	    request.setAttribute("roleList", roleList);
		return "/hyuser/edit";
	}
	
	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  *//*
	@RequestMapping(method=RequestMethod.POST)
	public String create(ModelMap model,@Valid HyUser hyUser,BindingResult errors,HttpServletRequest request,HttpServletResponse response) throws Exception {
		if(errors.hasErrors()) {
			return  "/hyuser/new";
		}
		
		hyUserDao.save(hyUser);
		Flash.current().success(CREATED_SUCCESS); //存放在Flash中的数据,在下一次http请求中仍然可以读取数据,error()用于显示错误消息
		return LIST_ACTION;
	}*/
	
	/** 编辑 */
	@RequestMapping(value="/{id}/edit")
	public String edit(ModelMap model,@PathVariable java.lang.Integer id,HttpServletRequest request) throws Exception {
		HyUser hyUser = (HyUser)hyUserDao.getById(id);
		model.addAttribute("hyUser",hyUser);
		
		List<TbWork> workList=tbWorkDao.findAll();
		request.setAttribute("workList", workList);
		
		List<TbDepartment> dtList= tbDepartmentDao.findAll();
		request.setAttribute("dtList", dtList);
		
		List<HyRole> roleList=hyRoleDao.findAll();
	    request.setAttribute("roleList", roleList);
		
		return "/hyuser/edit";
	}
	
	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping(value="/update")
	public String update(ModelMap model,@Valid HyUser hyUser,HttpServletRequest request,HttpServletResponse response) throws Exception {
		if(hyUser.getUserId() != null){//修改
			super.NAVTABID = this.NAVTABID + "1";
		}else{//新增
			hyUser.setCreateTime(new Date());
			//hyUser.setRoleId(2);
			hyUser.setField1("123456");
			hyUser.setUserStatus("Y");
			
			//获取工号
			HyUser user = hyUserDao.findLastOne();
			long newNo= Long.parseLong(user.getUserNo())+1;
		    String strNo = String.format("%05d", newNo);  
			hyUser.setUserNo(strNo);
			
		}
		hyUserDao.saveOrUpdate(hyUser);
		return "/saveSucc";
	}
	
	/** 删除 *//*
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String delete(ModelMap model,@PathVariable java.lang.Integer id) {
		hyUserDao.removeById(id);
		Flash.current().success(DELETE_SUCCESS);
		return LIST_ACTION;
	}*/

	/** 批量删除 
	@RequestMapping(method=RequestMethod.DELETE)
	public String batchDelete(ModelMap model,@RequestParam("items") java.lang.Integer[] items) {
		for(int i = 0; i < items.length; i++) {
			hyUserManager.removeById(items[i]);
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
		hyUserDao.deleteByIds(params);
		
		return map;
	}
	
	/** 单个删除 */
	@RequestMapping(value="/deleteRow",method=RequestMethod.POST)
	@ResponseBody
	public Object deleteRow(ModelMap model,String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("flag", true);
		map.put("msg", "删除成功");//flag与msg的组合可以处理某些条件下的无法删除的情况提示,在common.js的相应js会做处理
		
		hyUserDao.deleteById(Integer.parseInt(id));
		return map;
	}

	
	//修改密码
	@RequestMapping(value="/updatePwd")
	@ResponseBody
	public Object updatePwd(ModelMap model,@Valid HyUser hyUser,BindingResult errors,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		String newPwd1=request.getParameter("newPwd1");
		HyUser user = (HyUser)request.getSession().getAttribute(SystemContants.LOGIN_USER_KEY);
		user.setField1(newPwd1);
		HashMap<String, Object> resultMap=new HashMap<String, Object>();
		try {
			hyUserDao.saveOrUpdate(user);
			
			resultMap.put("message", "修改成功");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("message", "网络异常，修改失败");
		}
		
		return resultMap;
	}
}

