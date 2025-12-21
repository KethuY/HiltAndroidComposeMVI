package com.kethu.raj.signIn

import android.content.Context
import com.raj.kethu.UiState

/**
 * Created by Kethu on 06/07/2024.
 */
sealed class SignInEvent {
    data class DoLogin(val context: Context, val userName: String, val password: String) :
        SignInEvent()
}

data class SignInUiState(
    val isError: Boolean = false,
    val isLoading: Boolean = false,
    val isSignInSuccess: Boolean = false,
    val errorMessage: String? = null
) : UiState
