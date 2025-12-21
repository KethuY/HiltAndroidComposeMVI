package com.kethu.raj.forgotpwd

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kethu.raj.auth.R
import com.kethu.raj.navigation.SignIn
import com.kethu.raj.signup.defaultWidth
import com.kethu.raj.template.AuthScreenTemplate
import com.kethu.raj.uikit.components.molecules.buttons.UiButton
import com.kethu.raj.uikit.components.molecules.buttons.properties.ButtonType
import com.kethu.raj.uikit.components.molecules.buttons.uidatamodels.ButtonUiDataModel
import com.kethu.raj.uikit.components.molecules.inputs.textfield.InputUiDataModel
import com.kethu.raj.uikit.components.molecules.inputs.textfield.properties.AdibInputListenersImpl
import com.kethu.raj.uikit.ui.theme.Dimens.SizeRadiusXSmall
import com.kethu.raj.uikit.utils.ShapeRoundedXSmall
import com.kethu.uikit.components.molecules.inputs.textfield.UiInputTextField

@Composable
fun ForgotPasswordScreen(navController: NavHostController) {
    AuthScreenTemplate {

        var enterCode by remember { androidx.compose.runtime.mutableStateOf("") }
        UiInputTextField(
            modifier = Modifier.defaultWidth(),
            properties = InputUiDataModel(
                prefix = R.drawable.ic_user,
                hint = stringResource(R.string.auth_hint_username),
                text = enterCode
            ),
            listeners = AdibInputListenersImpl(onValueChange = {
                enterCode = it
            })
        )

        UiButton(
            modifier = Modifier
                .defaultWidth()
                .padding(top = SizeRadiusXSmall.dp),
            properties = ButtonUiDataModel(
                text = stringResource(R.string.auth_send),
                type = ButtonType.SECONDARY,
                shape = ShapeRoundedXSmall
            ), onClick = {
                navController.navigate(SignIn)
            })
    }
}