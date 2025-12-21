package com.kethu.raj

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.compose.rememberNavController
import com.kethu.raj.listeners.DashboardListenersImpl
import com.kethu.raj.navaigation.dashboard.DashboardNavHost
import com.kethu.raj.navaigation.dashboard.HomePage
import com.kethu.raj.networkmodule.client.ErrorResponse
import com.kethu.raj.uikit.components.atoms.CustomText
import com.kethu.raj.uikit.components.layouts.UiModelBottomSheet
import com.kethu.raj.uikit.ui.theme.Style16BodyRegular
import com.kethu.uikit.components.atoms.uidatamodels.TextUiDataModel
import com.raj.kethu.BaseComposeActivity
import com.raj.kethu.UiError
import com.raj.kethu.base.R
import com.raj.kethu.theme.ThemeType
import com.raj.kethu.theme.UiThemeHelper
import com.raj.kethu.ui.NetworkErrorDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardActivity : BaseComposeActivity<DashboardViewModel>() {

    override val viewModel: DashboardViewModel by viewModels()

    @Composable
    override fun ActivityContent() {
        var showThemBottomSheet by rememberSaveable { mutableStateOf(false) }
        var showErrorDialog by rememberSaveable { mutableStateOf<ErrorResponse?>(null) }
        var selectedTheme by rememberSaveable { mutableStateOf(UiThemeHelper.getSelectedTheme()) }
        val navController = rememberNavController()
        DrawerMenuItems(
            navController = navController,
            viewModel = viewModel,
            selectedTheme = selectedTheme,
            onClickListeners = DashboardListenersImpl(
                onLogoutClick = {
                    viewModel.onAction(DashboardEvent.LogoutUser)
                    finish()
                }
            )
        ) { paddingValues ->
            DashboardNavHost(
                modifier = Modifier.padding(paddingValues),
                navController = navController
            )
        }
        val lifecycleOwner = LocalLifecycleOwner.current
        LaunchedEffect(key1 = lifecycleOwner) {
            launch {
                viewModel.uiEffect.collect { effect ->
                    when (effect) {
                        is DashboardUiEffect.ShowThemBottomSheet -> {
                            showThemBottomSheet = true
                        }
                    }
                }
            }

            launch {
                viewModel.uiError.collectLatest { uiError ->
                    when (uiError) {
                        is UiError.ShowErrorDialog -> {
                            showErrorDialog = uiError.error
                        }
                    }
                }
            }
        }

        if (showThemBottomSheet) {
            UiModelBottomSheet(
                title = stringResource(com.kethu.raj.dashboard.R.string.dash_select_them),
                closeIcon = R.drawable.ic_close,
                contentItem = {
                    ThemeSelection { text ->
                        UiThemeHelper.setSelectedTheme(text)
                        selectedTheme = UiThemeHelper.getSelectedTheme()
                        viewModel.onAction(DashboardEvent.SaveTheme(UiThemeHelper.getSelectedThemeType()))
                        showThemBottomSheet = false
                    }
                },
                onDismissRequest = {
                    showThemBottomSheet = false
                })
        }

        showErrorDialog?.let { errorResponse ->
            NetworkErrorDialog(errorResponse, onConfirmButton = {
                showErrorDialog = null
            })
        }
    }

    @Composable
    private fun ThemeSelection(
        modifier: Modifier = Modifier,
        updateTheme: (String) -> Unit
    ) {
        val radioOptions = ThemeType.entries.map { it.type }
        var selectedOption by rememberSaveable { mutableStateOf(UiThemeHelper.getSelectedThemeType()) }
        Column(modifier.selectableGroup()) {
            radioOptions.forEach { text ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = {
                                selectedOption = text
                                updateTheme.invoke(text)
                            },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = null
                    )
                    CustomText(
                        modifier = Modifier.padding(start = 16.dp),
                        properties = TextUiDataModel(text = text, textStyle = Style16BodyRegular)
                    )
                }
            }
        }
    }
}
