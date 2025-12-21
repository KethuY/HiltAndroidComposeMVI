package com.kethu.raj.uikit.components.atoms

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import com.kethu.raj.uikit.ui.theme.Orange
import com.kethu.raj.uikit.ui.theme.OrangeDark
import com.kethu.raj.uikit.ui.theme.OrangeLight
import com.kethu.raj.uikit.ui.theme.SurfaceWhite

@Composable
fun TopWave(modifier: Modifier = Modifier, topColors: List<Color> = listOf(Orange, OrangeDark), bottomColors: List<Color> =listOf(OrangeLight, Orange)) {
    Canvas(
        modifier = modifier
             // adjust to taste
    ) {
        val w = size.width
        val h = size.height

        // Background gradient band
        val bgPath = Path().apply {
            moveTo(0f, h * 0.05f)
            quadraticTo(w * 0.25f, 0f, w * 0.5f, h * 0.15f)
            quadraticTo(w * 0.75f, h * 0.30f, w, h * 0.18f)
            lineTo(w, 0f)
            quadraticTo(w * 0.75f, h * 0.30f, w, h * 0.18f)

            lineTo(0f, 0f)
            close()
        }
        drawPath(
            bgPath,
            brush = Brush.linearGradient(topColors),
            style = Fill
        )

        // White highlight stroke-like band
        val whitePath = Path().apply {
            moveTo(0f, h * 0.12f)
            quadraticTo(w * 0.22f, h * 0.06f, w * 0.45f, h * 0.20f)
            quadraticTo(w * 0.70f, h * 0.35f, w, h * 0.22f)
            lineTo(w, h * 0.12f)
            lineTo(0f, h * 0.02f)
            close()
        }
        drawPath(
            whitePath,
            brush = Brush.linearGradient(
                listOf(
                    SurfaceWhite.copy(0.95f),
                    SurfaceWhite.copy(0.65f)
                )
            ),
            style = Fill
        )

        // Solid orange foreground wave
        val wavePath = Path().apply {
            moveTo(0f, h * 0.18f)
            quadraticTo(w * 0.30f, h * 0.05f, w * 0.52f, h * 0.23f)
            quadraticTo(w * 0.78f, h * 0.40f, w, h * 0.22f)
            lineTo(w, h)
            lineTo(0f, h)
            close()
        }
        drawPath(
            wavePath,
            brush = Brush.linearGradient(bottomColors),
            style = Fill
        )
    }
}
