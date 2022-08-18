package com.screenrecorder.recording.software.screenshot.admobsdkaftech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.utilities.base.BaseActivity;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class JavaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setElapseTime(20);


    }

    public void onclick(View view) {
        showFullAd(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                //do your further work
                //this block will execute on add dissmiss , ad is null or fail to load add
                showToastShort("after ad");
                return Unit.INSTANCE;
            }
        });

    }

    @NonNull
    @Override
    public String getInterstitialId1() {
        return getString(R.string.app_interstitial_id);
    }
}