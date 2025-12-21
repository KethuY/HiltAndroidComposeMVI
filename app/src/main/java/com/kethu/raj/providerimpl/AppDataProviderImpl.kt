package com.kethu.raj.providerimpl

import android.content.Context
import android.content.Intent
import com.kethu.raj.DashboardActivity
import com.kethu.raj.provider.AppDataProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author: Yerramma Kethu
 * @Date: 20/12/2025
 */
@Singleton
class AppDataProviderImpl @Inject constructor(@ApplicationContext private val appContext: Context) : AppDataProvider {
    override fun navigateToDashboard(context: Context) {
        val targetContext = when (context) {
            is android.app.Activity -> context
            else -> appContext
        }

        val intent = Intent(targetContext, DashboardActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        targetContext.startActivity(intent)
    }
}