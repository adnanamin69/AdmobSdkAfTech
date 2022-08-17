package com.example.utilities.other_utils.extentions

import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.telephony.PhoneNumberUtils
import android.view.*
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import com.example.utilities.other_utils.lastClickTime
import com.example.utilities.other_utils.normalizeRegex
import java.text.Normalizer
import java.util.*


object ViewsExtention {

    fun View.setOnOneClickListener(debounceTime: Long = 500L, action: (v: View) -> Unit) {
        this.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View) {
                if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return
                else action(v)
                lastClickTime = SystemClock.elapsedRealtime()
            }
        })
    }


    fun View.visible() {
        visibility = View.VISIBLE
    }

    fun View.gone() {
        visibility = View.GONE
    }

    fun View.inVisible() {
        visibility = View.INVISIBLE
    }




}