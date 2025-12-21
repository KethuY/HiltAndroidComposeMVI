package com.kethu.raj.navaigation.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kethu.raj.dashboard.R
import com.kethu.raj.ui.ComingSoonScreen
import com.kethu.raj.ui.home.HomeScreen
import com.kethu.raj.ui.home.HomeViewModel
import com.kethu.raj.ui.todos.TodoViewModel
import com.kethu.raj.ui.todos.TodosScreen
import com.raj.kethu.utils.getStringFromRes

@Composable
fun DashboardNavHost(
    modifier: Modifier = Modifier,
    startDestination: Any = HomePage,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable<HomePage> {
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(homeViewModel)
        }

        composable<Profile> {
            ComingSoonScreen(getStringFromRes(R.string.menu_profile))
        }

        composable<Chat> {
            ComingSoonScreen(getStringFromRes(R.string.menu_chat))
        }

        composable<Community> {
            ComingSoonScreen(getStringFromRes(R.string.menu_community))
        }

        composable<Premium> {
            ComingSoonScreen(getStringFromRes(R.string.menu_premium))
        }

        composable<Bookmarks> {
            ComingSoonScreen(getStringFromRes(R.string.menu_bookmarks))
        }

        composable<List> {
            ComingSoonScreen(getStringFromRes(R.string.menu_list))
        }

        composable<Spaces> {
            ComingSoonScreen(getStringFromRes(R.string.menu_spaces))
        }

        composable<FollowUs> {
            ComingSoonScreen(getStringFromRes(R.string.menu_follow_us))
        }

        composable<Todos> {
            val todoViewModel = hiltViewModel<TodoViewModel>()
            TodosScreen(todoViewModel)
        }
    }
}