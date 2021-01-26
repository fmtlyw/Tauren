package com.lyw.module_common_base.ext

import android.app.Activity
import androidx.annotation.ColorRes
import androidx.annotation.FloatRange
import com.gyf.immersionbar.ktx.immersionBar

fun Activity.immersionStatusBar() {
    immersionBar {}
}

fun Activity.immersionStatusBar(
    fits: Boolean = true,
    @ColorRes statusBarColor: Int,
    isDarkFont: Boolean,
    @FloatRange(from = 0.0, to = 1.0) statusAlpha: Float
) {
    immersionBar {
        fitsSystemWindows(fits)
        statusBarColor(statusBarColor)
        statusBarDarkFont(isDarkFont, statusAlpha)
    }
}