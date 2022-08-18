package com.example.utilities.base

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.utilities.R
import com.example.utilities.other_utils.extentions.ContextExtentions.loadInterstitial
import com.example.utilities.other_utils.extentions.ViewsExtention.setOnOneClickListener
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.firebase.analytics.FirebaseAnalytics


abstract class BaseActivity : AppCompatActivity() {
    val interstitialId: String
        get() = getInterstitialId1()
    var mInterstitialAd: InterstitialAd? = null
    var elapseTime: Int = 15


    abstract fun getInterstitialId1(): String

    companion object {
        var interstitialTimeElapsed = 0L
    }

    private var mFirebaseAnalytics: FirebaseAnalytics? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        loadInterstitial()


    }


    fun showRateUsDialog() {
        val view: View = LayoutInflater.from(this).inflate(R.layout.rate_us_dialog, null)
        val builder = AlertDialog.Builder(this).setView(view)
        val dialog = builder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

        view.findViewById<CardView>(R.id.cancel_btn).setOnOneClickListener { dialog.dismiss() }
        view.findViewById<TextView>(R.id.rate_us_btn).setOnOneClickListener {

            val rating = view.findViewById<RatingBar>(R.id.rating_bar).rating

            if (rating < 4) {
                Toast.makeText(this, "Thanks for your feedback :)", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
                return@setOnOneClickListener
            }


            dialog.dismiss()
            try {
                val rateIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + applicationContext.packageName)
                )
                startActivity(rateIntent)
            } catch (exc: java.lang.Exception) {
                Log.i("TAG", "showRateUsDialog: " + exc.message)
                Toast.makeText(this, "Links are down", Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun goToPrivacy(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        try {
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "Links are down", Toast.LENGTH_SHORT).show()
        }
    }


    fun postAnalytic(event: String?) {
        val bundle = Bundle()
        bundle.putString(event, event)
        if (event == null)
            return
        mFirebaseAnalytics?.logEvent(event, bundle)

        mFirebaseAnalytics?.let {}
    }


    /*  fun isInternetAvailable(): Boolean {
          val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
          val activeNetwork: NetworkInfo? = cm.activeNetworkInfo

          return activeNetwork?.isConnectedOrConnecting == true
      }*/

/*
    open fun loadInterstitial() {


        Log.i("mInterstitialAd", "called")
        val adRequest: AdRequest = AdRequest.Builder().build()
        InterstitialAd.load(this, interstitialId, adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(@NonNull interstitialAd: InterstitialAd) {
                    mInterstitialAd = interstitialAd
                    Log.i("mInterstitialAd", "onAdLoaded: add  loade")
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    mInterstitialAd = null
                    Log.i("mInterstitialAd", "onAdLoaded: ${error.message}")
                }
            })
    }


    fun showFullAd(callBack: () -> Unit) {


        mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
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

        if (mInterstitialAd != null && timeDifference(interstitialTimeElapsed) > 15)
            mInterstitialAd?.show(this)
        else
            callBack()
    }

    private fun timeDifference(millis: Long): Int {
        val current = Calendar.getInstance().timeInMillis
        val elapsedTime = current - millis

        return TimeUnit.MILLISECONDS.toSeconds(elapsedTime).toInt()
    }*/


    fun showToastShort(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun showToastLong(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}