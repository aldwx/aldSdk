package com.aldwx.aldsdk;

import static com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.getAppName;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SensorsAnalyticsAutoTrackEventType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;

import org.json.JSONException;
import org.json.JSONObject;


public class AldOptions {
    public void initSDK(Application application, String appkey) {

        String SA_SERVER_URL = "https://slog.aldwx.com/d.html?ak=" + appkey;
        initSaSDK(application, SA_SERVER_URL);

    }

    public void initSaSDK(Application application, String url) {

        // 初始化配置
        SAConfigOptions saConfigOptions = new SAConfigOptions(url);
        // 开启全埋点
        saConfigOptions.setAutoTrackEventType(
                SensorsAnalyticsAutoTrackEventType.APP_START |
                        SensorsAnalyticsAutoTrackEventType.APP_END |
                        SensorsAnalyticsAutoTrackEventType.APP_VIEW_SCREEN)
                //开启 Log
                .enableLog(true);
        //页面离开
        saConfigOptions.enableTrackPageLeave(true);
        //app崩溃
        saConfigOptions.enableTrackAppCrash();
        // 传入 true 代表开启推送点击事件自动采集
        saConfigOptions.enableTrackPush(true);
        // 需要在主线程初始化神策 SDK
        SensorsDataAPI.startWithConfigOptions(application.getApplicationContext(), saConfigOptions);
        dloadChannel("");
    }

    /**
     * // 记录激活事件，无自定义属性
     */
    public void trackAppInstall() {
        SensorsDataAPI.sharedInstance().trackAppInstall();
    }

    /**
     * // 记录渠道事件
     */
    public void dloadChannel(String channel) {
        try {
            JSONObject properties = new JSONObject();
            properties.put("ald_channel", channel);
            SensorsDataAPI.sharedInstance().registerSuperProperties(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    ReNameRule mRule = new ReNameRule();

    //SDK 初始化后，可以通过 track() 方法追踪用户行为事件，并为事件添加自定义属性：
    public void trackEvent(String eventName, JSONObject properties) {
        if (mRule.checkName(eventName).equals("ok")) {
            if (mRule.checkJson(properties).equals("ok")) {
                SensorsDataAPI.sharedInstance().track(eventName, properties);
            } else {
                Log.e("track", "自定义属性：  " + mRule.checkJson(properties));
            }
        } else {
            Log.e("track", "自定义事件：  " + mRule.checkName(eventName));

        }
    }

    //SDK 初始化后，可以通过 track() 方法追踪用户行为事件，并为预定义属性
    public void trackPredefined(String eventName, JSONObject properties) {
        if (mRule.checkPredeName(eventName).equals("ok")) {
            if (mRule.checkPredJson(properties).equals("ok")) {
                SensorsDataAPI.sharedInstance().track(eventName, properties);
            } else {
                Log.e("track", "预定义属性：  " + mRule.checkPredJson(properties));
            }
        } else {
            Log.e("track", "预定义事件：  " + mRule.checkPredeName(eventName));
        }
    }

}
