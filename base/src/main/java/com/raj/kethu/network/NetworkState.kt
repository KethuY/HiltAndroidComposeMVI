package com.raj.kethu.network

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val error: ErrorResponse) : Result<Nothing>()
    data object Loading : Result<Nothing>()
}

class ErrorResponse(
    val code: String? = null,
    val message: String? = null
)
