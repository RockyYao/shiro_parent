package shiro.common.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: wangchang
 * @Date: 2018/11/6 16:08
 * @Description:
 */
public class DateUtil {


    public static String DATE_FORMAT_DATEONLY = "yyyy-MM-dd";
    public static String DATE_FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当天开始时间 yyyy-mm-dd 00:00:00
     *
     * @return
     */
    public static Date getNowStartDate() throws ParseException {
        String now = new SimpleDateFormat(DATE_FORMAT_DATEONLY).format(new Date());
        Date nowDate = new SimpleDateFormat(DATE_FORMAT_DATETIME).parse(now + " 00:00:00");
        return nowDate;
    }

    /**
     * 获取前一天开始时间  yyyy-mm-dd-1 00:00:00
     *
     * @return
     */
    public static Date getLastStartDate() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date lastDate = calendar.getTime();
        String now = new SimpleDateFormat(DATE_FORMAT_DATEONLY).format(lastDate);
        Date nowDate = new SimpleDateFormat(DATE_FORMAT_DATETIME).parse(now + " 00:00:00");

        return nowDate;
    }

    /*public static void main(String[] args) {
        try {
            new DateUtil().getNowStartDate();
            new DateUtil().getLastStartDate();

        } catch (ParseException e) {

        }

    }*/

    /**
     * 获取开始时间和结束时间的时间差
     * @param startTime
     * @param endTime
     * @return
     */
    public static long getTimeDifference(String startTime, String endTime) {
        long returnValue = 0;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date start = df.parse(startTime);
            Date end = df.parse(endTime);

            //获取时间差
            long l = end.getTime() - start.getTime();
            returnValue = l / (24 * 60 * 60 * 1000);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return returnValue;

    }


    /**
     * 开始时间和结束时间比较
     * 开始时间需要小于或等于结束时间
     * @param startTime
     * @param endTime
     * @return
     */
    public static boolean compareTime(String startTime, String endTime) {
        boolean returnValue = false;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date start = df.parse(startTime);
            Date end = df.parse(endTime);

            //获取时间差
            long l = end.getTime() - start.getTime();
            long day = l / (24 * 60 * 60 * 1000);

            if(day >= 0){
                returnValue = true;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    /**
     * 时间类型转换成字符串
     *
     * @param date
     * @return
     */
    public static String timeToString(Date date) {

        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return simple.format(date);

    }

    /**
     * 时间转字符串精确到天
     * @param date
     * @return
     */
    public static String getCurrentDate(Date date) {
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");

        return simple.format(date);
    }

    /**
     * 时间戳转换成Date类型
     *
     * @param time 时间戳
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String time) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date parse;
        try {

            parse = simpleDateFormat.parse(time);

        } catch (ParseException e) {

            throw new RuntimeException("时间转换异常", e);

        }

        return parse;
    }

    /**
     * 返回   年 月 日  23：59：59
     * @param time
     * @return
     */
    public static Date getDateEndDate(String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;

        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }
}
