package com.ble.example.navigation

import android.bluetooth.BluetoothAdapter
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ble.example.screens.SearchBleDeviceViewModel
import com.ble.example.screens.SearchBleDevicesScreen

@Composable
fun AppNavigationHost(
    modifier: Modifier = Modifier,
    startDestination: String,
    navController: NavHostController,
    bluetoothAdapter: BluetoothAdapter
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(
            route = AppRoute.SearchBleDevices.route
        ) {
            val viewModel = SearchBleDeviceViewModel(bluetoothAdapter)
            SearchBleDevicesScreen(
                viewModel = viewModel
            )
        }
    }
}