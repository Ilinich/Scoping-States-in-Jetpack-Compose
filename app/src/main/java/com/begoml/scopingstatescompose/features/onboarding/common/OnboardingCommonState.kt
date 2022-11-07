package com.begoml.scopingstatescompose.features.onboarding.common

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.begoml.scopingstatescompose.core.ApiService

class OnboardingCommonState constructor(
    private val apiService: ApiService,
) {

    var uiState by mutableStateOf(OnboardingUiState())
        private set

    fun startOnboarding() {
        uiState = uiState.copy(startedOnboarding = true)
    }
}
