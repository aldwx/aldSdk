package com.aldwx.aldsdk;


import android.content.Context;

import org.json.JSONObject;

public abstract class AbstractData {

    IAldDataApi mIAldDataApi;

    public AbstractData() {

        this.mIAldDataApi = new DataManager();
    }

    void initSaSDK(Context application, String url) {
        mIAldDataApi.initSaSDK(application, url);
    }

    void initSDK(Context application, String appKey,boolean isDebug) {
        mIAldDataApi.initSDK(application, appKey, isDebug);
    }


    void trackAppInstall() {
        mIAldDataApi.trackAppInstall();
    }


    void dloadChannel(String channel) {
        mIAldDataApi.dloadChannel(channel);
    }


    void trackEvent(String eventName, JSONObject properties) {
        mIAldDataApi.trackEvent(eventName, properties);
    }


    void trackPredefined(String eventName, JSONObject properties) {
        mIAldDataApi.trackPredefined(eventName, properties);
    }
}
