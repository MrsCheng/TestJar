package com.cheng.dreams.library.util;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Snow on 2017/3/7.
 * Description:
 */

public class ResponseDecoder {
    public static String decode(String response){
        try {
            JSONObject jo = null;
            try {
                jo = new JSONObject(response);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            boolean secure = jo.optBoolean("secure", false);
            String secureS = jo.optString("secure", "");
            if (jo != null && (secure || secureS.equals("true"))) {
                if (null != jo.getString("data")) {
                    String jsonObject = jo.getString("data");
                    if (!StringUtil.isEmpty(jsonObject)) {
                        String decodeData = AES256Util.decrypt(jsonObject);//解密后的数据
                        if (TextUtils.equals("{", decodeData.substring(0, 1))) {
                            JSONObject jsonObject1 = new JSONObject(decodeData);
                            jo.put("data", jsonObject1);
                        } else if (TextUtils.equals("[", decodeData.substring(0, 1))) {
                            JSONArray jsonArray = new JSONArray(decodeData);
                            jo.put("data", jsonArray);
                        } else {
                            jo.put("data", decodeData);
                        }
                        response = jo.toString();
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return response;
    }
}
