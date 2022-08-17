package com.screenrecorder.recording.software.screenshot.admobsdkaftech

import com.example.utilities.base.MyBaseApplication

class MyApp : MyBaseApplication() {

    override fun getOpenId(): String {
        return getString(R.string.app_open_id)
    }

    override fun onCreate() {
        super.onCreate()

    }
}