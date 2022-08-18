package com.screenrecorder.recording.software.screenshot.admobsdkaftech;

import androidx.annotation.NonNull;

import com.example.utilities.base.MyBaseApplication;

public class MyAppLication extends MyBaseApplication {
    @NonNull
    @Override
    public String getOpenId() {
        return getString(R.string.app_open_id);
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
