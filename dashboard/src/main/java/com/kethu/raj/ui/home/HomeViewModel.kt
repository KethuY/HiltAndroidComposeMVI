package com.kethu.raj.ui.home

import com.raj.kethu.ComposeBaseViewModel
import com.raj.kethu.UiEffect
import com.raj.kethu.UiError
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author: Yerramma Kethu
 */
@HiltViewModel
class HomeViewModel @Inject constructor(private val interactor: HomeInteractor) :
    ComposeBaseViewModel<HomeEvent, HomeUiState, UiEffect, UiError>() {

    override fun onAction(action: HomeEvent) {
        if (action == HomeEvent.GetHomeItems) {
            sendUiState(state.value.copy(items = interactor.getHomeData()))
        }
    }

    override fun defaultState(): HomeUiState = HomeUiState()

}