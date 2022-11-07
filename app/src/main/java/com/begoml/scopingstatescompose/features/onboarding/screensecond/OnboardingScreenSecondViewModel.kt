package com.begoml.scopingstatescompose.features.onboarding.screensecond

import androidx.lifecycle.ViewModel
import com.begoml.scopingstatescompose.features.onboarding.common.OnboardingCommonState
import com.begoml.scopingstatescompose.features.onboarding.common.OnboardingUiState

class OnboardingScreenSecondViewModel constructor(
    private val commonState: OnboardingCommonState,
) : ViewModel() {

    val uiState: OnboardingUiState
        get() = commonState.uiState
}
