package com.kethu.raj.navaigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kethu.raj.home.DashboardScreen

@Composable
fun DashboardNavHost(
    modifier: Modifier = Modifier,
    startDestination: HomePage = HomePage,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable<HomePage> {
            DashboardScreen()
        }

        composable<Profile> {
        }

        composable<Chat> {
        }

        composable<Community> {
        }

        composable<Premium> {
        }

        composable<Bookmarks> {
        }

        composable<List> {
        }

        composable<Spaces> {
        }

        composable<FollowUs> {
        }
    }
}