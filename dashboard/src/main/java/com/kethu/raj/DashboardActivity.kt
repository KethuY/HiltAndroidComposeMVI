package com.kethu.raj

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.raj.kethu.BaseComposeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : BaseComposeActivity<DashboardViewModel>() {

    override val viewModel: DashboardViewModel by viewModels()

    @Composable
    override fun ActivityContent() {
        DrawerMenuItems {

        }
    }


}
