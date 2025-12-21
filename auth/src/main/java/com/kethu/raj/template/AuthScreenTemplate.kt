package com.kethu.raj.template

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kethu.raj.auth.R
import com.kethu.raj.uikit.components.atoms.BottomWave
import com.kethu.raj.uikit.components.atoms.TopWave
import com.kethu.raj.uikit.components.atoms.UiSpannableText
import com.kethu.raj.uikit.components.atoms.uidatamodels.SpannableTexUiDataModel
import com.kethu.raj.uikit.components.molecules.footer.FooterItems
import com.kethu.raj.uikit.ui.theme.LocalAppUiTheme
import com.kethu.raj.uikit.ui.theme.Orange
import com.kethu.raj.uikit.ui.theme.OrangeDark
import com.kethu.raj.uikit.ui.theme.OrangeLight
import com.kethu.raj.uikit.ui.theme.Style14CaptionRegular
import com.kethu.raj.uikit.utils.toAnnotatedString
import com.raj.kethu.CommonConstants.getSocialMediaInfo
import com.raj.kethu.models.SocialMediaData
import com.raj.kethu.utils.IntentUtils

/**
 * @Author: Yerramma Kethu
 * @Date: 19/12/2025
 */

@Composable
fun AuthScreenTemplate(
    modifier: Modifier = Modifier,
    topColors: List<Color> = listOf(Orange, OrangeDark),
    topBtmColors: List<Color> = listOf(OrangeLight, Orange),
    bottomColors: List<Color> = listOf(OrangeLight, Orange),
    footerIcons: List<SocialMediaData> = getSocialMediaInfo(),
    topHeight: Dp = 220.dp,
    bottomHeight: Dp = 120.dp,
    bottomGap: Dp = 56.dp,
    isLoginScreen: Boolean = false,
    onSignUpClick: () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        TopWave(
            modifier = Modifier
                .fillMaxWidth()
                .height(topHeight)
                .align(Alignment.TopCenter),
            topColors = topColors,
            bottomColors = topBtmColors
        )
        BottomWave(
            modifier = modifier
                .fillMaxWidth()
                .height(bottomHeight)
                .align(Alignment.BottomCenter),
            colors = bottomColors
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            content()
            Spacer(Modifier.height(bottomGap))
            if (isLoginScreen) {
                UiSpannableText(
                    modifier = Modifier.pointerInput(Unit) {
                        detectTapGestures(onTap = {
                            onSignUpClick.invoke()
                        })
                    },
                    properties = SpannableTexUiDataModel(
                        spannableText = stringResource(
                            R.string.auth_new_user_sign_up
                        ).toAnnotatedString(),
                        textStyle = Style14CaptionRegular.copy(color = LocalAppUiTheme.current.backgroundColor)
                    )
                )
                Spacer(Modifier.height(8.dp))
            }
            val context = LocalContext.current
            if (footerIcons.isNotEmpty()) {
                FooterItems(icons = footerIcons.map { it.icon }, onClick = { icon ->
                    val url = footerIcons.firstOrNull {
                        it.icon == icon
                    }?.url.orEmpty()
                    if (url.isNotEmpty()) {
                        IntentUtils.openAppUsingDeeplink(context, url)
                    }
                })
            }
        }
    }
}
