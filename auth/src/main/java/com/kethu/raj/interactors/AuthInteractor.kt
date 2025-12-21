package com.kethu.raj.interactors

import com.kethu.raj.networkmodule.client.ApiBaseResponse
import com.kethu.raj.networkmodule.client.Resource
import com.kethu.raj.repo.AuthRepository
import com.kethu.raj.repo.models.ForgotPwdRequest
import com.kethu.raj.repo.models.SignInRequest
import com.kethu.raj.repo.models.SignUpRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author: Yerramma Kethu
 * @Date: 27/12/2025
 */
class AuthInteractor @Inject constructor(private val authRepository: AuthRepository) {

    fun doSignUp(
        userName: String,
        password: String,
        email: String,
        phone: String
    ): Flow<Resource<ApiBaseResponse>> = authRepository.signUp(
        SignUpRequest(
            username = userName,
            password = password,
            email = email,
            phone = phone
        )
    )

    fun doSignIn(
        userName: String,
        password: String
    ): Flow<Resource<ApiBaseResponse>> = authRepository.signIn(
        SignInRequest(
            username = userName,
            password = password
        )
    )

    fun resetPassword(enteredCode: String): Flow<Resource<ApiBaseResponse>> =
        authRepository.resetPassword(ForgotPwdRequest(enteredCode = enteredCode))
}