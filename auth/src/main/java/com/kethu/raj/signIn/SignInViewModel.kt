package com.kethu.raj.signIn

import androidx.lifecycle.viewModelScope
import com.kethu.raj.provider.AppDataProvider
import com.raj.kethu.ComposeBaseViewModel
import com.raj.kethu.UiEffect
import com.raj.kethu.datastore.DataStoreConstants
import com.raj.kethu.datastore.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Kethu on 06/07/2024.
 */
@HiltViewModel
class SignInViewModel @Inject constructor(
    /*   private val userRepository: UserRepository,*/
    private val authProvider: AppDataProvider,
    private val dataStoreRepository: DataStoreRepository
) : ComposeBaseViewModel<SignInEvent, SignInUiState, UiEffect>() {

    override fun onAction(action: SignInEvent) {
        if (action is SignInEvent.DoLogin) {
            sendUiState(state.value.copy(isLoading = true))
            if (action.userName.isNotEmpty() && action.password.isNotEmpty()) {
                authProvider.navigateToDashboard(context = action.context)
                saveInLocal(action.userName)
                sendUiState(
                    state.value.copy(
                        isLoading = false,
                        isError = false,
                        isSignInSuccess = true
                    )
                )
            } else {
                sendUiState(state.value.copy(isError = true, isLoading = false))
            }
        }
    }

    override fun defaultState(): SignInUiState = SignInUiState()

    private fun saveInLocal(userName: String) {
        viewModelScope.launch {
            dataStoreRepository.putPreference(
                DataStoreConstants.IS_USER_SIGNED_IN,
                true
            )
            dataStoreRepository.putPreference(
                DataStoreConstants.USER_NAME,
                userName
            )
        }
    }
}
