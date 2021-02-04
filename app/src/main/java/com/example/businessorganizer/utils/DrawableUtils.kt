package com.example.businessorganizer.utils

import android.content.Context
import android.graphics.drawable.GradientDrawable
import androidx.core.content.ContextCompat

object DrawableUtils {
    fun getBackgroundDrawable(context: Context, drawableRes: Int) = ContextCompat.getDrawable(context, drawableRes) as GradientDrawable
}