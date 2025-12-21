package com.kethu.raj.uikit.components.molecules.inputs.textfield

import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kethu.raj.uikit.components.molecules.inputs.textfield.properties.InputProperties

/**
 * @Author: Yerramma Kethu
 * @Date: 21/12/2025
 */
class InputUiDataModel(
    override val hint: String?,
    override val text: String,
    override val isBorderInputField: Boolean = true,
    override val prefix: Any?,
    override val visualTransformation: VisualTransformation = VisualTransformation.None,
    override val maxLines: Int = 1,
    override val height: Dp = 40.dp
) : InputProperties