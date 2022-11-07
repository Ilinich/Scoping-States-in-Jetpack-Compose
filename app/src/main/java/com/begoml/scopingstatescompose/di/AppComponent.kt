package com.begoml.scopingstatescompose.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CoreModule::class]
)
interface AppComponent : AppProvider
