package com.kethu.raj.uikit.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class AppUiThemeModel(
    val actionColor: Color = ColorSemanticWarningTwo,
    val backgroundColor: Color = ColorSemanticWarningTwo,
    val tintColor: Color = ColorSemanticWarningTwo,
    val textColor: Color = ColorTextWhite
)

val LocalAppUiTheme = staticCompositionLocalOf { AppUiThemeModel() }