package com.kethu.raj.navaigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController


@Composable
fun UserNavHost(
    modifier: Modifier = Modifier,
    isNewUser: Boolean = true,
    startDestination : HomePage = HomePage,
    navController: NavHostController = rememberNavController(),

) {

    NavHost(
        navController = navController,
        startDestination = HomePage,
        modifier = modifier
    ) {

    }
}