package com.vma.code.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vma.code.dao.HyRoleDao;
import com.vma.code.dao.HyUserDao;
import com.vma.code.dao.TmenuDao;
import com.vma.code.domain.HyRole;
import com.vma.code.domain.HyUser;
import com.vma.code.domain.Tmenu;
import com.vma.code.query.HyUserQuery;
import com.vma.code.query.TmenuQuery;
import com.vma.code.util.SystemContants;


@Controller
@RequestMapping(value="/security")
public class LoginController {

	@Autowired
	private TmenuDao tmenuDao;
	
	
	@Autowired
	private HyUserDao hyUserDao;
	
	@Autowired
	private HyRoleDao hyRoleDao;

	
	@RequestMapping(value="/access")
	public String access(){
		return "/login";
	}
	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request,HttpSession session,String username,String password,String checkcode){
		String msg = null;
		String session_check_code = (String) session.getAttribute(SystemContants.CHECK_CODE_KEY);
		if(session_check_code==null || !session_check_code.equals(checkcode)){
			msg = "验证码错误";
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("msg", msg);
			request.setAttribute("errorType", SystemContants.LOGIN_CHECK_ERROR);
			return "/login";
		}
		HyUserQuery userQuery = new HyUserQuery();
		userQuery.setUserNo(username);
		userQuery.setField1(password);
		List<HyUser> list = hyUserDao.findByCondition(userQuery);
		
		if(list == null || list.size()==0){
			msg = "用户名或密码错误";
			request.setAttribute("msg", msg);
			request.setAttribute("errorType", SystemContants.LOGIN_USER_ERROR);
			return "/login";
		}
		TmenuQuery query = new TmenuQuery();
		HyUser user = list.get(0);
		if("Y".equals(user.getIsAdmin())){
			query.setParentId(0);
			List<Tmenu> menuList = tmenuDao.findByCondition(query);
			for (Tmenu tmenu : menuList) {
				query.setParentId(tmenu.getMenuId());
				tmenu.setSonList(tmenuDao.findByCondition(query));
			}
			request.setAttribute("menuList", menuList);
		}else{
			//获取用户权限列表
			List<Tmenu> menuList = new ArrayList<Tmenu>();
			if(user.getRoleId()==null) {
				msg = "用户无角色,请联系管理员";
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				request.setAttribute("msg", msg);
				request.setAttribute("errorType", SystemContants.LOGIN_CHECK_ERROR);
				return "/login";
			}
			HyRole role = (HyRole) hyRoleDao.getById(user.getRoleId());
			if(role == null) {
				msg = "用户无角色,请联系管理员";
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				request.setAttribute("msg", msg);
				request.setAttribute("errorType", SystemContants.LOGIN_CHECK_ERROR);
				return "/login";
			}
			String tempMenus = role.getMenuIds();
			if(tempMenus != null && !"".equals(tempMenus)){
				String [] menuIds = tempMenus.split(",");
				for (String id : menuIds) {
					if("".equals(id)) continue;
					Object obj = tmenuDao.getById(Integer.parseInt(id));
					if(obj != null ){
						Tmenu menu = (Tmenu)obj;
						query.setParentId(menu.getMenuId());
						menu.setSonList(tmenuDao.findByCondition(query));
						menuList.add(menu);
					}
				}
				request.setAttribute("menuList", menuList);
			}else{
				msg = "该用户没有登录权限";
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				request.setAttribute("msg", msg);
				request.setAttribute("errorType", SystemContants.LOGIN_CHECK_ERROR);
				return "/login";
			}
		}
		session.setAttribute("isAdmin", user.getIsAdmin());
		session.setAttribute(SystemContants.LOGIN_USER_KEY, user);
		return "/admin";
	}

	
	@RequestMapping(value="/index")
	public String index(HttpSession session,HttpServletRequest request){
		
		String msg = "登录超时";
		request.setAttribute("msg", msg);
		request.setAttribute("errorType", SystemContants.LOGIN_TIMEOUT_ERROR);
		return "/login";
	}
	
	@RequestMapping(value="/resetCheckCode")
	public String resetCheckCode(){
		
		return "/check_code";
	}
	
	@RequestMapping(value="/out")
	public String out(HttpSession session){
		session.invalidate();
		return "/login";
	}
}
