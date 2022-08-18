package com.screenrecorder.recording.software.screenshot.admobsdkaftech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.utilities.base.BaseActivity;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class JavaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        setElapseTime(20);

        showFullAd(() ->


                Unit.INSTANCE);

    }

    @NonNull
    @Override
    public String getInterstitialId1() {
        return getString(R.string.app_interstitial_id);
    }
}