package com.kethu.raj.listeners

/**
 * @Author: Yerramma Kethu
 * @Date: 23/12/2025
 */
class DashboardListenersImpl(
    override val onRefreshListener: () -> Unit = {},
    override val onLogoutClick: () -> Unit = {},
    override val onSearchClick: () -> Unit = {},
    override val onNotificationClick: () -> Unit = {},
) : DashboardListeners