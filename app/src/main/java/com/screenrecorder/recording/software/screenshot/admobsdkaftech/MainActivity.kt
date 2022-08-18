package com.screenrecorder.recording.software.screenshot.admobsdkaftech

import android.os.Bundle
import com.example.utilities.base.BaseActivity
import com.example.utilities.other_utils.extentions.ContextExtentions.showFullAd

class MainActivity : BaseActivity() {
    override fun getInterstitialId1(): String {
        return getString(R.string.app_interstitial_id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        elapseTime = 20
    }

    fun onclick() {
        showFullAd {
            showToastShort("after ad")
        }

    }
}