package com.raj.kethu.theme

import androidx.compose.ui.graphics.Color
import com.kethu.raj.uikit.ui.theme.AppUiThemeModel
import com.kethu.raj.uikit.ui.theme.ColorInteraction
import com.raj.kethu.theme.ThemeType.ORANGE

/**
 * @Author: Yerramma Kethu
 * @Date: 27/12/2025
 */
object UiThemeHelper {
    private var selectedTheme: AppUiThemeModel = AppUiThemeModel()
    private var selectedThemeType: String = ORANGE.type

    fun getSelectedTheme(): AppUiThemeModel = selectedTheme


    fun setSelectedTheme(theme: String) {
        selectedThemeType = theme
        selectedTheme = if (getThemeType(theme) == ThemeType.BLUE) {
            AppUiThemeModel(
                backgroundColor = ColorInteraction,
                tintColor = ColorInteraction,
                actionColor = ColorInteraction,
                textColor = Color.White,
                secondaryTextColor =  ColorInteraction
            )
        } else {
            AppUiThemeModel()
        }
    }

    fun getSelectedThemeType() = selectedThemeType


    fun getThemeType(theme: String = selectedThemeType) =
        ThemeType.entries.firstOrNull { it.type.equals(theme, true) } ?: ORANGE
}

enum class ThemeType(val type: String) {
    ORANGE("Orange"),
    BLUE("Blue");
}
