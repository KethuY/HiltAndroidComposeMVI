package com.raj.kethu.base

import android.app.Application

/**
 * @Author: Yerramma Kethu
 * @Date: 28/12/2025
 */
abstract class BaseApp : Application() {


    companion object {
        lateinit var sInstance: BaseApp
        fun getAppContext(): BaseApp = sInstance
    }


    override fun onCreate() {
        super.onCreate()
        sInstance = this
    }
}