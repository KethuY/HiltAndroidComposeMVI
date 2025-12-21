package com.kethu.raj.createaccount

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kethu.raj.auth.R
import com.kethu.raj.navigation.SignIn
import com.kethu.raj.navigation.SignUp
import com.kethu.raj.signup.defaultWidth
import com.kethu.raj.uikit.components.molecules.buttons.UiButton
import com.kethu.raj.uikit.components.molecules.buttons.properties.ButtonType
import com.kethu.raj.uikit.components.molecules.buttons.uidatamodels.ButtonUiDataModel
import com.kethu.raj.template.AuthScreenTemplate
import com.kethu.raj.uikit.ui.theme.Dimens.SizeSpacingSmall
import com.raj.kethu.CommonConstants

@Composable
fun CreateAccountScreen(navController: NavHostController) {
    AuthScreenTemplate {
        UiButton(
            modifier = Modifier.defaultWidth(),
            properties = ButtonUiDataModel(text = stringResource(R.string.auth_create_account)),
            onClick = {
                navController.navigate(SignUp)
            })
        Spacer(Modifier.height(SizeSpacingSmall.dp))
        UiButton(
            modifier = Modifier.defaultWidth(),
            properties = ButtonUiDataModel(
                text = stringResource(R.string.auth_login), type = ButtonType.SECONDARY
            ), onClick = {
                navController.navigate(SignIn)
            })
    }
}