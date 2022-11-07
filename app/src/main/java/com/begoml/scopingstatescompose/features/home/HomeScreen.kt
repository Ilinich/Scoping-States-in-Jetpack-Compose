package com.begoml.scopingstatescompose.features.home

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
import com.begoml.scopingstatescompose.navigation.NavigationDestination
import com.begoml.scopingstatescompose.navigation.navigateSingleTopTo

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = "Login screen"
        )
        Button(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            onClick = {
                navController.navigateSingleTopTo(NavigationDestination.Login.destination)
            }) {
            Text("Logout")
        }
    }
}
