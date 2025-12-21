package com.kethu.raj.di

import com.kethu.raj.networkmodule.client.NetworkDataSource
import com.kethu.raj.repo.AuthRepository
import com.kethu.raj.repo.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthRepositoryModule {
    @Singleton
    @Provides
    fun providePostRepository(dataSource: NetworkDataSource): AuthRepository =
        AuthRepositoryImpl(dataSource)
}