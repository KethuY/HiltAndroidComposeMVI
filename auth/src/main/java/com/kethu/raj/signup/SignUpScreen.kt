package com.kethu.raj.signup

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.kethu.raj.auth.R
import com.kethu.raj.template.AuthScreenTemplate
import com.kethu.raj.uikit.components.molecules.buttons.UiButton
import com.kethu.raj.uikit.components.molecules.buttons.properties.ButtonType
import com.kethu.raj.uikit.components.molecules.buttons.uidatamodels.ButtonUiDataModel
import com.kethu.raj.uikit.components.molecules.inputs.textfield.InputUiDataModel
import com.kethu.raj.uikit.components.molecules.inputs.textfield.properties.AdibInputListenersImpl
import com.kethu.raj.uikit.ui.theme.Dimens.SizeFontWebCaption
import com.kethu.raj.uikit.ui.theme.Dimens.SizeSpacingSmall
import com.kethu.raj.uikit.utils.ShapeRoundedXSmall
import com.kethu.uikit.components.molecules.inputs.textfield.UiInputTextField

@Composable
fun SignUpScreen(
    onAction: (SignUpEvent) -> Unit,
    uiState: State<SignUpUiState>
) {
    AuthScreenTemplate(
        bottomGap = SizeFontWebCaption.dp,
    ) {
        var userName by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var phone by remember { mutableStateOf("") }
        val context = LocalContext.current

        UiInputTextField(
            modifier = Modifier.defaultWidth(),
            properties = InputUiDataModel(
                prefix = R.drawable.ic_user,
                hint = stringResource(R.string.auth_hint_username),
                text = userName
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
                prefix = R.drawable.ic_round_email_24,
                hint = stringResource(R.string.auth_hint_email),
                text = email
            ),
            listeners = AdibInputListenersImpl(onValueChange = {
                email = it
            })
        )

        UiInputTextField(
            modifier = Modifier
                .defaultWidth()
                .padding(top = SizeSpacingSmall.dp),
            properties = InputUiDataModel(
                prefix = R.drawable.ic_call,
                hint = stringResource(R.string.auth_hint_phone),
                text = phone,
            ),
            listeners = AdibInputListenersImpl(onValueChange = {
                phone = it
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
                text = stringResource(R.string.auth_register),
                type = ButtonType.SECONDARY,
                shape = ShapeRoundedXSmall
            ), onClick = {
                onAction(
                    SignUpEvent.DoSignUp(
                        context,
                        userName = userName,
                        password = password,
                        email = email,
                        phone = phone
                    )
                )
            })

        when {
            uiState.value.isLoading -> CircularProgressIndicator(color = Color.Blue)
            uiState.value.isError -> Toast.makeText(
                context,
                "Enter All fields",
                Toast.LENGTH_SHORT
            ).show()

            uiState.value.isSignUpSuccess -> (context as? Activity)?.finishAffinity()
        }
    }
}


internal fun Modifier.defaultWidth(): Modifier = this
    .width(250.dp)