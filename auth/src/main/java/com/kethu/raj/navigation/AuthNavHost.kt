package com.kethu.raj.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kethu.raj.AuthViewModel
import com.kethu.raj.ui.CreateAccountScreen
import com.kethu.raj.ui.ForgotPasswordScreen
import com.kethu.raj.ui.SignInScreen
import com.kethu.raj.ui.SignUpScreen


@Composable
fun AuthNavHost(
    viewModel: AuthViewModel, // sharedViewModel
    modifier: Modifier = Modifier,
    isNewUser: Boolean = true,
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = if (isNewUser) CreateNewAccount else SignIn,
        modifier = modifier
    ) {
        composable<CreateNewAccount> {
            CreateAccountScreen(onSignIn = {
                navController.navigate(SignIn)
            }, onSignUp = {
                navController.navigate(SignUp)
            })
        }

        composable<SignIn> {
            val uiState = viewModel.state.collectAsStateWithLifecycle()
            SignInScreen(
                viewModel::onAction,
                uiState = uiState, onSignUp = {
                    navController.navigate(SignUp)
                }, onForgotPwd = {
                    navController.navigate(ForgotPassword)
                })
        }

        composable<SignUp> {
            val uiState = viewModel.state.collectAsStateWithLifecycle()
            SignUpScreen(viewModel::onAction, uiState)
        }

        composable<ForgotPassword> {
            val uiState = viewModel.state.collectAsStateWithLifecycle()
            ForgotPasswordScreen(viewModel::onAction, uiState) {
                navController.popBackStack()
            }
        }
    }
}