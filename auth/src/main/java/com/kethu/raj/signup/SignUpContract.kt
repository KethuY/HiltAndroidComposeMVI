package com.kethu.raj.signup

import android.content.Context
import com.raj.kethu.UiState

data class SignUpUiState(
    val isError: Boolean = false,
    val isLoading: Boolean = false,
    val isSignUpSuccess: Boolean = false
) : UiState

sealed interface SignUpEvent {
    data class DoSignUp(
        val context: Context,
        val userName: String,
        val password: String,
        val phone: String,
        val email: String
    ) : SignUpEvent
}
