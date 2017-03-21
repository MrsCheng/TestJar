package com.cheng.dreams.library.util;

import android.content.Context;
import android.util.DisplayMetrics;

import java.lang.reflect.Field;

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
public class DeviceUtils {
    private Context mContext;
    private DisplayMetrics mDm;

    public DeviceUtils(Context context) {
        if(context != null) {
            mContext = context;
            mDm = context.getResources().getDisplayMetrics();
        }
    }

    /**
     * 获取屏幕的宽度
     * @return
     */
    public int getWidth() {
        return mDm != null ? mDm.widthPixels : 0;
    }

    /**
     * 获取屏幕的高度
     * @return
     */
    public int getHeight() {
        return mDm != null ? mDm.heightPixels : 0;
    }

    /**
     * 获取屏幕的密度
     * @return
     */
    public float getDensity() {
        return mDm != null ? mDm.density : 0;
    }

    /**
     * 获取屏幕的dpi
     * @return
     */
    public float getDensityDpi() {
        return mDm != null ? mDm.densityDpi : 0;
    }

    /**
     * 获取状态栏的高度，系统默认高度为25dp
     * @return
     */
    public int getStatusBarHeight(){
        if(mContext == null) return 0;
        int height = (int) ( 25 * getDensity());

        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            Object obj = cls.newInstance();
            Field field = cls.getField("status_bar_height");
            height = mContext.getResources().getDimensionPixelSize(Integer.parseInt(field.get(obj).toString()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return height;
    }
}
