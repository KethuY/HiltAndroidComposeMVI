package com.kethu.raj.ui.home

import androidx.compose.ui.graphics.Color
import com.kethu.raj.DashboardConstants.HOME_ITEMS_SIZE
import com.kethu.raj.dashboard.R
import com.kethu.raj.uikit.components.widgets.cards.uidatamodels.DetailCardUiDataModel
import javax.inject.Inject

/**
 * @Author: Yerramma Kethu
 */

class HomeInteractor @Inject constructor() {

    // should be replaced with real data fetching logic from server
    fun getHomeData(): List<DetailCardUiDataModel> = List(HOME_ITEMS_SIZE) { index ->
        DetailCardUiDataModel(
            profileUrl = "https://data.sandbox.directory.openfinance.ae/logos/73423662-b345-453e-a54b-2f9115a6a45d/softwarestatements/1a703edb-b138-4fae-99aa-8348d418f296.png",
            shareIcons = listOf(R.drawable.ic_noti, R.drawable.ic_log, R.drawable.ic_search),
            description = "Venky and his friends quickly escape from there. On a belief that the police academy is the only safe haven for them",
            trailingIcon = R.drawable.ic_dots,
            profileName = "Title $index",
            imageUrl = "https://dummyimage.com/600x500/b06db0/b06db0",
            backgroundColor = Color.White,
            comments = "Comments",
            commentIcon = R.drawable.ic_search,
            likes = "Likes",
            likeIcon = R.drawable.ic_noti,
        )
    }
}