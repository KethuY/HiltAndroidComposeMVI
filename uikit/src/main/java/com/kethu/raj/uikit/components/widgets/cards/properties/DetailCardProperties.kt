package com.kethu.raj.uikit.components.widgets.cards.properties

import com.kethu.raj.uikit.components.BaseView

/**
 * @Author: Yerramma Kethu
 * @Date: 21/12/2025
 */
interface DetailCardProperties : BaseView {
    val profileUrl: String
    val profileName: String
    val imageUrl: String?
    val description: String
    val trailingIcon: Int
    val comments: String?
    val commentIcon: Int?
    val likes: String?
    val likeIcon: Int?
    val shareIcons: List<Int>
}