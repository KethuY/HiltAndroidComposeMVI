package com.kethu.raj.di

import android.content.Context
import com.raj.kethu.provider.AppDataProvider
import com.kethu.raj.providerimpl.AppDataProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
 object AuthModule {

    @Provides
    @Singleton
    fun provideAppDataProvider(
    ): AppDataProvider = AppDataProviderImpl()

}
