package com.kethu.raj.uikit.components.widgets.cards.uidatamodels

import androidx.compose.ui.graphics.Color
import com.kethu.raj.uikit.components.widgets.cards.properties.DetailCardProperties

/**
 * @Author: Yerramma Kethu
 * @Date: 21/12/2025
 */
class DetailCardUiDataModel(
    override val backgroundColor: Color,
    override val profileUrl: String,
    override val profileName: String,
    override val imageUrl: String?,
    override val description: String,
    override val trailingIcon: Int,
    override val comments: String?,
    override val commentIcon: Int?,
    override val likes: String?,
    override val likeIcon: Int?,
    override val shareIcons: List<Int>
) : DetailCardProperties