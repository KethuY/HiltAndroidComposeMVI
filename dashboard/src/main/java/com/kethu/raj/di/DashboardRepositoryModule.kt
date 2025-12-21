package com.kethu.raj.di

import com.kethu.raj.networkmodule.client.NetworkDataSource
import com.kethu.raj.repo.TodoRepository
import com.kethu.raj.repo.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Author: Yerramma Kethu
 * @Date: 22/12/2025
 */
@Module
@InstallIn(SingletonComponent::class)
object DashboardRepositoryModule {
    @Singleton
    @Provides
    fun providePostRepository(dataSource: NetworkDataSource): TodoRepository =
        TodoRepositoryImpl(dataSource)
}