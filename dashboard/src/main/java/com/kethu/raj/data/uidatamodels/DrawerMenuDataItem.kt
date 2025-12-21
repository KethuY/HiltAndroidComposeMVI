package com.kethu.raj.data.uidatamodels

import com.kethu.raj.dashboard.R
import com.kethu.raj.navaigation.dashboard.Bookmarks
import com.kethu.raj.navaigation.dashboard.Chat
import com.kethu.raj.navaigation.dashboard.Community
import com.kethu.raj.navaigation.dashboard.List
import com.kethu.raj.navaigation.dashboard.Premium
import com.kethu.raj.navaigation.dashboard.Profile
import com.kethu.raj.navaigation.dashboard.Settings
import com.kethu.raj.navaigation.dashboard.Spaces
import com.kethu.raj.navaigation.dashboard.Todos
import com.raj.kethu.utils.getStringFromRes
import java.io.Serializable

/**
 * @Author: Yerramma Kethu
 */

data class DrawerMenuDataItem(
    val title: String,
    val iconResId: Int,
    val type: Any
): Serializable

fun getDrawerMenuItems() =
    listOf(
        DrawerMenuDataItem(
            title = getStringFromRes(R.string.menu_profile),
            iconResId = R.drawable.ic_log,
            type = Profile
        ),
        DrawerMenuDataItem(
            title = getStringFromRes(R.string.menu_premium),
            iconResId = R.drawable.ic_log,
            type = Premium
        ),
        DrawerMenuDataItem(
            title = getStringFromRes(R.string.menu_chat),
            iconResId = R.drawable.ic_log,
            type = Chat
        ),
        DrawerMenuDataItem(
            title = getStringFromRes(R.string.menu_community),
            iconResId = R.drawable.ic_log,
            type = Community
        ),
        DrawerMenuDataItem(
            title = getStringFromRes(R.string.menu_settings),
            iconResId = R.drawable.ic_log,
            type = Settings
        ),
        DrawerMenuDataItem(
            title = getStringFromRes(R.string.menu_bookmarks),
            iconResId = R.drawable.ic_log,
            type = Bookmarks
        ),
        DrawerMenuDataItem(
            title = getStringFromRes(R.string.menu_list),
            iconResId = R.drawable.ic_log,
            type = List
        ),
        DrawerMenuDataItem(
            title = getStringFromRes(R.string.menu_spaces),
            iconResId = R.drawable.ic_log,
            type = Spaces
        ),
        DrawerMenuDataItem(
            title = getStringFromRes(R.string.menu_todos),
            iconResId = R.drawable.ic_log,
            type = Todos
        )
    )
