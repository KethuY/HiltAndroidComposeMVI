package com.kethu.raj.ui.todos

import com.kethu.raj.data.uimodels.TodoUiModel
import com.raj.kethu.UiState

sealed class TodoEvent {
data object GetTodoItems : TodoEvent()
}

data class TodoUiState(
    val items: List<TodoUiModel> = emptyList()
) : UiState