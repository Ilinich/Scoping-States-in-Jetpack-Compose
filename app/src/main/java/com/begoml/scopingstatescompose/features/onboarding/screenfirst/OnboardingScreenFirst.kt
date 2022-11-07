package com.begoml.scopingstatescompose.features.onboarding.screenfirst

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.begoml.scopingstatescompose.features.onboarding.common.OnboardingViewModel
import com.begoml.scopingstatescompose.navigation.Onboarding

@Composable
fun OnboardingScreenFirst(
    navController: NavController,
    viewModel: OnboardingViewModel,
) {
    val uiState = viewModel.uiState

    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = "Second Screen: startedOnboarding=${uiState.startedOnboarding}"
        )
        Button(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            onClick = {
                viewModel.onStartOnboarding()
                navController.navigate(Onboarding.ScreenSecond.destination)
            }) {
            Text("Next")
        }
    }
}
