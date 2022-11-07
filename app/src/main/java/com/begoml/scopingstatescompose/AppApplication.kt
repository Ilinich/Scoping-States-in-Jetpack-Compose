package com.begoml.scopingstatescompose

import android.app.Application
import com.begoml.scopingstatescompose.di.AppProvider
import com.begoml.scopingstatescompose.di.DaggerAppComponent

class AppApplication : Application() {

    lateinit var appProvider: AppProvider
        private set

    override fun onCreate() {
        super.onCreate()

        appProvider = DaggerAppComponent.builder()
            .build()
    }
}


val Application.appProvider: AppProvider
    get() = (this as AppApplication).appProvider
