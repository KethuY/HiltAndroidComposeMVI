package com.kethu.raj.networkmodule.client

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED,
}

data class NetworkState(
    val status: Status,
    val msg: String? = null
) {
    companion object {
        val SUCCESS = NetworkState(Status.SUCCESS)
        val LOADING = NetworkState(Status.RUNNING)
        val FAILED = NetworkState(Status.FAILED)
    }
}