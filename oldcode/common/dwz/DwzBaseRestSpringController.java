package common.dwz;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import common.base.BaseRestSpringController;
import common.util.DateSerializerUtils;

public class DwzBaseRestSpringController<Entity, PK>  extends BaseRestSpringController<Entity, PK> {
	
	private static Log log = LogFactory.getLog(DwzBaseRestSpringController.class);
	
//	private SysDictionaryManager sysDictionaryManager;

	protected String  NAVTABID = "";
	
	protected String  CALLBACKTYPE = "";
	
	protected String FORWARDURL = "";
	
	protected String STATUSCODE = DwzContext.STATUSCODE_SUCCESS;

	protected String MESSAGE = "操作成功";
	
	protected String AJAXDONE = "/ajaxDone";
	
	protected String AJAXDONE(ModelMap model) {
		return AJAXDONE(model,STATUSCODE,MESSAGE,NAVTABID,FORWARDURL,CALLBACKTYPE);
	}
	
	protected String AJAXDONE(ModelMap model,String callbackType) {
		return AJAXDONE(model,STATUSCODE,MESSAGE,NAVTABID,FORWARDURL,callbackType);
	}
	
	protected String AJAXDONE(ModelMap model,String callbackType,String message) {
		return AJAXDONE(model,STATUSCODE,message,NAVTABID,FORWARDURL,callbackType);
	}
	
	protected String AJAXDONE(ModelMap model,String callbackType,String message,String statusCode) {
		return AJAXDONE(model,statusCode,message,NAVTABID,FORWARDURL,callbackType);
	}
	
	protected String AJAXERRORDONE(ModelMap model,String callbackType,String message) {
		return AJAXDONE(model,DwzContext.STATUSCODE_ERROR,message,NAVTABID,FORWARDURL,callbackType);
	}
	
	
	protected String AJAXTIMEOUTDONE(ModelMap model) {
		model.put(DwzContext.NAVTABID, "");
		model.put(DwzContext.FORWARDURL, "");
		model.put(DwzContext.CALLBACKTYPE, "");
		model.put(DwzContext.MESSAGE, "登录超时");
		model.put(DwzContext.STATUSCODE, DwzContext.STATUSCODE_TIMEOUT);
		return AJAXDONE;
	}
	
	protected String AJAXDONE(ModelMap model,String statusCode,String message,String navtabId,String forwardUrl,String callbackType) {
		model.put(DwzContext.NAVTABID, navtabId);
		model.put(DwzContext.FORWARDURL, forwardUrl);
		model.put(DwzContext.CALLBACKTYPE, callbackType);
		model.put(DwzContext.MESSAGE, message);
		model.put(DwzContext.STATUSCODE, statusCode);
		return AJAXDONE;
	}
	
	
	public static void outJson(HttpServletResponse response,Object obj) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.registerTypeAdapter(java.util.Date.class, 
	              new DateSerializerUtils()).setDateFormat(DateFormat.LONG).create();
		outJsonString(response,gson.toJson(obj));
		log.info("outJson:"+gson.toJson(obj));
	}
	
	public static void outJsonString(HttpServletResponse response,String str) {
		response.setContentType("application/json;charset=UTF-8");
		outString(response,str);
	}
	
//	public void saveSessionUser(HttpServletRequest request,SysUsers sysUsers){
//		request.getSession().setAttribute(RoleContent.USER_SCOPE, sysUsers);
//	}
//	
//	public SysUsers getSessionUser(HttpServletRequest request){
//		return (SysUsers)request.getSession().getAttribute(RoleContent.USER_SCOPE);
//	}
//	
//	public String getSessionUserAreas(HttpServletRequest request){
//		return (String)request.getSession().getAttribute(RoleContent.USER_AREAS);
//	}
	
	public static void outString(HttpServletResponse response,String str) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(str);
//			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(out != null){
//				out.close();
			}
		}
	}
	
//	protected List<SysDictionary>  getDictionaryListByTypeCode(String typeCode){
//		return sysDictionaryManager.findByTypeCode(typeCode);
//	}
//	
//	public Map<Integer,Object> getDictionaryMapByTypeCode(String typeCode){
//		List<SysDictionary> dataItems = sysDictionaryManager.findByTypeCode(typeCode);
//		Map<Integer,Object> dataItemMap = new HashMap<Integer,Object>();
//		for(SysDictionary dataItem : dataItems){
//			dataItemMap.put(Integer.valueOf(dataItem.getCode()),dataItem.getName());
//		}
//		return dataItemMap;
//	}
//
//
//	/**
//	 * @param sysDictionaryManager the sysDictionaryManager to set
//	 */
//	public void setSysDictionaryManager(SysDictionaryManager sysDictionaryManager) {
//		this.sysDictionaryManager = sysDictionaryManager;
//	}
	
	protected String parseValidErrros(BindingResult errors){
		List<FieldError> oErrors = errors.getFieldErrors();
		StringBuilder sb = new StringBuilder("");
		sb.append("提交对象"+errors.getObjectName()).append("信息有误:");
		for(FieldError oError : oErrors){
			if(sb.length() > 0)sb.append(" ");
			sb.append("[属性:"+oError.getField()).append(" ")
			.append("拒绝:").append(oError.getRejectedValue()).append(" ")
			.append("提示:").append(oError.getDefaultMessage())
			.append("]");
		}
		return sb.toString();
	}
}
