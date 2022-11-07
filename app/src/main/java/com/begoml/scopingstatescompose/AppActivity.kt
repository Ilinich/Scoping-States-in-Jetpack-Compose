package com.begoml.scopingstatescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.begoml.scopingstatescompose.di.LocalAppProvider
import com.begoml.scopingstatescompose.features.home.HomeScreen
import com.begoml.scopingstatescompose.features.login.LoginScreen
import com.begoml.scopingstatescompose.features.onboarding.common.OnboardingEntry
import com.begoml.scopingstatescompose.navigation.NavigationDestination
import com.begoml.scopingstatescompose.ui.theme.AppTheme

class AppActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CompositionLocalProvider(
                        LocalAppProvider provides application.appProvider,
                    ) {
                        val navController = rememberNavController()

                        val onboardingEntry = OnboardingEntry()

                        NavHost(navController, startDestination = NavigationDestination.Login.destination) {
                            composable(NavigationDestination.Login.destination) {
                                LoginScreen(navController)
                            }

                            composable(NavigationDestination.Home.destination) {
                                HomeScreen(navController)
                            }

                            with(onboardingEntry) {
                                navigation(navController)
                            }
                        }
                    }
                }
            }
        }
    }
}
