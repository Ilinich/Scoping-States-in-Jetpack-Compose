package com.begoml.scopingstatescompose.features.common

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.begoml.scopingstatescompose.navigation.rememberBackStackEntry

interface FeatureComponentHolder<C : Any> {

    val featureRoute: String

    @Composable
    fun featureComponent(
        currentEntry: NavBackStackEntry,
        navController: NavController,
        arguments: Bundle?
    ) = featureComponent(
        rootEntry = currentEntry.rememberBackStackEntry(navController, route = featureRoute),
        arguments = arguments
    )

    @Composable
    fun featureComponent(
        rootEntry: NavBackStackEntry,
        arguments: Bundle?
    ): C
}
