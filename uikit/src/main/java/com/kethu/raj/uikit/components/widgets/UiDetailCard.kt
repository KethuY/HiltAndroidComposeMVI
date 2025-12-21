package com.kethu.raj.uikit.components.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.kethu.raj.uikit.components.atoms.CustomImage
import com.kethu.raj.uikit.components.atoms.CustomText
import com.kethu.raj.uikit.components.atoms.uidatamodels.ImageUiDataModel
import com.kethu.raj.uikit.ui.theme.Style14CaptionRegular
import com.kethu.uikit.components.atoms.uidatamodels.TextUiDataModel

/**
 * @Author: Yerramma Kethu
 * @Date: 21/12/2025
 */
@Composable
fun UiDetailCard(
    modifier: Modifier = Modifier,
    profileUrl: String = "https://data.sandbox.directory.openfinance.ae/logos/73423662-b345-453e-a54b-2f9115a6a45d/softwarestatements/1a703edb-b138-4fae-99aa-8348d418f296.png",
    title: String,
    description: String,
    imageUrl: String = "https://dummyimage.com/600x400/a356a3/0011ff",
    trailingIcon: Int
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                CustomImage(
                    modifier = Modifier.size(40.dp),
                    properties = ImageUiDataModel(src = profileUrl)
                )
                Spacer(Modifier.width(8.dp))
                CustomText(
                    properties = TextUiDataModel(
                        text = title,
                        textStyle = Style14CaptionRegular
                    )
                )
                Spacer(Modifier.weight(1f))
                CustomImage(
                    modifier = Modifier.size(24.dp),
                    properties = ImageUiDataModel(src = trailingIcon)
                )
            }
            Spacer(Modifier.height(8.dp))
            CustomImage(
                modifier = Modifier.fillMaxWidth(),
                properties = ImageUiDataModel(src = imageUrl, contentScale = ContentScale.FillBounds)
            )
            Spacer(Modifier.height(8.dp))
            CustomText(
                properties = TextUiDataModel(
                    text = description,
                    textStyle = Style14CaptionRegular
                )
            )
        }
    }
}