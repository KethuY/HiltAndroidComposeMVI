package com.kethu.raj.uikit.components.atoms.uidatamodels

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kethu.raj.uikit.components.atoms.properties.ImageCardProperties
import com.kethu.raj.uikit.ui.theme.ColorSegmentSurface
import com.kethu.raj.uikit.utils.ShapeRoundedMedium
import com.kethu.raj.uikit.ui.theme.Dimens.SizeSpacingMedium

data class ImageCardUiDataModel(
    override val image: Int,
    override val cardSize: Dp = 48.dp,
    override val paddingValues: PaddingValues = PaddingValues(SizeSpacingMedium.dp),
    override val cardShape: Shape = ShapeRoundedMedium,
    override val isActionCard: Boolean = false,
    override val backgroundColor: Color = ColorSegmentSurface,
    override val iconTintColor: Color = Color.Unspecified,
) : ImageCardProperties