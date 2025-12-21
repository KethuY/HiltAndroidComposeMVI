package com.kethu.raj

import com.raj.kethu.UiEffect
import com.raj.kethu.UiState

sealed class LauncherEvent {
    data object GetUserStatus : LauncherEvent()
    data object ClearLoginPreferences : LauncherEvent()
}

data object LauncherUiState : UiState

sealed interface LauncherUiEffect : UiEffect {
    data object NavigateToDashboard : LauncherUiEffect
    data class NavigateToAuthScreen(val isNewUser: Boolean) : LauncherUiEffect
}
