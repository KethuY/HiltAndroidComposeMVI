package com.kethu.raj.networkmodule.di


import com.kethu.raj.networkmodule.client.DefaultDispatcherProvider
import com.kethu.raj.networkmodule.client.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DispatcherModule {

    @Singleton
    @Provides
    fun providesDispatcher(): DispatcherProvider = DefaultDispatcherProvider()
}