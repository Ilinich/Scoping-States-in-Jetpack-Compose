package com.begoml.scopingstatescompose.di

import androidx.compose.runtime.compositionLocalOf
import com.begoml.scopingstatescompose.core.ApiService

interface AppProvider {

    fun provideApiService(): ApiService
}

val LocalAppProvider = compositionLocalOf<AppProvider> { error("No app provider found!") }
