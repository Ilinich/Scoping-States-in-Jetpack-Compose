package com.begoml.scopingstatescompose.features.onboarding.common

import androidx.lifecycle.ViewModel
import javax.inject.Inject


data class OnboardingUiState(
    val startedOnboarding: Boolean = false
)

/**
 * Common feature ViewModel.
 */
class OnboardingViewModel @Inject constructor(
    private val commonState: OnboardingCommonState,
) : ViewModel() {

    val uiState: OnboardingUiState
        get() = commonState.uiState

    fun onStartOnboarding() = commonState.startOnboarding()
}
