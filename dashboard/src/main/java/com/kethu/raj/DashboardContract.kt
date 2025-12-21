package com.kethu.raj

import com.raj.kethu.UiEffect
import com.raj.kethu.UiState

/**
 * Created by Kethu on 06/07/2024.
 */
sealed class DashboardEvent {
    data object LogoutUser :
        DashboardEvent()

    data object ShowThemeBottomSheet: DashboardEvent()
    data class SaveTheme(val selectedTheme: String) : DashboardEvent()
}

data class DashboardUiState(
    val isError: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) : UiState

sealed interface DashboardUiEffect : UiEffect {
    data object ShowThemBottomSheet : DashboardUiEffect
}
