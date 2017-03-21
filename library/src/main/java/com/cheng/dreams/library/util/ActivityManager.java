package com.cheng.dreams.library.util;

import android.app.Activity;

import java.util.List;

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

public class ActivityManager {

    private List<Activity> lists;
    private ActivityManager(){

    }

    private static volatile ActivityManager instance = null;

    public static ActivityManager getIntance() {
        if (instance == null) {
            synchronized (ActivityManager.class) {
                if (instance == null) {
                    instance = new ActivityManager();
                }
            }
        }

        return instance;
    }

    public void addActivity(Activity activity){
        lists.add(activity);
    }

    public void removeActivity(Activity activity){
        lists.remove(activity);
    }

    public void kissActivity(){
        int i=lists.size();
        for (int j = i-1; j >= 0; j--) {
            lists.get(j).finish();
        }
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
