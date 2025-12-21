package com.kethu.raj.data.uidatamodels

import com.kethu.raj.dashboard.R
import com.kethu.raj.uikit.components.molecules.toolbar.properties.ToolbarProperties


data class DashboardToolbarUiDataModel(
    override val title: String,
    override val navigationIcon: Int = R.drawable.ic_menu
) : ToolbarProperties