package com.vma.code.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class ToolUtil {

	public static String getChangeMa(int i,int length){
		long time = System.currentTimeMillis();
		String istring = String.valueOf(i);
		while (istring.length() < length) {
			istring = "0" + istring ; 
		}
		return istring+time;
	}

    public static void main(String[] args) {
    	
    
    	System.out.println(beforeMonth(new Date()));
	}
    
	//获取yyyyMM
	public static String getNowDate_yyyyMM()
	{
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyyMM");
		String time=format.format(date);
		return time;
	}
	
	public static String getNowDateStr()
	{
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		return time;
	}
	
	public static Date getNowDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = null;
		try {
			time = df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
	}
	
	  /** 
     * 得到几天后的时间 
     *  
     * @param d 
     * @param day 
     * @return 
     */  
    public static Date getDateAfter(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    }
    
    //获取yyyy-mm-dd
  	public static String getNowDate_yyyyMMdd()
  	{
  		Date date=new Date();
  		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
  		String time=format.format(date);
  		return time;
  	}
    
  	public static Date stringParseDate(String strDate)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
  	
    public static boolean betweenDate(Date d, int day) { 
    	 //System.out.println(d);
       // System.out.println(getNowDate());
        //System.out.println(getDateAfter(getNowDate(),day));
    	if ( d.after( ToolUtil.getNowDate() ) && d.before( ToolUtil.getDateAfter(getNowDate(),day) ) ) 
    		return true;
    	
    	return false;
    }
    
    public static boolean isAfterTodate(Date d) { 
   	 //System.out.println(d);
      // System.out.println(getNowDate());
       //System.out.println(getDateAfter(getNowDate(),day));
   	if ( d.after( ToolUtil.getNowDate()  ) )
   		return true;
   	
   	return false;
   }
    
    
	//获取上个月
	public static String beforeMonth(Date date)
	{
		Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.roll(Calendar.MONTH, -1);
        
        DateFormat format=new SimpleDateFormat("yyyy-MM");
		String time=format.format(cal.getTime());
		return time;
	} 
	


}
