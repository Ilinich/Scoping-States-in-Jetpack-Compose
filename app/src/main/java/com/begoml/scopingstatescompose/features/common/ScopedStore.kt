package com.begoml.scopingstatescompose.features.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel

private class ScopingState<T : Any>(val value: T) : ViewModel()

@Composable
fun <Component : Any> rememberScopingState(
    storeOwner: ViewModelStoreOwner,
    key: String? = null,
    builder: () -> Component
): Component {
    val factory = remember(key) {
        object : ViewModelProvider.Factory {
            override fun <VM : ViewModel> create(modelClass: Class<VM>): VM {
                @Suppress("UNCHECKED_CAST")
                return ScopingState(builder()) as VM
            }
        }
    }
    val scopingState: ScopingState<Component> = viewModel(storeOwner, key, factory)
    return scopingState.value
}
