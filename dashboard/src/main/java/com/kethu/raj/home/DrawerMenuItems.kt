package com.kethu.raj.home

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
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kethu.raj.dashboard.R
import com.kethu.raj.data.models.getDrawerMenuItems
import com.kethu.raj.uikit.components.atoms.CustomImage
import com.kethu.raj.uikit.components.atoms.CustomText
import com.kethu.raj.uikit.components.atoms.uidatamodels.ImageUiDataModel
import com.kethu.raj.uikit.components.molecules.toolbar.UiToolbarCustomActions
import com.kethu.raj.uikit.ui.theme.ColorBannersInfoBg
import com.kethu.raj.uikit.ui.theme.LocalAppUiTheme
import com.kethu.raj.uikit.ui.theme.Style14CaptionRegular
import com.kethu.raj.uikit.ui.theme.Style16BodyRegular
import com.kethu.raj.uimodels.ToolbarUiDataModel
import com.kethu.uikit.components.atoms.uidatamodels.TextUiDataModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun DrawerMenuItems(
    navController: NavHostController = rememberNavController(),
    content: @Composable (PaddingValues) -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(drawerContainerColor = LocalAppUiTheme.current.backgroundColor) {
                Column(
                    modifier = Modifier
                        .width(250.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(Modifier.height(24.dp))
                    ProfileIconSection {
                        // todo handle navigation
                        handleDrawerState(scope, drawerState)
                    }
                    Spacer(Modifier.height(16.dp))
                    FollowUsSection {
                        // todo handle navigation
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
                                        colorFilter = ColorFilter.tint(Color.White)
                                    )
                                )
                            },
                            label = {
                                CustomText(
                                    properties = TextUiDataModel(
                                        text = item.title,
                                        textStyle = Style16BodyRegular.copy(color = Color.White)
                                    )
                                )
                            },
                            selected = false,
                            onClick = {
                                // todo handle navigation
                                handleDrawerState(scope, drawerState)
                            }
                        )
                    }
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
                    properties = ToolbarUiDataModel(stringResource(R.string.dash_connect)),
                    onBackClick = {
                        scope.launch {
                            if (drawerState.isClosed) {
                                drawerState.open()
                            } else {
                                drawerState.close()
                            }
                        }
                    },
                    actions = {
                        MenuItems(onSearchIcon = {
                            // Handle search icon click
                        }, onNotificationIcon = {
                            // Handle notification icon click
                        }, onLogoutIcon = {
                            // Handle logout icon click
                        })
                    }
                )
            }
        ) { innerPadding ->
            content(innerPadding)
        }
    }
}

fun handleDrawerState(
    scope: CoroutineScope,
    drawerState: androidx.compose.material3.DrawerState
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
            .padding(end = 8.dp)
            .size(24.dp)
            .plainClick {
                onSearchIcon.invoke()
            },
        properties = ImageUiDataModel(
            src = R.drawable.ic_search,
        )
    )

    CustomImage(
        modifier = Modifier
            .padding(end = 8.dp)
            .size(24.dp)
            .plainClick {
                onNotificationIcon.invoke()
            },
        properties = ImageUiDataModel(
            src = R.drawable.ic_noti,
        )
    )
    CustomImage(
        modifier = Modifier
            .size(24.dp)
            .plainClick {
                onLogoutIcon.invoke()
            },
        properties = ImageUiDataModel(
            src = R.drawable.ic_log,
        )
    )
}

@Composable
private fun ProfileIconSection(onProfileIconClick: () -> Unit = {}) {
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
    Row(modifier = Modifier.plainClick(onClick)) {
        Spacer(Modifier.width(16.dp))
        CustomImage(
            modifier = Modifier
                .size(24.dp),
            properties = ImageUiDataModel(
                src = R.drawable.ic_log,
                colorFilter = ColorFilter.tint(Color.White)
            )
        )
        CustomText(
            properties = TextUiDataModel(
                text = "Follow us",
                textStyle = Style16BodyRegular.copy(Color.White)
            )
        )
    }
}

private fun Modifier.plainClick(onClick: () -> Unit): Modifier = this.pointerInput(Unit) {
    detectTapGestures(onTap = {
        onClick.invoke()
    })
}