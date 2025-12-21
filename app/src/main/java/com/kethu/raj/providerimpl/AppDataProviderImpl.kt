package com.kethu.raj.providerimpl

import android.content.Intent
import com.kethu.raj.AuthActivity
import com.kethu.raj.DashboardActivity
import com.raj.kethu.base.BaseApp
import com.raj.kethu.provider.AppDataProvider
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author: Yerramma Kethu
 * @Date: 20/12/2025
 */
@Singleton
class AppDataProviderImpl @Inject constructor() : AppDataProvider {

    override fun navigateToDashboard() = navigateToActivity(DashboardActivity::class.java)

    override fun navigateToAuthScreen() = navigateToActivity(AuthActivity::class.java)

    private fun navigateToActivity(activityClass: Class<*>) {
        val context = BaseApp.getAppContext()
        val intent = Intent(context, activityClass).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NO_ANIMATION)
        }
        context.startActivity(intent)
    }
}