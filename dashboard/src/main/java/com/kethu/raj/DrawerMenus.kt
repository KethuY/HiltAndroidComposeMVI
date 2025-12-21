package com.kethu.raj

import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kethu.raj.dashboard.R
import com.kethu.raj.data.uidatamodels.DashboardToolbarUiDataModel
import com.kethu.raj.data.uidatamodels.getDrawerMenuItems
import com.kethu.raj.listeners.DashboardListeners
import com.kethu.raj.navaigation.dashboard.FollowUs
import com.kethu.raj.navaigation.dashboard.Profile
import com.kethu.raj.uikit.components.atoms.CustomImage
import com.kethu.raj.uikit.components.atoms.CustomText
import com.kethu.raj.uikit.components.atoms.uidatamodels.ImageUiDataModel
import com.kethu.raj.uikit.components.molecules.toolbar.UiToolbarCustomActions
import com.kethu.raj.uikit.ui.theme.AppUiThemeModel
import com.kethu.raj.uikit.ui.theme.ColorBannersInfoBg
import com.kethu.raj.uikit.ui.theme.Dimens.WIDTH_250
import com.kethu.raj.uikit.ui.theme.Style14CaptionRegular
import com.kethu.raj.uikit.ui.theme.Style16BodyRegular
import com.kethu.uikit.components.atoms.uidatamodels.TextUiDataModel
import com.raj.kethu.utils.getStringFromRes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun DrawerMenuItems(
    navController: NavHostController,
    viewModel: DashboardViewModel,
    selectedTheme: AppUiThemeModel,
    onClickListeners: DashboardListeners,
    content: @Composable (PaddingValues) -> Unit
) {
    var title by rememberSaveable { mutableStateOf(getStringFromRes(R.string.dash_connect)) }
    var showBack by rememberSaveable { mutableStateOf(false) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(drawerContainerColor = selectedTheme.backgroundColor) {
                Column(
                    modifier = Modifier
                        .width(WIDTH_250.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(Modifier.height(24.dp))
                    ProfileIconSection {
                        showBack = true
                        title = getStringFromRes(R.string.menu_profile)
                        navController.navigate(Profile) {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                        }
                        handleDrawerState(scope, drawerState)
                    }
                    Spacer(Modifier.height(16.dp))
                    FollowUsSection {
                        showBack = true
                        title = getStringFromRes(R.string.menu_follow_us)
                        navController.navigate(FollowUs) {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                        }
                        handleDrawerState(scope, drawerState)
                    }
                    Spacer(Modifier.height(16.dp))
                    getDrawerMenuItems().forEach { item ->
                        NavigationDrawerItem(
                            icon = {
                                CustomImage(
                                    modifier = Modifier.size(24.dp),
                                    properties = ImageUiDataModel(
                                        src = item.iconResId,
                                        colorFilter = ColorFilter.tint(selectedTheme.textColor)
                                    )
                                )
                            },
                            label = {
                                CustomText(
                                    properties = TextUiDataModel(
                                        text = item.title,
                                        textStyle = Style16BodyRegular.copy(color = selectedTheme.textColor)
                                    )
                                )
                            },
                            selected = false,
                            onClick = {
                                showBack = true
                                title = item.title
                                navController.navigate(item.type) {
                                    launchSingleTop = true
                                    restoreState = true
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                }
                                handleDrawerState(scope, drawerState)
                            }
                        )
                    }
                    NavigationDrawerItem(
                        icon = {
                            CustomImage(
                                modifier = Modifier.size(24.dp),
                                properties = ImageUiDataModel(
                                    src = R.drawable.ic_theme,
                                    colorFilter = ColorFilter.tint(selectedTheme.textColor)
                                )
                            )
                        },
                        label = {
                            CustomText(
                                properties = TextUiDataModel(
                                    text = getStringFromRes(R.string.menu_theme_appearance),
                                    textStyle = Style16BodyRegular.copy(color = selectedTheme.textColor)
                                )
                            )
                        },
                        selected = false,
                        onClick = {
                            viewModel.onAction(DashboardEvent.ShowThemeBottomSheet)
                            handleDrawerState(scope, drawerState)
                        }
                    )
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            modifier = Modifier.padding(horizontal = 16.dp),
            containerColor = ColorBannersInfoBg.copy(alpha = 0.2f),
            topBar = {
                UiToolbarCustomActions(
                    properties = DashboardToolbarUiDataModel(
                        title,
                        if (showBack) com.raj.kethu.base.R.drawable.ic_arrow_back else R.drawable.ic_menu
                    ),
                    onBackClick = {
                        if (showBack) {
                            navController.popBackStack()
                            title = getStringFromRes(R.string.dash_connect)
                            showBack = false
                        } else {
                            scope.launch {
                                if (drawerState.isClosed) {
                                    drawerState.open()
                                } else {
                                    drawerState.close()
                                }
                            }
                        }
                    },
                    actions = {
                        if (!showBack) {
                            MenuItems(onSearchIcon = {
                                onClickListeners.onSearchClick.invoke()
                            }, onNotificationIcon = {
                                onClickListeners.onNotificationClick.invoke()
                            }, onLogoutIcon = {
                                onClickListeners.onLogoutClick.invoke()
                            })
                        }
                    }
                )
            }
        ) { innerPadding ->
            content(innerPadding)
        }
    }
}

private fun handleDrawerState(
    scope: CoroutineScope,
    drawerState: DrawerState
) {
    scope.launch {
        if (drawerState.isClosed) {
            drawerState.open()
        } else {
            drawerState.close()
        }
    }
}

@Composable
private fun MenuItems(
    onSearchIcon: () -> Unit,
    onNotificationIcon: () -> Unit,
    onLogoutIcon: () -> Unit
) {
    CustomImage(
        modifier = Modifier
            .padding(end = 16.dp)
            .plainClick(onSearchIcon),
        properties = ImageUiDataModel(
            src = R.drawable.ic_search,
        )
    )

    CustomImage(
        modifier = Modifier
            .padding(end = 16.dp)
            .plainClick(onNotificationIcon),
        properties = ImageUiDataModel(
            src = R.drawable.ic_noti,
        )
    )

    CustomImage(
        modifier = Modifier
            .padding(end = 16.dp)
            .plainClick(onLogoutIcon),
        properties = ImageUiDataModel(
            src = R.drawable.ic_log,
        )
    )
}

@Composable
private fun ProfileIconSection(
    onProfileIconClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier.plainClick(onProfileIconClick),
        horizontalArrangement = Arrangement.Center
    ) {
        CustomImage(
            modifier = Modifier
                .padding(start = 16.dp)
                .size(16.dp),
            properties = ImageUiDataModel(
                src = com.raj.kethu.base.R.drawable.x,
                colorFilter = ColorFilter.tint(Color.White)
            )
        )
        Spacer(Modifier.width(48.dp))
        Column {
            CustomImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .size(60.dp)
                    .border(3.dp, Color.White, shape = RoundedCornerShape(30.dp)),
                properties = ImageUiDataModel(
                    src = "https://data.sandbox.directory.openfinance.ae/logos/73423662-b345-453e-a54b-2f9115a6a45d/softwarestatements/1a703edb-b138-4fae-99aa-8348d418f296.png",
                )
            )
            Spacer(Modifier.height(8.dp))
            CustomText(
                properties = TextUiDataModel(
                    text = "Jhon Do",
                    textStyle = Style14CaptionRegular.copy(Color.White)
                )
            )
        }
    }
}

@Composable
private fun FollowUsSection(onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .padding(start = 32.dp)
            .plainClick(onClick)
    ) {
        CustomImage(
            modifier = Modifier
                .size(14.dp),
            properties = ImageUiDataModel(
                src = R.drawable.ic_log,
                colorFilter = ColorFilter.tint(Color.White)
            )
        )
        CustomText(
            properties = TextUiDataModel(
                text = getStringFromRes(R.string.menu_follow_us),
                textStyle = Style14CaptionRegular.copy(Color.White)
            )
        )
    }
}

private fun Modifier.plainClick(onClick: () -> Unit): Modifier = this.pointerInput(onClick) {
    detectTapGestures(onTap = {
        onClick.invoke()
    })
}