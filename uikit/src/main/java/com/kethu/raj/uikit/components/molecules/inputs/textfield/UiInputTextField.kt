package com.kethu.uikit.components.molecules.inputs.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kethu.raj.uikit.components.atoms.CustomImage
import com.kethu.raj.uikit.components.atoms.uidatamodels.ImageUiDataModel
import com.kethu.raj.uikit.components.molecules.inputs.textfield.BaseInputTextField
import com.kethu.raj.uikit.components.molecules.inputs.textfield.properties.InputListeners
import com.kethu.raj.uikit.components.molecules.inputs.textfield.properties.InputProperties
import com.kethu.raj.uikit.utils.getImage
import com.kethu.raj.uikit.utils.isValidImage
import com.kethu.raj.uikit.ui.theme.Dimens.SizeFontWebCaption
import com.kethu.raj.uikit.ui.theme.Dimens.SizeSpacingLarge

/**
 * Author: Kethu Yerramma
 * Created on: 12-11-2025
 * AdibUiInputTextField is a composable input field with optional suffix action icon.
 *
 * @param properties Configuration for the input field, including validation and suffix.
 * @param listeners Event listeners for input interactions.
 * @param modifier Modifier to be applied to the input field.
 */
@Composable
fun UiInputTextField(
    properties: InputProperties,
    listeners: InputListeners,
    modifier: Modifier = Modifier
) {
    BaseInputTextField(
        modifier = modifier.fillMaxWidth(),
        textInputData = properties,
        prefix = {
            if (properties.prefix.isValidImage()) {
                CustomImage(
                    modifier = Modifier
                        .padding(end = SizeFontWebCaption.dp)
                        .size(SizeSpacingLarge.dp),
                    properties = ImageUiDataModel(src = properties.prefix.getImage())
                )
            }
        },
        listeners = listeners
    )
}


/*

*/
/**
 * AdibUiPhoneInputTextField is a composable for phone number input fields.
 *
 * Displays a prefix hint and a suffix action (icon or text) based on the suffix type.
 *
 * @param properties Configuration for the input field, including prefix and suffix.
 * @param listeners Event listeners for input interactions.
 * @param modifier Modifier to be applied to the input field.
 *//*

@Composable
fun AdibUiPhoneInputTextField(
    properties: InputProperties,
    listeners: InputListeners,
    modifier: Modifier = Modifier
) {
    BaseInputTextField(
        modifier = modifier.fillMaxWidth(),
        textInputData = properties,
        prefix = {
            PrefixHintText(properties.prefix)
        },
        suffix = {
            if (properties.suffix is Int) {
                SuffixActionIcon(properties.suffix, listeners.onSuffixClick)
            } else {
                SuffixActionText(properties.suffix, listeners.onSuffixClick)
            }
        },
        listeners = listeners
    )
}

*/
/**
 * AdibUiSelectInputTextField is a composable for select input fields.
 *
 * Displays a prefix icon (with optional divider) and a suffix action icon for selection.
 *
 * @param properties Configuration for the input field, including prefix, suffix, and divider.
 * @param listeners Event listeners for selection and info icon interactions.
 * @param modifier Modifier to be applied to the input field.
 *//*

@Composable
fun AdibUiSelectInputTextField(
    properties: InputProperties,
    listeners: InputListeners,
    modifier: Modifier = Modifier
) {
    BaseInputTextField(
        modifier = modifier.fillMaxWidth(),
        textInputData = properties,
        prefix = {
            PrefixIcon(properties.prefix, properties.showPrefixDivider)
        },
        suffix = {
            SuffixActionIcon(properties.suffix, listeners.onSelectionClick)
        },
        listeners = AdibInputListenersImpl(
            onSelectionClick = listeners.onSelectionClick,
            onInfoIconClick = listeners.onInfoIconClick
        )
    )
}


@Composable
private fun PrefixIcon(icon: Any?, showPrefixDivider: Boolean) {
    val prefixIcon = icon.getImage()
    if (prefixIcon.isValidImage()) {
        AdibImage(
            AdibImageUiDataModel(
                src = prefixIcon,
                modifier = size(AdibSizeSpacingLarge.dp)
            )
        )
        if (showPrefixDivider) {
            VerticalDivider(
                color = AdibColorBorder,
                modifier = Modifier.padding(horizontal = AdibSizeFontWebCaption.dp)
            )
        } else {
            Spacer(width(AdibSizeFontWebCaption.dp))
        }
    }
}
*/
