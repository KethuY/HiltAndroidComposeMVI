package com.raj.kethu.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.kethu.raj.uikit.ui.theme.AppUiThemeModel
import com.kethu.raj.uikit.ui.theme.LocalAppUiTheme

@Composable
fun AppUiTheme(
    uiTheme: AppUiThemeModel = UiThemeHelper.getSelectedTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalAppUiTheme provides uiTheme) {
        content()
    }
}
