package com.kethu.raj

import androidx.lifecycle.viewModelScope
import com.kethu.raj.auth.R
import com.kethu.raj.interactors.AuthInteractor
import com.raj.kethu.UiError
import com.raj.kethu.ComposeBaseViewModel
import com.raj.kethu.UiEffect
import com.raj.kethu.datastore.DataStoreConstants
import com.raj.kethu.datastore.DataStoreRepository
import com.raj.kethu.provider.AppDataProvider
import com.raj.kethu.utils.getStringFromRes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: Yerramma Kethu
 * @Date: 20/12/2025
 */
@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authProvider: AppDataProvider,
    private val dataStoreRepository: DataStoreRepository,
    private val interactor: AuthInteractor
) : ComposeBaseViewModel<AuthEvent, AuthUiState, UiEffect, UiError>() {

    override fun onAction(action: AuthEvent) {
        when (action) {
            is AuthEvent.ResetPassword -> resetPassword(action.enteredCode)
            is AuthEvent.SignIn -> doSignIn(action)
            is AuthEvent.SignUp -> doSignUp(action)
        }
    }

    // testing purpose only
    private fun doSignIn(action: AuthEvent.SignIn) {
        updateErrorMessage()
        if (action.userName.isBlank() && action.password.isBlank()) {
            updateErrorMessage(getStringFromRes(R.string.auth_invalid_credentials))
            return
        }
        sendUiState(
            state.value.copy(
                isLoading = true
            )
        )
        /* interactor.doSignIn(
             userName = action.userName,
             password = action.password,
         ).onEach { response ->
             when (response.apiNetworkState()) {
                 NetworkState.SUCCESS -> {
                     sendUiState(
                         state.value.copy(
                             isLoading = false,
                             isError = false,
                             isApiSuccess = true
                         )
                     )
                     saveInLocal(action.userName)
                     authProvider.navigateToDashboard()
                 }

                 NetworkState.FAILED -> {
                     sendUiState(
                         state.value.copy(
                             isLoading = false,
                             isError = false,
                         )
                     )
                       sendUiError(UiError.ShowError(response.getResponse()?: ErrorResponse()))
                 }
             }
         }.launchIn(viewModelScope)*/

        // need to remove this, uncomment  above code block
        authProvider.navigateToDashboard()
        saveInLocal(action.userName)
        updateSuccessState()
    }

    private fun doSignUp(action: AuthEvent.SignUp) {
        updateErrorMessage()
        val allValidFields = listOf(
            action.userName.isNotEmpty(),
            action.password.isNotEmpty(),
            action.phone.isNotEmpty(),
            action.email.isNotEmpty()
        ).all { it }
        if (!allValidFields) {
            updateErrorMessage(getStringFromRes(R.string.auth_enter_all_fields))
            return
        }
        sendUiState(state.value.copy(isLoading = true))
        /*  interactor.doSignUp(
              userName = action.userName,
              password = action.password,
              email = action.email,
              phone = action.phone
          ).onEach { response ->
              when (response.apiNetworkState()) {
                  NetworkState.SUCCESS -> {
                      sendUiState(
                          state.value.copy(
                              isLoading = false,
                              isError = false,
                              isApiSuccess = true
                          )
                      )

                      saveInLocal(action.userName, action.email)
                      authProvider.navigateToDashboard()
                  }

                  NetworkState.FAILED -> {
                      sendUiState(
                          state.value.copy(
                              isLoading = false,
                              isError = false,
                          )
                      )
                       sendUiError(UiError.ShowError(response.getResponse()?: ErrorResponse()))
                  }
              }
          }.launchIn(viewModelScope)*/

        // need to remove this, uncomment  above code block
        sendUiState(state.value.copy(isLoading = true))
        updateSuccessState()
        saveInLocal(action.userName, action.email)
        authProvider.navigateToDashboard()
    }

    private fun resetPassword(enteredCode: String) {
        updateErrorMessage()
        if (enteredCode.isBlank()) {
            updateErrorMessage(getStringFromRes(R.string.auth_enter_code))
            return
        }
        /*    interactor.resetPassword(
                enteredCode
            ).onEach { response ->
                when (response.apiNetworkState()) {
                    NetworkState.SUCCESS -> {
                        updateSuccessState()
                    }

                    NetworkState.FAILED -> {
                        sendUiState(
                            state.value.copy(
                                isLoading = false,
                                isInValidFields = false,
                                errorMessage = null
                            )
                        )
                         sendUiError(UiError.ShowError(response.getResponse()?: ErrorResponse()))
                    }
                }
            }.launchIn(viewModelScope)*/
        // need to remove this, uncomment  above code block
        updateSuccessState()
    }

    private fun updateSuccessState() {
        sendUiState(
            state.value.copy(
                isLoading = false,
                isApiSuccess = true
            )
        )
    }

    private fun updateErrorMessage(
        stringFromRes: String? = null
    ) {
        stringFromRes?.let {
            sendUiError(UiError.ShowToastMessage(stringFromRes))
        }
    }

    override fun defaultState() = AuthUiState()

    private fun saveInLocal(userName: String) {
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
}