package com.example.utilities.other_utils

import com.google.android.gms.ads.AdSize

enum class BannerSize(val size: AdSize) {
    SMALL(AdSize.BANNER), MEDIUM(AdSize.FULL_BANNER), LARGE(AdSize.LARGE_BANNER)
}