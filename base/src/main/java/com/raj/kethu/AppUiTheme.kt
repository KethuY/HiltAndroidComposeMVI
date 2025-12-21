package com.raj.kethu

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.kethu.raj.uikit.ui.theme.AppUiThemeModel
import com.kethu.raj.uikit.ui.theme.LocalAppUiTheme

@Composable
fun AppUiTheme(
    uiTheme: AppUiThemeModel = getDefaultUiTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalAppUiTheme provides uiTheme) {
        content()
    }
}

private fun getDefaultUiTheme() = AppUiThemeModel()