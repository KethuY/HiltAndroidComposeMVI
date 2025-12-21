package com.kethu.raj.repo

import com.google.gson.reflect.TypeToken
import com.kethu.raj.data.network.Todo
import com.kethu.raj.networkmodule.client.ApiRequestBuilder
import com.kethu.raj.networkmodule.client.NetworkDataSource
import com.kethu.raj.networkmodule.client.Resource
import com.kethu.raj.DashboardApiPaths.TODOS
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author: Yerramma Kethu
 * @Date: 22/12/2025
 */
class TodoRepositoryImpl @Inject constructor(private val dataSource: NetworkDataSource) :
    TodoRepository {

    override fun getTodos(): Flow<Resource<List<Todo>?>> = dataSource.send(
        ApiRequestBuilder.createBasicGetRequest(
            TODOS,
            object : TypeToken<List<Todo>>() {}.type
        )
    )
}