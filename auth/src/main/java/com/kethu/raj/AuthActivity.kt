package com.kethu.raj

import android.widget.Toast
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.kethu.raj.navigation.AuthNavHost
import com.kethu.raj.networkmodule.client.ErrorResponse
import com.kethu.raj.uikit.components.molecules.dialog.UiAlertDialog
import com.raj.kethu.BUNDLE_DATA
import com.raj.kethu.BaseComposeActivity
import com.raj.kethu.UiError
import com.raj.kethu.base.BaseApp
import com.raj.kethu.base.R
import com.raj.kethu.ui.NetworkErrorDialog
import com.raj.kethu.utils.getStringFromRes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BaseComposeActivity<AuthViewModel>() {
    override val viewModel: AuthViewModel by viewModels()

    @Composable
    override fun ActivityContent() {
        val isNewUser = intent.getBooleanExtra(BUNDLE_DATA, false)
        AuthNavHost(isNewUser = isNewUser, viewModel = viewModel)
        var currentDialogError by rememberSaveable { mutableStateOf<ErrorResponse?>(null) }
        var toastErrorMessage by rememberSaveable { mutableStateOf<String?>(null) }
        LaunchedEffect(Unit) {
            viewModel.uiError.collect { uiEffect ->
                when (uiEffect) {
                    is UiError.ShowErrorDialog -> currentDialogError = uiEffect.error
                    is UiError.ShowToastMessage -> toastErrorMessage = uiEffect.message
                    else -> Unit
                }
            }
        }
        currentDialogError?.let { error ->
            NetworkErrorDialog(error, onConfirmButton = {
                currentDialogError = null
            })
        }

        toastErrorMessage?.let { message ->
            Toast.makeText(BaseApp.getAppContext(), message, Toast.LENGTH_SHORT).show()
            toastErrorMessage = null
        }
    }
}
