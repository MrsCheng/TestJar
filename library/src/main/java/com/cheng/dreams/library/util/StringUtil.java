package com.cheng.dreams.library.util;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;

import java.text.DecimalFormat;

/**
 * CreateTime: 2016-04-13上午11:03
 * Author: wjkjinke00@126.com
 * Description:
 */
public class StringUtil {

    static final String passwordRegex = "[A-Za-z0-9]{8,20}";


    public static String checkNull(String s) {
        return s == null ? "" : s;
    }

    public static boolean isEmpty(String str) {
        if (null == str || str.trim().equals("") || str.equals("null")) {
            return true;
        }
        return false;
    }

    public static String[] splite(String str) {
        if (isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        return split;
    }

    public static String getValue(String str) {
        if (null == str || str.trim().equals("") || str.equals("null")) {
            return "";
        }
        return str;
    }

    public static boolean isPasswordStrong(String password) {
        return password.matches(passwordRegex);
    }

 /*   public static String setPrice(String price) {
        String[] split = price.split("\\.");
        String splitOne = "";
        String splitTwo = "";
        if (split.length == 2) {
            if (split[0].length() > 6) {
                // 大于十万
                splitOne = split[0];
            } else if (split[0].length() <= 5) {
                splitOne = split[0];
            }

            if (split[1].length() > 2) {
                splitTwo = split[1];
            } else if (split[1].length() == 2) {
                splitTwo = split[1];
            } else if (split[1].length() == 1) {
                splitTwo = split[1] + "0";
            }

        } else if (split.length == 1) {

            if (split[0].length() > 5) {
                // 大于十万
                splitOne = split[0];
            } else if (split[0].length() <= 5) {
                splitOne = split[0];
            }
            splitTwo = "00";
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(splitOne);
        stringBuffer.append(".");
        stringBuffer.append(splitTwo);
        stringBuffer.toString();
        try {
            return new DecimalFormat("#.00").format(Double.parseDouble((stringBuffer.toString())));
        } catch (Exception e) {
            return "价格有误";
        }

    }*/


    /**
     * 精确为两位小数
     *
     * @param money
     * @return
     */
    public static String setPrice(String money) {
        Double aDouble = Double.valueOf(money);
        String format = new DecimalFormat("#0.00").format(aDouble);
        return format;
    }

    public static <T> String formatMoneyType(T money) {

        String format = null;
        try {
            Double aDouble = Double.valueOf(String.valueOf(money));
            format = new DecimalFormat("#0.00").format(aDouble);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "0.00";
        }
        return format;
    }


    /**
     * textview设置其中某几个字体的颜色
     *
     * @param msg   内容
     * @param color 颜色
     * @param start 开的位置
     * @param end   结束的位置
     * @return
     */
    public static SpannableString setSpanStrColor(CharSequence msg, int color, int start, int end) {

        SpannableString spannableString = new SpannableString(msg);
        spannableString.setSpan(new ForegroundColorSpan(color), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**
     * textview设置其中某几个字体的大小
     *
     * @param msg   内容
     * @param size  大小
     * @param start 开始的位置
     * @param end   结束的位置
     * @return
     */
    public static SpannableString setSpanStrSize(CharSequence msg, int size, int start, int end) {
        SpannableString spannableString = new SpannableString(msg);
        spannableString.setSpan(new AbsoluteSizeSpan(size), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**
     * 字段去除空格
     *
     * @return
     */
    public static String SetString(String str) {
        str = str.trim();
        str = str.replaceAll(" ", "");
        str = str.replaceAll(" +", "");
        str = str.replaceAll(" *", "");//正则表达式  *为0到无穷
        str = str.replaceAll("\\s*", "");
        return str;
    }


}
