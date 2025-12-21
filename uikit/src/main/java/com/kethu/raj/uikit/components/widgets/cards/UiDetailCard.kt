package com.kethu.raj.uikit.components.widgets.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.kethu.raj.uikit.components.atoms.CustomImage
import com.kethu.raj.uikit.components.atoms.CustomText
import com.kethu.raj.uikit.components.atoms.uidatamodels.ImageUiDataModel
import com.kethu.raj.uikit.components.molecules.footer.VerticaItems
import com.kethu.raj.uikit.components.widgets.cards.properties.DetailCardProperties
import com.kethu.raj.uikit.ui.theme.Style14CaptionRegular
import com.kethu.uikit.components.atoms.uidatamodels.TextUiDataModel

/**
 * @Author: Yerramma Kethu
 * @Date: 21/12/2025
 */
@Composable
fun UiDetailCard(
    properties: DetailCardProperties,
    modifier: Modifier = Modifier
) {
    with(properties) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = modifier,
            colors = CardDefaults.cardColors(containerColor = backgroundColor)
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
                            text = profileName,
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
                Box {
                    CustomImage(
                        modifier = Modifier.fillMaxWidth(),
                        properties = ImageUiDataModel(
                            src = imageUrl,
                            contentScale = ContentScale.FillBounds
                        )
                    )
                    if (shareIcons.isNotEmpty()) {
                        VerticaItems(
                            modifier = Modifier
                                .padding(horizontal = 12.dp, vertical = 12.dp)
                                .align(Alignment.BottomEnd), shareIcons
                        )
                    }

                }
                Spacer(Modifier.height(8.dp))
                CustomText(
                    properties = TextUiDataModel(
                        text = description,
                        textStyle = Style14CaptionRegular
                    )
                )
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomImage(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .size(24.dp),
                            properties = ImageUiDataModel(src = trailingIcon)
                        )

                        CustomText(
                            properties = TextUiDataModel(
                                text = "Comments",
                                textStyle = Style14CaptionRegular
                            )
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomText(
                            properties = TextUiDataModel(
                                text = "Likes",
                                textStyle = Style14CaptionRegular
                            )
                        )
                        CustomImage(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .size(24.dp),
                            properties = ImageUiDataModel(src = trailingIcon)
                        )
                    }
                }
            }
        }
    }
}