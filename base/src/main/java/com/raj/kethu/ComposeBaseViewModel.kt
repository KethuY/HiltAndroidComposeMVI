package com.raj.kethu

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * @Author: Yerramma Kethu
 * @Date: 15/12/2025
 */
abstract class ComposeBaseViewModel<Action, State : UiState, Effect : UiEffect, Error : UiError> :
    BaseViewModel() {

    abstract fun onAction(action: Action)
    abstract fun defaultState(): State

    private val _uiEffect = Channel<Effect>()
    val uiEffect = _uiEffect.receiveAsFlow()

    private val _uiError = Channel<Error>()
    val uiError = _uiError.receiveAsFlow()

    private val _state = MutableStateFlow(defaultState())
    val state = _state.asStateFlow()

    protected fun sendUiState(uiState: State) {
        viewModelScope.launch {
            _state.emit(uiState)
        }
    }

    protected fun sendUiEffect(uiEffect: Effect) {
        viewModelScope.launch {
            _uiEffect.send(uiEffect)
        }
    }

    protected fun sendUiError(uiError: Error) {
        viewModelScope.launch {
            Log.d("","Sending UI Error: $uiError")
            _uiError.send(uiError)
        }
    }
}