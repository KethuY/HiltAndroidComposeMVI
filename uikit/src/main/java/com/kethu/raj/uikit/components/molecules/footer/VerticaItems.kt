package com.kethu.raj.uikit.components.molecules.footer

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.kethu.raj.uikit.components.atoms.CustomImage
import com.kethu.raj.uikit.components.atoms.uidatamodels.ImageUiDataModel

@Composable
fun VerticaItems(
    modifier: Modifier = Modifier,
    icons: List<Int>,     // pass your real icons here
    onClick: (Int) -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        icons.forEach { iv ->
            CustomImage(
                modifier = Modifier
                    .size(24.dp)
                    .pointerInput(Unit) {
                        detectTapGestures(onTap = {
                            onClick.invoke(iv)
                        })
                    }, properties = ImageUiDataModel(
                    src = iv,
                    colorFilter = ColorFilter.tint(Color.White)
                )
            )
        }
    }
}