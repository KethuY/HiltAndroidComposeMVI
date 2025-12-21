package com.kethu.raj.repo

import com.kethu.raj.networkmodule.client.ApiBaseResponse
import com.kethu.raj.networkmodule.client.Resource
import com.kethu.raj.repo.models.ForgotPwdRequest
import com.kethu.raj.repo.models.SignInRequest
import com.kethu.raj.repo.models.SignUpRequest
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun signUp(
      signUpRequest: SignUpRequest
    ): Flow<Resource<ApiBaseResponse>> // return type need to update

    fun signIn(
       signInRequest: SignInRequest
    ): Flow<Resource<ApiBaseResponse>> // return type need to update

    fun resetPassword(forgotPwdRequest: ForgotPwdRequest): Flow<Resource<ApiBaseResponse>> // return type need to update
}