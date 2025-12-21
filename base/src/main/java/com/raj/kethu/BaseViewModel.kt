package com.raj.kethu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raj.kethu.network.ErrorResponse
import kotlinx.coroutines.CoroutineExceptionHandler

abstract class BaseViewModel : ViewModel() {
    val isNetworkCallInProgress = MutableLiveData<Boolean>()
    val onNetworkCallFailed = MutableLiveData<ErrorResponse>()
    open val coroutineExceptionHandler = CoroutineExceptionHandler { _, _ -> }

    protected open fun onApiError(errorResponse: ErrorResponse?) {
        errorResponse?.let {
            onNetworkCallFailed.postValue(errorResponse)
        }
    }
}