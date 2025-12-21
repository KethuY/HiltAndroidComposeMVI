package com.kethu.raj.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kethu.raj.createaccount.CreateAccountScreen
import com.kethu.raj.forgotpwd.ForgotPasswordScreen
import com.kethu.raj.signIn.SignInScreen
import com.kethu.raj.signIn.SignInViewModel
import com.kethu.raj.signup.SignUpScreen
import com.kethu.raj.signup.SignUpViewModel


@Composable
fun UserNavHost(
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
            CreateAccountScreen(navController)
        }

        composable<SignIn> {
            val viewModel = hiltViewModel<SignInViewModel>()
            val uiState = viewModel.state.collectAsStateWithLifecycle()
            SignInScreen(navController, viewModel::onAction, uiState)
        }

        composable<SignUp> {
            val viewModel = hiltViewModel<SignUpViewModel>()
            val uiState = viewModel.state.collectAsStateWithLifecycle()
            SignUpScreen(viewModel::onAction, uiState)
        }

        composable<ForgotPassword> {
            ForgotPasswordScreen(navController)
        }
    }
}