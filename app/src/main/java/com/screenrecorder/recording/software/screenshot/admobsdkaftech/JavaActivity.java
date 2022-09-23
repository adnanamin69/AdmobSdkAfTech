package com.screenrecorder.recording.software.screenshot.admobsdkaftech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.utilities.base.BaseActivity;
import com.example.utilities.other_utils.BannerSize;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class JavaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setElapseTime(20);
        FrameLayout fl = findViewById(R.id.ad_container_small);
        loadBanner(getString(R.string.admob_bqnner), fl, BannerSize.LARGE);
    }

    public void onclick(View view) {
        showFullAd(() -> {
            //do your further work
            //this block will execute on add dissmiss , ad is null or fail to load add
            showToastShort("after ad");
            return Unit.INSTANCE;
        });

    }

    @NonNull
    @Override
    public String getInterstitialId1() {
        return getString(R.string.app_interstitial_id);
    }
}