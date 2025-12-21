package com.kethu.raj.data.repository


interface UserRepository {
    suspend fun addUser(userName: String, password: String, email: String)

   /* suspend fun updateUser(user: UserUiModel)

    suspend fun deleteUser(id: String)

    fun getUser(id: String): UserUiModel

    fun getAllUsers(): List<UserUiModel>

    fun verifyUser(email: String, password: String): Flow<Result<Boolean>>*/
}