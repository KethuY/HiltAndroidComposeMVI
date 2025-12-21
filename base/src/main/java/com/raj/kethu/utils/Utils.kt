package com.raj.kethu.utils

import com.google.gson.Gson
import com.raj.kethu.base.BaseApp

/**
 * @Author: Yerramma Kethu
 * @Date: 28/12/2025
 */

fun getJsonString(jsonElement: Any): String? = Gson().toJson(jsonElement)

fun getStringFromRes(resId: Int): String =
    BaseApp.getAppContext().resources.getString(resId)