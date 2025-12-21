package com.kethu.raj.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.kethu.raj.dashboard.R
import com.kethu.raj.uikit.components.widgets.UiDetailCard

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
            UiDetailCard(
                title = "Title $index",
                description = "Venky and his friends quickly escape from there. On a belief that the police academy is the only safe haven for them",
                trailingIcon = R.drawable.ic_dots
            )
        }
    }
}