package com.kethu.raj.uikit.components.molecules.buttons

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import com.kethu.raj.uikit.components.atoms.CustomImage
import com.kethu.raj.uikit.components.atoms.CustomText
import com.kethu.uikit.components.atoms.uidatamodels.TextUiDataModel
import com.kethu.raj.uikit.components.atoms.uidatamodels.ImageUiDataModel
import com.kethu.raj.uikit.components.molecules.buttons.properties.ButtonProperties
import com.kethu.raj.uikit.ui.theme.LocalAppUiTheme
import kotlinx.coroutines.delay

/**
 * AdibUiButton - Custom UI button component for Adib Mobile UIKit.
 * Author: Yerramma-Kethu_adib
 * Date: 2024-06-10
 */
@Composable
fun UiButton(
    properties: ButtonProperties,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    with(properties) {
        val tweenAnimation: TweenSpec<Color> = tween(300)
        val (textColor, iconTintColor) = Pair(
            colors.textColor.takeIf { it != Color.Unspecified }
                ?: LocalAppUiTheme.current.textColor,
            colors.iconTintColor.takeIf { it != Color.Unspecified }
                ?: LocalAppUiTheme.current.tintColor

        )
        var isClicked by remember { mutableStateOf(false) }
        val toggleTextColor = animateColorAsState(
            targetValue = if (isClicked) textColor.copy(alpha = 0.6f) else textColor,
            tweenAnimation
        )
        val toggleIconColor = animateColorAsState(
            targetValue = if (isClicked) iconTintColor.copy(alpha = 0.6f) else iconTintColor,
            tweenAnimation
        )
        val toggleBorderColor =
            if (isClicked) colors.borderColor.copy(alpha = 0.6f) else colors.borderColor
        LaunchedEffect(isClicked) {
            if (isClicked) {
                delay(150L)
                onClick.invoke()
                isClicked = false
            }
        }
        val boxModifier = modifier.buttonModifier(
            properties = properties,
            borderColor = toggleBorderColor,
            onClick = { isClicked = true },
            interactionSource = remember { MutableInteractionSource() }
        )
        Box(
            modifier = boxModifier,
            contentAlignment = alignment
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CustomImage(
                    modifier = Modifier
                        .padding(end = iconEndPadding)
                        .size(leadingIconSize),
                    properties = ImageUiDataModel(
                        src = leadingIcon,
                        colorFilter = ColorFilter.tint(toggleIconColor.value)
                    )
                )
                CustomText(
                    properties = TextUiDataModel(
                        text = text,
                        textStyle = textStyle.copy(color = toggleTextColor.value)
                    )
                )
            }
        }
    }
}

private fun Modifier.buttonModifier(
    properties: ButtonProperties,
    borderColor: Color,
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource
) = with(properties) {
    this@buttonModifier
        .height(height)
        .shadow(elevation, shape)
        .clip(shape)
        .background(colors.backgroundColor)
        .border(borderWidth, borderColor, shape)
        .clickable(
            interactionSource = interactionSource,
            indication = if (rippleEnabled) ripple() else null,
            enabled = enable,
            onClick = onClick
        )
        .padding(paddingValues)
}
