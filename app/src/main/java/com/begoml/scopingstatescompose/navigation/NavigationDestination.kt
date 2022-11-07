package com.begoml.scopingstatescompose.navigation

sealed class NavigationDestination(open val destination: String) {

    object Login : NavigationDestination("login")

    object Home : NavigationDestination("home")
}

sealed class Onboarding(override val destination: String) : NavigationDestination(destination) {

    object Route : Onboarding("onboarding")

    object ScreenFirst : Onboarding("onboardingscreenfirst")

    object ScreenSecond : Onboarding("onboardingscreensecond")
}
