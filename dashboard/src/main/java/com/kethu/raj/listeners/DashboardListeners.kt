package com.kethu.raj.listeners


/**
 * @Author: Yerramma Kethu
 * @Date: 23/12/2025
 */
interface DashboardListeners {
    val onRefreshListener: () -> Unit
    val onLogoutClick: () -> Unit
    val onSearchClick: () -> Unit
    val onNotificationClick: () -> Unit
}