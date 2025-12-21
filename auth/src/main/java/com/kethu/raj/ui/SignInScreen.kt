package com.kethu.raj.ui

import android.app.Activity
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.kethu.raj.AuthEvent
import com.kethu.raj.AuthUiState
import com.kethu.raj.auth.R
import com.kethu.raj.template.AuthScreenTemplate
import com.kethu.raj.uikit.components.atoms.CustomText
import com.kethu.raj.uikit.components.molecules.buttons.UiButton
import com.kethu.raj.uikit.components.molecules.buttons.properties.ButtonType
import com.kethu.raj.uikit.components.molecules.buttons.uidatamodels.ButtonUiDataModel
import com.kethu.raj.uikit.components.molecules.inputs.textfield.InputUiDataModel
import com.kethu.raj.uikit.components.molecules.inputs.textfield.UiInputTextField
import com.kethu.raj.uikit.components.molecules.inputs.textfield.properties.AdibInputListenersImpl
import com.kethu.raj.uikit.ui.theme.Dimens.SizeSpacingSmall
import com.kethu.raj.uikit.ui.theme.LocalAppUiTheme
import com.kethu.raj.uikit.ui.theme.Style16BodyRegular
import com.kethu.raj.uikit.utils.ShapeRoundedXSmall
import com.kethu.uikit.components.atoms.uidatamodels.TextUiDataModel
import com.raj.kethu.base.BaseApp

@Composable
fun SignInScreen(
    onAction: (AuthEvent) -> Unit,
    uiState: State<AuthUiState>,
    onSignUp: () -> Unit,
    onForgotPwd: () -> Unit
) {
    AuthScreenTemplate(
        isLoginScreen = true,
        onSignUpClick = onSignUp,
    ) {
        var userName by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val context = LocalContext.current

        UiInputTextField(
            modifier = Modifier.defaultWidth(),
            properties = InputUiDataModel(
                prefix = R.drawable.ic_user,
                hint = stringResource(R.string.auth_hint_username),
                text = userName,
                inputLength = 30,
                regex = Regex(BaseApp.getAppContext().getString(com.raj.kethu.base.R.string.regex_alphabets_with_spaces)),
                keyboardOptions = KeyboardOptions.Default.copy(
                    autoCorrectEnabled = false,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            ),
            listeners = AdibInputListenersImpl(onValueChange = {
                userName = it
            })
        )

        UiInputTextField(
            modifier = Modifier
                .defaultWidth()
                .padding(top = SizeSpacingSmall.dp),
            properties = InputUiDataModel(
                prefix = R.drawable.ic_pwd,
                hint = stringResource(R.string.auth_hint_password),
                text = password,
                inputLength = 15,
                keyboardOptions = KeyboardOptions.Default.copy(
                    autoCorrectEnabled = false,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                regex = Regex(BaseApp.getAppContext().getString(com.raj.kethu.base.R.string.regex_special_chars)),
                visualTransformation = PasswordVisualTransformation()
            ),
            listeners = AdibInputListenersImpl(onValueChange = {
                password = it
            })
        )
        UiButton(
            modifier = Modifier
                .defaultWidth()
                .padding(top = SizeSpacingSmall.dp),
            properties = ButtonUiDataModel(
                text = stringResource(R.string.auth_login),
                type = ButtonType.SECONDARY,
                shape = ShapeRoundedXSmall
            ), onClick = {
                onAction(AuthEvent.SignIn(userName, password))
            })

        Box(
            modifier = Modifier
                .defaultWidth()                     // match inputs & button width
                .align(Alignment.CenterHorizontally) // center the whole block
                .padding(top = SizeSpacingSmall.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            CustomText(
                modifier = Modifier
                    .pointerInput(Unit) {
                        detectTapGestures(onTap = {
                            onForgotPwd.invoke()
                        })
                    },
                properties = TextUiDataModel(
                    text = stringResource(R.string.auth_forgot_pwd),
                    textStyle = Style16BodyRegular.copy(LocalAppUiTheme.current.backgroundColor)
                )
            )
        }

        when {
            uiState.value.isApiSuccess -> (context as? Activity)?.finishAffinity()
            uiState.value.isLoading -> CircularProgressIndicator(color = Color.Blue)
        }
    }
}