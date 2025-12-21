package com.kethu.raj.ui.todos

import com.kethu.raj.data.uidatamodels.TodoUiDataModel
import com.kethu.raj.networkmodule.client.NetworkState
import com.kethu.raj.networkmodule.client.Resource
import com.kethu.raj.networkmodule.client.TransformResponse
import com.kethu.raj.repo.TodoRepository
import com.raj.kethu.ZERO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author: Yerramma Kethu
 * @Date: 22/12/2025
 */
class TodosInteractor @Inject constructor(private val repository: TodoRepository) {
    fun fetchTodos(): Flow<TransformResponse> = repository.getTodos().map { networkResponse ->
        networkResponse.data?.let { todoItems ->
            val todos = todoItems.map { todo ->
                TodoUiDataModel(
                    id = todo.id ?: ZERO,
                    title = todo.title.orEmpty(),
                    isCompleted = todo.completed ?: false,
                    userId = todo.userId ?: ZERO
                )
            }
            Resource.Success(todos, NetworkState.Companion.SUCCESS)
        } ?: networkResponse
    }
}