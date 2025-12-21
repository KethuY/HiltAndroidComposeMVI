package com.kethu.raj.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kethu.raj.dashboard.R
import com.kethu.raj.uikit.components.widgets.cards.UiDetailCard
import com.kethu.raj.uikit.components.widgets.cards.uidatamodels.DetailCardUiDataModel

/**
 * @Author: Yerramma Kethu
 * @Date: 21/12/2025
 */
@Composable
fun DashboardScreen() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(20) { index ->
            val itemModel = DetailCardUiDataModel(
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
            UiDetailCard(
                properties = itemModel
            )
        }
    }
}