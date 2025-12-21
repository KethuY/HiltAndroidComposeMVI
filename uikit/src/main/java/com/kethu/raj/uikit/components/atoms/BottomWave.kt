package com.kethu.raj.uikit.components.atoms

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import com.kethu.raj.uikit.ui.theme.Orange
import com.kethu.raj.uikit.ui.theme.OrangeLight

@Composable
fun BottomWave(modifier: Modifier = Modifier, colors: List<Color> = listOf(OrangeLight, Orange)) {
    Canvas(
        modifier = modifier
    ) {
        val w = size.width
        val h = size.height

        val bottomPath = Path().apply {
            moveTo(0f, h * 0.20f)
            quadraticTo(w * 0.25f, h * 0.05f, w * 0.55f, h * 0.45f)
            quadraticTo(w * 0.80f, h * 0.75f, w, h * 0.50f)
            lineTo(w, h)
            lineTo(0f, h)
            close()
        }
        drawPath(
            bottomPath,
            brush = Brush.linearGradient(colors),
            style = Fill
        )
    }
}