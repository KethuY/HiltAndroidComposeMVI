package com.kethu.raj

import androidx.lifecycle.viewModelScope
import com.raj.kethu.ComposeBaseViewModel
import com.raj.kethu.UiError
import com.raj.kethu.UiState
import com.raj.kethu.datastore.DataStoreConstants
import com.raj.kethu.datastore.DataStoreRepository
import com.raj.kethu.theme.UiThemeHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: Yerramma Kethu
 * @Date: 19/12/2025
 */
@HiltViewModel
class LauncherViewModel @Inject constructor(private val dateStoreRepository: DataStoreRepository) :
    ComposeBaseViewModel<LauncherEvent, UiState, LauncherUiEffect, UiError>() {

    override fun defaultState() = LauncherUiState

    override fun onAction(action: LauncherEvent) {
        when (action) {
            is LauncherEvent.ClearLoginPreferences -> clearPreferences()

            is LauncherEvent.GetUserStatus -> handleUserNavigation()
        }
    }

    private fun clearPreferences() {
        viewModelScope.launch {
            dateStoreRepository.putPreference(DataStoreConstants.IS_USER_SIGNED_IN, false)
        }
    }

    private fun handleUserNavigation() {
        viewModelScope.launch {
            val theme = dateStoreRepository.getPreference(DataStoreConstants.THEME, UiThemeHelper.getSelectedThemeType())
            UiThemeHelper.setSelectedTheme(theme)
            val isSignInUser = dateStoreRepository.getPreference(DataStoreConstants.IS_USER_SIGNED_IN, false)
            if (isSignInUser) {
                sendUiEffect(LauncherUiEffect.NavigateToDashboard)
            } else {
                val isNewUser = dateStoreRepository.getPreference(DataStoreConstants.IS_NEW_USER, true)
                sendUiEffect(LauncherUiEffect.NavigateToAuthScreen(isNewUser))
            }
        }
    }
}