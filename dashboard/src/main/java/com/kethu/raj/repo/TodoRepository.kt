package com.kethu.raj.repo

import com.kethu.raj.data.network.Todo
import com.kethu.raj.networkmodule.client.Resource
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getTodos(): Flow<Resource<List<Todo>?>>
}