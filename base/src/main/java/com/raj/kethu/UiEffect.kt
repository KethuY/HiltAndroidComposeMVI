package com.raj.kethu

import com.kethu.raj.networkmodule.client.ErrorResponse


interface UiEffect

 interface UiError  {
    data class ShowErrorDialog(val error: ErrorResponse?) : UiError
    data class ShowToastMessage(val message: String) : UiError
}