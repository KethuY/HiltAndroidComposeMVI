package com.kethu.raj

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.os.bundleOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.raj.kethu.BaseComposeActivity
import com.raj.kethu.CommonConstants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class LauncherActivity : BaseComposeActivity<LauncherViewModel>() {
    override val viewModel: LauncherViewModel by viewModels()

    @Composable
    override fun ActivityContent() {
        val context = LocalContext.current
        LaunchedEffect(Unit) {
            viewModel.onAction(LauncherEvent.GetUserStatus)
        }

        LaunchedEffect(key1 = lifecycle) {
            lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.uiEffect.collectLatest { effect ->
                    when (effect) {
                        is LauncherUiEffect.NavigateToAuthScreen -> navigateToActivity(
                            context,
                            AuthActivity::class.java,
                            bundleOf(CommonConstants.BUNDLE_DATA to effect.isNewUser)
                        )

                        is LauncherUiEffect.NavigateToDashboard -> navigateToActivity(
                            context,
                            DashboardActivity::class.java,

                        )
                    }
                }
            }
        }
    }

    private fun navigateToActivity(
        context: android.content.Context,
        destination: Class<*>,
        bundle: Bundle? = null
    ) {
        val intent = Intent(context, destination).apply {
            bundle?.let {
                putExtras(bundle)
            }
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)
        finish()
    }
}