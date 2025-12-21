package com.kethu.raj.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kethu.raj.uikit.components.widgets.cards.UiDetailCard

/**
 * @Author: Yerramma Kethu
 * @Date: 21/12/2025
 */
@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val uiState = viewModel.state.collectAsStateWithLifecycle()
    viewModel.onAction(HomeEvent.GetHomeItems)
    if (uiState.value.items.isNotEmpty()) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(uiState.value.items.size) { index ->
                UiDetailCard(properties = uiState.value.items[index]) {
                    // Handle item click will be in next chamges
                }
            }
        }
    }
}