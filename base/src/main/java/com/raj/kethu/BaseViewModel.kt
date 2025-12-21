package com.raj.kethu

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler

abstract class BaseViewModel : ViewModel() {
    open val coroutineExceptionHandler = CoroutineExceptionHandler { _, _ -> }
}