package com.begoml.scopingstatescompose.di

import com.begoml.scopingstatescompose.core.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule {

    @Singleton
    @Provides
    fun provideApiService() = ApiService()
}
