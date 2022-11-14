package com.aldwx.aldsdk;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

public class TrackProcessor extends AbstractData{

    @Override
    void initSaSDK(Context application, String url) {
        super.initSaSDK(application, url);

    }
    @Override
    void trackAppInstall() {
        super.trackAppInstall();

    }

    @Override
    void dloadChannel(String channel) {
        super.dloadChannel(channel);

    }
    @Override
    void trackEvent(String eventName, JSONObject properties) {
        super.trackEvent(eventName, properties);

    }
    @Override
    void trackPredefined(String eventName, JSONObject properties) {
        super.trackPredefined(eventName, properties);

    }
}
