package com.cheng.dreams.library.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Cheng on 2017/2/20.
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃    神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * <p>
 * ━━━━━━感觉萌萌哒━━━━━━
 */
public class TimeUtils {
    private TimeUtils() {
    }

    public static final String TYPE_Y_M_D = "yyyy-MM-dd";
    public static final String TYPE_Y_M_D_2 = "yyyy/MM/dd";
    public static final String TYPE_Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";
    public static final String TYPE_Y_M_D_H_M = "yyyy-MM-dd HH:mm";

    public static boolean isSameDay(long time1, long time2) {
        String format1 = formatTime(time1, TYPE_Y_M_D);
        String format2 = formatTime(time2, TYPE_Y_M_D);
        return format1.equals(format2);
    }

    public static String formatTime(long time, String type) {
        SimpleDateFormat formater = new SimpleDateFormat(type);
        Date date = new Date(time * 1000);
        String format = formater.format(date);
        return format;
    }

    //字符串转时间戳
    public static long getTime(String timeString){
        long timeStamp =0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date d;
        try{
            d = sdf.parse(timeString);
            long l = d.getTime();
            timeStamp = l;
        } catch(Exception e){
            e.printStackTrace();
        }
        return timeStamp;
    }

    /**
     * 获取当前时间戳
     * @return
     */
    public static long getCurrentTime(){
       return new Date().getTime();
    }

    /**
     * 判断时间与当前时间大小
     * @param timeString
     * @return
     */
    public static boolean getSize(String timeString){
        return getTime(timeString)>=getCurrentTime();
    }

    /**
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd HH:mm");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }



}
