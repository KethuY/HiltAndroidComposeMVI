package com.kethu.raj.uikit.components.atoms.properties

import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import com.kethu.raj.uikit.components.BaseView

interface ImageProperties : BaseView {
    val src: Any?
    val contentScale: ContentScale
    val alpha: Float
    val colorFilter: ColorFilter?
    val contentDesc: String?
}