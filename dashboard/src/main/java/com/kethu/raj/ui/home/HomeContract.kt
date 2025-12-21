package com.kethu.raj.ui.home

import com.kethu.raj.uikit.components.widgets.cards.properties.DetailCardProperties
import com.raj.kethu.UiState

sealed class HomeEvent {
    data object GetHomeItems : HomeEvent()
}

data class HomeUiState(
    val items: List<DetailCardProperties> = emptyList()
) : UiState