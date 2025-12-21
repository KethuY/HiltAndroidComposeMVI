package com.kethu.raj

import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kethu.raj.home.DrawerMenuItems
import com.kethu.raj.navaigation.DashboardNavHost
import com.raj.kethu.BaseComposeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : BaseComposeActivity<DashboardViewModel>() {

    override val viewModel: DashboardViewModel by viewModels()

    @Composable
    override fun ActivityContent() {
        DrawerMenuItems { paddingValues ->
            DashboardNavHost(modifier = Modifier.padding(paddingValues))
        }
    }
}
