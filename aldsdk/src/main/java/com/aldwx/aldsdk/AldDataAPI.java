package com.aldwx.aldsdk;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

public class AldDataAPI {
    private  TrackProcessor mTrackProcessor;
    private static Context mContext;
    private String appKey;

    public static volatile AldDataAPI sAldDataAPI;


    public AldDataAPI(Context context) {
        this.mContext = context.getApplicationContext();
        this.mTrackProcessor = new TrackProcessor();
    }
    public AldDataAPI() {

    }
    public static AldDataAPI getInstance() {
        if (sAldDataAPI == null) {
            synchronized (AldDataAPI.class) {
                sAldDataAPI = new AldDataAPI();
                sAldDataAPI.mTrackProcessor = new TrackProcessor();
            }
        }
        return sAldDataAPI;
    }

    /**
     *
     * @param appKey  填写您申请的appKey
     * @param isDebug 埋点校验为true，正式上报为false
     */
    public void initSdk(String appKey,boolean isDebug) {
        mTrackProcessor.initSDK(mContext.getApplicationContext(), appKey, isDebug);
    }

    /**
     * // 记录激活事件，无自定义属性
     */
    public void trackAppInstall() {
        mTrackProcessor.trackAppInstall();
    }

    /**
     * // 记录渠道事件
     */
    public void dloadChannel(String channel) {
        mTrackProcessor.dloadChannel(channel);
    }

    //SDK 初始化后，可以通过 track() 方法追踪用户行为事件，并为事件添加自定义属性：
    public void trackEvent(String eventName, JSONObject properties) {
        mTrackProcessor.trackEvent(eventName, properties);

    }

    //SDK 初始化后，可以通过 track() 方法追踪用户行为事件，并为预定义属性
    public void trackPredefined(String eventName, JSONObject properties) {
        mTrackProcessor.trackPredefined(eventName, properties);
    }
}
