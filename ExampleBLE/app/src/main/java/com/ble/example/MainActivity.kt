package com.ble.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ble.example.navigation.AppNavigationHost
import com.ble.example.navigation.AppRoute
import com.ble.example.screens.PermissionScreen
import com.ble.example.ui.theme.ExampleBLETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            ExampleBLETheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    PermissionScreen { bluetoothAdapter ->
                        AppNavigationHost(
                            modifier = Modifier.padding(innerPadding),
                            navController = navController,
                            startDestination = AppRoute.SearchBleDevices.route,
                            bluetoothAdapter = bluetoothAdapter
                        )
                    }
                }
            }
        }
    }
}