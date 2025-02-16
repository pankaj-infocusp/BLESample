package com.ble.example

import android.app.Application
import com.ble.example.ble.BleManager

class BleApp: Application() {

    override fun onCreate() {
        super.onCreate()
        BleManager.initialize(this)
    }
}