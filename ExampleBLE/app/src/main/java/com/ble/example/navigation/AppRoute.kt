package com.ble.example.navigation

sealed class AppRoute(val route: String) {
    data object SearchBleDevices : AppRoute("search_ble_devices")
    data object PermissionScreen : AppRoute("permission_screen")
}
