package com.begoml.scopingstatescompose.features.onboarding.common

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.begoml.scopingstatescompose.di.LocalAppProvider
import com.begoml.scopingstatescompose.features.common.FeatureComponentHolder
import com.begoml.scopingstatescompose.features.common.daggerViewModel
import com.begoml.scopingstatescompose.features.common.rememberScopingState
import com.begoml.scopingstatescompose.features.onboarding.di.DaggerOnboardingComponent
import com.begoml.scopingstatescompose.features.onboarding.di.OnboardingComponent
import com.begoml.scopingstatescompose.features.onboarding.screenfirst.OnboardingScreenFirst
import com.begoml.scopingstatescompose.features.onboarding.screensecond.OnboardingScreenSecond
import com.begoml.scopingstatescompose.features.onboarding.screensecond.OnboardingScreenSecondViewModel
import com.begoml.scopingstatescompose.navigation.Onboarding

class OnboardingEntry : FeatureComponentHolder<OnboardingComponent> {

    override val featureRoute = Onboarding.Route.destination

    fun NavGraphBuilder.navigation(
        navController: NavController,
    ) {
        navigation(
            startDestination = Onboarding.ScreenFirst.destination,
            route = featureRoute,
        ) {
            composable(Onboarding.ScreenFirst.destination) { entry ->
                OnboardingScreenFirst(
                    navController = navController,
                    viewModel = featureComponent(
                        currentEntry = entry,
                        navController = navController,
                        arguments = entry.arguments
                    ).viewModel,
                )
            }
            composable(Onboarding.ScreenSecond.destination) { entry ->
                val rootComponent = featureComponent(
                    currentEntry = entry,
                    navController = navController,
                    arguments = entry.arguments
                )
                val viewModel = daggerViewModel {
                    OnboardingScreenSecondViewModel(
                        commonState = rootComponent.provideOnboardingCommonState()
                    )
                }
                OnboardingScreenSecond(
                    navController = navController,
                    viewModel = viewModel,
                )
            }
        }
    }

    @Composable
    override fun featureComponent(
        rootEntry: NavBackStackEntry,
        arguments: Bundle?
    ): OnboardingComponent {
        val provider = LocalAppProvider.current
        return rememberScopingState(storeOwner = rootEntry) {
            DaggerOnboardingComponent
                .builder()
                .appProvider(provider)
                .build()
        }
    }
}
