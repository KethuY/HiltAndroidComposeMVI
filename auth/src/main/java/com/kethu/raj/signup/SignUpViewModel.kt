package com.kethu.raj.signup

import androidx.lifecycle.viewModelScope
import com.kethu.raj.provider.AppDataProvider
import com.raj.kethu.ComposeBaseViewModel
import com.raj.kethu.UiEffect
import com.raj.kethu.datastore.DataStoreConstants
import com.raj.kethu.datastore.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    /*   private val userRepository: UserRepository,*/
    private val authProvider: AppDataProvider,
    private val dataStoreRepository: DataStoreRepository
) : ComposeBaseViewModel<SignUpEvent, SignUpUiState, UiEffect>() {

    override fun onAction(action: SignUpEvent) {
        if (action is SignUpEvent.DoSignUp) {
            sendUiState(state.value.copy(isLoading = true))
            val allValidFields = listOf(
                action.userName.isNotEmpty(),
                action.password.isNotEmpty(),
                action.phone.isNotEmpty(),
                action.email.isNotEmpty()
            ).all { it }

            if (allValidFields) {
                sendUiState(
                    state.value.copy(
                        isLoading = false,
                        isError = false,
                        isSignUpSuccess = true
                    )
                )
                saveInLocal(action.userName, action.email)
                authProvider.navigateToDashboard(context = action.context)
            } else {
                sendUiState(state.value.copy(isError = true, isLoading = false))
            }
        }
    }

    private fun saveInLocal(userName: String, email: String) {
        viewModelScope.launch {
            dataStoreRepository.putPreference(
                DataStoreConstants.IS_USER_SIGNED_IN,
                true
            )
            dataStoreRepository.putPreference(
                DataStoreConstants.IS_NEW_USER,
                false
            )
            dataStoreRepository.putPreference(
                DataStoreConstants.USER_NAME,
                userName
            )
            dataStoreRepository.putPreference(
                DataStoreConstants.USER_EMAIL,
                email
            )
        }
    }

    override fun defaultState() = SignUpUiState()
}
