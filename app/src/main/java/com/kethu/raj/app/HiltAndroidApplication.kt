package com.kethu.raj.app

import com.kethu.raj.networkmodule.BuildConfig
import com.raj.kethu.base.BaseApp
import com.raj.kethu.logs.ReleaseReportingTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * @Author: Yerramma Kethu
 * @Date: 15/12/2025
 */
@HiltAndroidApp
class HiltAndroidApplication : BaseApp() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            // Debug logging to Logcat with automatic tags, line numbers
            Timber.plant(Timber.DebugTree())
        } else {
            // Production logging policy: filter, forward WARN/ERROR to crash reporting
            Timber.plant(ReleaseReportingTree())
        }
    }
}