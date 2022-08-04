package com.applid.nsofttask.ui.screens.common

import android.content.Context
import android.util.DisplayMetrics

 class ScreenSize(context: Context) {

    var displayMetrics: DisplayMetrics = context.getResources().getDisplayMetrics()

    fun getScreenWidth() : Float {
        return displayMetrics.widthPixels / displayMetrics.density
    }

    fun getScreenHeight() : Float {
        return displayMetrics.heightPixels / displayMetrics.density
    }



}