package com.kethu.raj.repo

import com.google.gson.reflect.TypeToken
import com.kethu.raj.networkmodule.client.ApiRequestBuilder
import com.kethu.raj.networkmodule.client.ApiBaseResponse
import com.kethu.raj.networkmodule.client.NetworkDataSource
import com.kethu.raj.networkmodule.client.Resource
import com.kethu.raj.repo.models.ForgotPwdRequest
import com.kethu.raj.repo.models.SignInRequest
import com.kethu.raj.repo.models.SignUpRequest
import com.raj.kethu.utils.getJsonString
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author: Yerramma Kethu
 * @Date: 27/12/2025
 */
class AuthRepositoryImpl @Inject constructor(private val dataSource: NetworkDataSource) :
    AuthRepository {
    override fun signUp(
        signUpRequest: SignUpRequest
    ): Flow<Resource<ApiBaseResponse>> = dataSource.send(
        ApiRequestBuilder.createBasicPostRequest(
            "signUp",// need to keep actual
            object : TypeToken<ApiBaseResponse>() {}.type
        ).apply {
            setBody(getJsonString(signUpRequest))
        }
    )

    override fun signIn(
        signInRequest: SignInRequest
    ): Flow<Resource<ApiBaseResponse>> = dataSource.send(
        ApiRequestBuilder.createBasicPostRequest(
            "signIn",// need to keep actual
            object : TypeToken<ApiBaseResponse>() {}.type
        ).apply {
            setBody(getJsonString(signInRequest))
        }
    )

    override fun resetPassword(forgotPwdRequest: ForgotPwdRequest): Flow<Resource<ApiBaseResponse>> =
        dataSource.send(
            ApiRequestBuilder.createBasicPostRequest(
                "resetPassword",// need to keep actual
                object : TypeToken<ApiBaseResponse>() {}.type
            ).apply {
                setBody(getJsonString(forgotPwdRequest))
            }
        )
}