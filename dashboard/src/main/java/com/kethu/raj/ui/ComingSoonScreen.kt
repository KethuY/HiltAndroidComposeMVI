package com.kethu.raj.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.kethu.raj.uikit.components.atoms.CustomText
import com.kethu.raj.uikit.ui.theme.Style32H1Medium
import com.kethu.uikit.components.atoms.uidatamodels.TextUiDataModel

/**
 * @Author: Yerramma Kethu
 */
@Composable
fun ComingSoonScreen(title: String) {
    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomText(properties = TextUiDataModel(text = title, textStyle = Style32H1Medium))
    }
}