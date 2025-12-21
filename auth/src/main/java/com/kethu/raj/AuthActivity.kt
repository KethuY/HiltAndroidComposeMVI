package com.kethu.raj

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.kethu.raj.navigation.UserNavHost
import com.raj.kethu.BaseComposeActivity
import com.raj.kethu.CommonConstants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BaseComposeActivity<AuthViewModel>() {
    override val viewModel: AuthViewModel by viewModels()

    @Composable
    override fun ActivityContent() {
        val isNewUser = intent.getBooleanExtra(CommonConstants.BUNDLE_DATA, false)
        UserNavHost(isNewUser = isNewUser)
    }
}
