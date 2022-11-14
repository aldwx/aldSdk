package com.aldwx.aldsdk;

import android.app.Application;
import android.content.Context;

import org.json.JSONObject;

public interface IAldDataApi {
    void initSDK(Context application, String appkey,boolean isDebug);

    void initSaSDK(Context application, String url);

    void trackAppInstall();

    void dloadChannel(String channel);

    void trackEvent(String eventName, JSONObject properties);

    void trackPredefined(String eventName, JSONObject properties);
}
