package com.kethu.raj.uimodels

import com.kethu.raj.dashboard.R
import com.kethu.raj.uikit.components.molecules.toolbar.properties.ToolbarProperties


data class ToolbarUiDataModel(
    override val title: String,
    override val navigationIcon: Int = R.drawable.ic_menu
) : ToolbarProperties