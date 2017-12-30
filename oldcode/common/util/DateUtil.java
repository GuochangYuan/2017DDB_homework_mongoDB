package common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

public class DateUtil {

    public static final String DEFAULT_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String SHORT_FORMAT_PATTERN = "yyyy-MM-dd";
    public static final String TIME_PATTERN = "HH:mm:ss";
    public static final String YY_MM_PATTERN = "yyyy-MM";

    private DateUtil() {
    }
    /**
     * 指定格式的日期字符串转换为日期型
     *
     * @param aMask   格式字符串
     * @param strDate 日期字符串
     * @return Date 转换后的日期
     * @throws ParseException
     */
    public static final Date stringConvertDate(String aMask, String strDate)
            throws ParseException {
        if (strDate == null || strDate.trim().length() < 1) return null;
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            //log.error("ParseException: " + pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return date;
    }

    /**
     * 返回日期的时间部分
     *
     * @param theTime the current time
     * @return the current date/time
     */
    public static String getTimeNow(Date theTime) {
        return formatDateToString(TIME_PATTERN, theTime);
    }


    /**
     * 返回00：00：00：000的日期
     *
     * @param date
     * @return date
     */
    public static Date getZoneHour(Date date) {
        if (date == null)
            throw new java.lang.NullPointerException();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 返回某日期的尾时23:59:59:999的日期(24小时制)
     *
     * @param date
     * @return date
     */
    public static Date getEndHour(final Date date) {
        if (date == null)
            throw new java.lang.NullPointerException();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 返回指定时间和日期的Date (24小时制)
     *
     * @param hour
     * @param min
     * @param sec
     * @param date
     * @return Date
     */
    public static Date getTime(int hour, int min, int sec, final Date date) {
        if (date == null)
            throw new java.lang.NullPointerException();

        if (!(hour <= 23 && hour >= 0 && min <= 59 && min >= 0 && sec <= 59 && sec >= 0))
            throw new java.lang.IllegalArgumentException();

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, sec);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 返回指定格式的日期字符串
     *
     * @param pattern 格式，如 yyyy-MM-dd HH:mm:ss
     * @param date
     * @return String
     */
    public static String formatDateToString(String pattern, Date date) {
        if (date == null || pattern == null) return "";
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 返回格式为yyyy-MM-dd HH:mm:ss的默认的日期字符串
     *
     * @param date
     * @return String
     */
    public static String formatDateToDefaultString(Date date) {
        //yyyy-MM-dd HH:mm:ss
        return formatDateToString(DEFAULT_FORMAT_PATTERN, date);
    }

    public static String formatDateToStringWithWeek(Date date) {

        Calendar ca = new GregorianCalendar();
        ca.setTime(date);
        return formatDateToString(SHORT_FORMAT_PATTERN, date) + " " + getWeek(ca.get(Calendar.DAY_OF_WEEK));
    }


    /**
     * 返回格式为yyyy-MM-dd的短格式日期字符串
     *
     * @param date
     * @return String
     */
    public static String formatDateToShortString(Date date) {
        return formatDateToString(SHORT_FORMAT_PATTERN, date);
    }

    /**
     * 格式化日期
     *
     * @param pattern 格式字符串
     * @param date    日期
     * @return date
     */
    public static Date formatDate(String pattern, Date date) {
        Date d = null;
        try {
            String dateStr = formatDateToString(pattern, date);
            d = stringConvertDate(pattern, dateStr);
        } catch (ParseException e) {
            return new Date(date.getTime());//返回原未格式化日期的拷贝
        }
        return d;
    }

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Object convertValue(Map ognlContext, Object value, Class toType) {
        Object result = null;
        if (toType == Date.class) {
            result = doConvertToDate(value);
        } else if (toType == String.class) {
            result = doConvertToString(value);
        }
        return result;
    }

    private Date doConvertToDate(Object value) {
        Date result = null;

        if (value instanceof String) {
            try {
                result = sdf.parse((String) value);
            } catch (ParseException e) {
                //throw new XworkException("Could not parse date", e);
            }
        } else if (value instanceof Object[]) {
            Object[] array = (Object[]) value;
            if ((array != null) && (array.length >= 1)) {
                value = array[0];
                result = doConvertToDate(value);
            }
        } else if (Date.class.isAssignableFrom(value.getClass())) {
            result = (Date) value;
        }
        return result;
    }

    private String doConvertToString(Object value) {
        String result = null;
        if (value instanceof Date) {
            result = sdf.format(value);
        }
        return result;
    }

    public static int getYear(Date date) {
        if (date == null) throw new java.lang.NullPointerException();
        Calendar ca = new GregorianCalendar();
        ca.setTime(date);
        return ca.get(Calendar.YEAR);
    }

    public static int getMonth(Date date) {
        if (date == null) throw new java.lang.NullPointerException();
        Calendar ca = new GregorianCalendar();
        ca.setTime(date);
        return ca.get(Calendar.MONTH);
    }

    public static int getDay(Date date) {
        if (date == null) throw new java.lang.NullPointerException();
        Calendar ca = new GregorianCalendar();
        ca.setTime(date);
        return ca.get(Calendar.DAY_OF_MONTH);
    }

    public static String getWeek(Date date) {
        if (date == null) throw new java.lang.NullPointerException();
        Calendar ca = new GregorianCalendar();
        ca.setTime(date);
        return getWeek(ca.get(Calendar.DAY_OF_WEEK));
    }

    public static int getHour(Date date) {
        if (date == null) throw new java.lang.NullPointerException();
        Calendar ca = new GregorianCalendar();
        ca.setTime(date);
        return ca.get(Calendar.HOUR);
    }

    public static int getMinute(Date date) {
        if (date == null) throw new java.lang.NullPointerException();
        Calendar ca = new GregorianCalendar();
        ca.setTime(date);
        return ca.get(Calendar.MINUTE);
    }

    public static int getSectond(Date date) {
        if (date == null) throw new java.lang.NullPointerException();
        Calendar ca = new GregorianCalendar();
        ca.setTime(date);
        return ca.get(Calendar.SECOND);
    }

    // enum=======================================================================
    public static enum Week {
        SUNDAY(Calendar.SUNDAY, "星期日"),
        MONDAY(Calendar.MONDAY, "星期一"),
        TUESDAY(Calendar.TUESDAY, "星期二"),
        WEDNESDAY(Calendar.WEDNESDAY, "星期三"),
        THURSDAY(Calendar.THURSDAY, "星期四"),
        FRIDAY(Calendar.FRIDAY, "星期五"),
        SATURDAY(Calendar.SATURDAY, "星期六");
        private Integer id;
        private String name;

        Week(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }
    }

    public static String getWeek(Integer id) {
        if (id == null)
            return "";
        for (Week week : Week.values()) {
            if (week.id.equals(id))
                return week.getName();
        }
        return "";
    }
    /**
     * @description:得到当前日期的前或后若干个月
     * @author: 孙道财 2008-10-14
     * @param pattern
     * @param addMonths
     * @return
     */
    public static String getNextMonth(String pattern,String addMonths) 
    {
         
    	  Calendar cal = Calendar.getInstance();
          SimpleDateFormat formatter = new SimpleDateFormat(pattern);
          Date date = new Date();
          cal.setTime(date);
          cal.add(Calendar.MONTH, Integer.parseInt(addMonths));
          String nextDay = formatter.format(cal.getTime());
          return nextDay;
        
        }
   /**
    * 到当前日期的前或后若干个月
    * @author: 孙道财 2008-11-15
    * @param addMonths
    * @return date
    */
    public static Date getNextMonth(String addMonths) 
    {
    	  Calendar cal = Calendar.getInstance();
          Date date = new Date();
          cal.setTime(date);
          cal.add(Calendar.MONTH, Integer.parseInt(addMonths));
          return cal.getTime();
        
        }
    
    public static Date getNextDay(int addDay){
    	 Calendar calendar=Calendar.getInstance();
         calendar.setTime(new Date());
         calendar.add(Calendar.DATE, addDay); 
         return calendar.getTime();
    }
    
    public static void main(String[] args) {
        System.out.println("----" + formatDateToStringWithWeek(new Date()));
        System.out.println("----" + formatDateToString("yyyy-MM-dd", getNextDay(-19)));
        System.out.println(DateUtil.formatDateToString("yyyyMMdd",new Date()));
        System.out.println(DateUtil.getNextMonth("-1"));
        try {
			System.out.println(DateUtil.stringConvertDate("yyyy-MM-dd","2008-10-02"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

}

