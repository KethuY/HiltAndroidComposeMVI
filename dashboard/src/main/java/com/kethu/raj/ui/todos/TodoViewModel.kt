package com.kethu.raj.ui.todos

import androidx.lifecycle.viewModelScope
import com.kethu.raj.data.uimodels.TodoUiModel
import com.kethu.raj.networkmodule.client.NetworkState
import com.raj.kethu.ComposeBaseViewModel
import com.raj.kethu.UiEffect
import com.raj.kethu.UiError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * @Author: Yerramma Kethu
 */
@HiltViewModel
class TodoViewModel @Inject constructor(private val interactor: TodosInteractor) :
    ComposeBaseViewModel<TodoEvent, TodoUiState, UiEffect, UiError>() {

    override fun onAction(action: TodoEvent) {
        if (action == TodoEvent.GetTodoItems) {
            fetchTodos()
        }
    }

    private fun fetchTodos() {
        interactor.fetchTodos().onEach { response ->
            when (response.apiNetworkState()) {
                NetworkState.SUCCESS -> {
                    response.getResponse<List<TodoUiModel>>()?.let { items ->
                        sendUiState(state.value.copy(items = items))
                    }
                }

                NetworkState.FAILED -> {
                    sendUiError(UiError.ShowErrorDialog(response.getError()))
                }
            }
        }.launchIn(viewModelScope)
    }

    override fun defaultState(): TodoUiState = TodoUiState()

}