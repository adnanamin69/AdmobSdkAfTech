package com.example.utilities.other_utils.extentions

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.loader.content.CursorLoader
import com.example.utilities.R
import com.example.utilities.base.BaseActivity
import com.example.utilities.base.BaseActivity.Companion.interstitialTimeElapsed
import com.example.utilities.other_utils.CONTACTS_CONTENT_URI
import com.example.utilities.other_utils.extentions.ContextExtentions.loadInterstitial
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.firebase.analytics.FirebaseAnalytics
import java.util.*
import java.util.concurrent.TimeUnit

object ContextExtentions {


    fun Activity.loadInterstitial() {


        Log.i("mInterstitialAd", "called")
        val adRequest: AdRequest = AdRequest.Builder().build()
        InterstitialAd.load(this, (this as BaseActivity).interstitialId, adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(@NonNull interstitialAd: InterstitialAd) {
                    this@loadInterstitial.mInterstitialAd = interstitialAd
                    Log.i("mInterstitialAd", "onAdLoaded: add  loade")
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    mInterstitialAd = null
                    Log.i("mInterstitialAd", "onAdLoaded: ${error.message}")
                }
            })
    }


    fun Activity.showFullAd(callBack: () -> Unit) {


        (this as BaseActivity).mInterstitialAd?.fullScreenContentCallback =
            object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    loadInterstitial()
                    callBack()
                }

                override fun onAdImpression() {
                    super.onAdImpression()
                    interstitialTimeElapsed =
                        Calendar.getInstance().timeInMillis
                }

                override fun onAdShowedFullScreenContent() {}
                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                    super.onAdFailedToShowFullScreenContent(p0)
                    callBack()
                }
            }

        if (mInterstitialAd != null && timeDifference(interstitialTimeElapsed) > elapseTime)
            mInterstitialAd?.show(this)
        else
            callBack()
    }

    fun timeDifference(millis: Long): Int {
        val current = Calendar.getInstance().timeInMillis
        val elapsedTime = current - millis

        return TimeUnit.MILLISECONDS.toSeconds(elapsedTime).toInt()
    }

}