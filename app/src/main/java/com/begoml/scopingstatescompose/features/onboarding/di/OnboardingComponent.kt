package com.begoml.scopingstatescompose.features.onboarding.di

import com.begoml.scopingstatescompose.core.ApiService
import com.begoml.scopingstatescompose.di.AppProvider
import com.begoml.scopingstatescompose.features.onboarding.common.OnboardingCommonState
import com.begoml.scopingstatescompose.features.onboarding.common.OnboardingViewModel
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Component(
    dependencies = [AppProvider::class],
    modules = [OnboardingModule::class],
)
@Singleton
interface OnboardingComponent {

    val viewModel: OnboardingViewModel

    fun provideOnboardingCommonState(): OnboardingCommonState
}

@Module
class OnboardingModule {

    @Singleton
    @Provides
    fun provideOnboardingCommonState(
        apiService: ApiService,
    ) = OnboardingCommonState(
        apiService = apiService,
    )
}
