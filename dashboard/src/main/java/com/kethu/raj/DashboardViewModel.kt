package com.kethu.raj

import androidx.lifecycle.viewModelScope
import com.raj.kethu.ComposeBaseViewModel
import com.raj.kethu.UiError
import com.raj.kethu.UiState
import com.raj.kethu.datastore.DataStoreConstants
import com.raj.kethu.datastore.DataStoreRepository
import com.raj.kethu.provider.AppDataProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: Yerramma Kethu
 * @Date: 20/12/2025
 */
@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,
    private val dataProvider: AppDataProvider
) :
    ComposeBaseViewModel<DashboardEvent, UiState, DashboardUiEffect, UiError>() {
    override fun onAction(action: DashboardEvent) {
        when (action) {
            is DashboardEvent.ShowThemeBottomSheet -> handleThemeChange()
            is DashboardEvent.LogoutUser -> logoutUser()
            is DashboardEvent.SaveTheme -> saveTheme(action.selectedTheme)
        }
    }

    private fun saveTheme(selectedTheme: String) {
        viewModelScope.launch {
            dataStoreRepository.putPreference(
                DataStoreConstants.THEME,
                selectedTheme
            )
        }
    }

    private fun logoutUser() {
        viewModelScope.launch {
            dataStoreRepository.putPreference(
                DataStoreConstants.IS_USER_SIGNED_IN,
                false
            )
        }
        dataProvider.navigateToAuthScreen()
    }

    private fun handleThemeChange() {
        sendUiEffect(DashboardUiEffect.ShowThemBottomSheet)
    }

    override fun defaultState(): UiState = DashboardUiState()
}
