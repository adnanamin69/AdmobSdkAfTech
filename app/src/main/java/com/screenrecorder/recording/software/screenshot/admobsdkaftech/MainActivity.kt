package com.screenrecorder.recording.software.screenshot.admobsdkaftech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.utilities.base.BaseActivity
import com.example.utilities.other_utils.extentions.ContextExtentions.showFullAd

class MainActivity : BaseActivity() {
    override fun getInterstitialId1(): String {
        return getString(R.string.app_interstitial_id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Handler(Looper.getMainLooper()).postDelayed({

        }, 5000)

    }

    fun onclick(view: View) {
        showFullAd {
            showToastShort("after ad")
        }

    }
}