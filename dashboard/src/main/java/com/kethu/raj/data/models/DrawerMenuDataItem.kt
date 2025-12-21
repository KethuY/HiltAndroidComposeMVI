package com.kethu.raj.data.models

import com.kethu.raj.dashboard.R

/**
 * @Author: Yerramma Kethu
 * @Date: 21/12/2 R.drawable.ic_log25
 */
data class DrawerMenuDataItem(
    val title: String,
    val iconResId: Int,
    val type: DrawerMenuItemType
)

enum class DrawerMenuItemType {
    PROFILE,
    PREMIUM,
    CHAT,
    COMMUNITY,
    SETTINGS,
    BOOKMARKS,
    List,
    SPACES
}


fun getDrawerMenuItems() =
    listOf(
        DrawerMenuDataItem("Profile", iconResId = R.drawable.ic_log, type = DrawerMenuItemType.PROFILE),
        DrawerMenuDataItem("Premium", iconResId =  R.drawable.ic_log, type = DrawerMenuItemType.PREMIUM),
        DrawerMenuDataItem("Chat", iconResId =  R.drawable.ic_log, type = DrawerMenuItemType.CHAT),
        DrawerMenuDataItem("Community", iconResId =  R.drawable.ic_log, type = DrawerMenuItemType.COMMUNITY),
        DrawerMenuDataItem("Settings", iconResId =  R.drawable.ic_log, type = DrawerMenuItemType.SETTINGS),
        DrawerMenuDataItem("Bookmarks", iconResId =  R.drawable.ic_log, type = DrawerMenuItemType.BOOKMARKS),
        DrawerMenuDataItem("List", iconResId =  R.drawable.ic_log, type = DrawerMenuItemType.List),
        DrawerMenuDataItem("Spaces", iconResId =  R.drawable.ic_log, type = DrawerMenuItemType.SPACES)
    )
