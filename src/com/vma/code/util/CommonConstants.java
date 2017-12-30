package com.vma.code.util;


import java.util.HashMap;
import java.util.Map;


public class CommonConstants {
	
	private final static String fromSystemAccessKey = "fromSystemAccess";
	private final static String fromSystemAccess = "8a48b5514e8a7522014e9e1aec4d1893";
	
	

	
	///////////////////////////////////////////////////////////////////////////////////////////////
	//         请求响应实体KdyJsonResp中的msg信息,可统一在这管理,一个字符串可以在各个接口中使用               ///
	///////////////////////////////////////////////////////////////////////////////////////////////
	public static final String params_is_not_complete = "请求参数上传不全,请传入必传请求参数";
	public static final String params_format_is_not_correct = "请求参数格式不正确";
	public static final String is_not_file_upload = "没有上传任何图片";
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	//                            文件上传的存放路径                                                      ///
	///////////////////////////////////////////////////////////////////////////////////////////////
	//LOCAL_FILE_STORAGE_PATH为本地存放图片的路径,图片统一上传至tomcat的webapps目录下的upload/kdy下,可根据你们
	//tomcat的实际位置改变这个值
	private static final String LOCAL_FILE_STORAGE_PATH = "D:\\bs\\apache-tomcat-6.0.32\\apache-tomcat-6.0.32\\webapps\\upload\\baodan";
	private static final String SERVER_FILE_STORAGE_PATH = "D:\\apache-tomcat-6.0.32\\webapps\\upload\\baodan";
	
	private static final String LOCAL_EXCEL_ACCESS="D:\\tomcat-6.0.37\\webapps\\upload\\trusttee";
	private static final String SERVER_EXCEL_ACCESS=getApiAccess() + "/upload/baodan";
	
	public static final int THUMB_WIDTH = 200;
	public static final int THUMB_HEIGHT = 200;
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	//                            文件访问的基础路径                                                      ///
	///////////////////////////////////////////////////////////////////////////////////////////////
	private static final String LOCAL_API_ACCESS = "http://localhost:8080";
	private static final String SERVER_API_ACCESS = "http://www.qz12580.com:8080";
	private static final String FILE_ASK_PATH = getApiAccess() + "/upload/baodan/";
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	//                           上传文件类型限制                                                         ///
	///////////////////////////////////////////////////////////////////////////////////////////////
	public static final String picture_type_suffixs = ";jpg;png;gif;jpeg;";
	public static final String audio_type_suffixs = ";wav;wma;mp3;";
	
	
	 ///////////////////////////////// //////////////////////////////////////////////////////////////
    //                           环境   LOCAL代表本地,SERVER代表服务器   及获取随环境变化而改变的           ///
    ///////////////////////////////////////////////////////////////////////////////////////////////
	private static final String environment = "LOCAL";
	
	
	public static String getFileStoragePath(){
		if(environment.equals("LOCAL")) return LOCAL_FILE_STORAGE_PATH;
		else return SERVER_FILE_STORAGE_PATH;
	}
	
	public static String getFileAskPath() {
		return FILE_ASK_PATH;
	}
	
	public static String getApiAccess() {
		if(environment.equals("LOCAL")) return LOCAL_API_ACCESS;
		else return SERVER_API_ACCESS;
	}
	
	public static String getExcelAccess() {
		if(environment.equals("LOCAL")) return LOCAL_EXCEL_ACCESS;
		else return SERVER_EXCEL_ACCESS;
	}

	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	//         短信验证码相关信息常量                                                                        ///
	///////////////////////////////////////////////////////////////////////////////////////////////
	public static final String sms_uri = "sandboxapp.cloopen.com";
	public static final String sms_port = "8883";
//	public static final String sms_account = "8a48b5514b35422d014b36742f0c00b3";
//	public static final String sms_password = "729f9bd1d95e487085e42a18b8bc1ee9";
//	public static final String sms_appid = "8a48b5514d32a2a8014d559a65a319ff";
//	public static final String sms_template_id = "20283";
	
	public static final String sms_account = "8a48b5515350d1e2015373fc6ec3390c";
	public static final String sms_password = "e05d8da6d653488c9e6ad88531801fac";
	public static final String sms_appid = "aaf98f895376c19601537d0e764d08ed";
	public static final String sms_template_id = "73429";
	
	public static final int sms_checkcode_valid = 10;//单位为分钟
	public static final int sms_day_max_num = 10;//每天每个账号最多发几条
	
	
	
	private static final String alipay_callback_url = "notify_url.jsp";
	private static final String alipay_business_account = "15520478817@163.com";
	
	private static final String weixin_callback_url = "payNotifyUrl.jsp";
	private static final String weixin_business_account = "1266578801";
	

	public static Map<String,Object> getPayCoreData(String basePath,String payForm){
		Map<String,Object> map = new HashMap<String, Object>();
		if("支付宝".equals(payForm)) {
			map.put("callback", getApiAccess() + basePath + "/" + alipay_callback_url);
			map.put("business_account", alipay_business_account);
		}else if("微信支付".equals(payForm)) {
			map.put("callback", getApiAccess() + basePath + "/" + weixin_callback_url);
			map.put("business_account", weixin_business_account);
		}
		return map;
	}
	
	/////////////////积分配置的常量////////////////////////
	public static final String curche_dynamic="curche_dynamic";
	public static final String food_dynamic="food_dynamic";
	public static final String growth="growth";
	public static final String student_dynamic="student_dynamic";
	public static final String score="score";
	
	
	/////////////////佣金/费用的常量///////////////////////
	public static final String view_fee="view_fee";
	public static final String curche_fee="curche_fee";
	public static final String vip_fee="vip_fee";
	public static final String register_fee="register_fee";
	

	
	
	//应用icon
	public static final String SHARE_APP_ICON_TEACHER = getFileAskPath()+"share_app_icon_teacher.png";
	public static final String SHARE_APP_ICON_PARENTS = getFileAskPath()+"share_app_icon_parents.png";
	
	/////////////以下为测试使用//////////////////////////////
	public static void main(String[] args) {
	}

	public static String getWeixin_business_account() {
		return weixin_business_account;
	}

	public static String getFromSystemAccessKey() {
		return fromSystemAccessKey;
	}

	public static String getFromSystemAccess() {
		return fromSystemAccess;
	}

}
