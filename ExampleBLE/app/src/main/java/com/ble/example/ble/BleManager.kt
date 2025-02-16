package com.ble.example.ble

import android.annotation.SuppressLint
import android.app.Application
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattService

@SuppressLint("MissingPermission")
object BleManager {

    private var mContext: Application? = null
    private var bluetoothGatt: BluetoothGatt? = null

    fun initialize(context: Application) {
        if (mContext == null) {
            mContext = context
        }
    }

    fun connectGatt(
        device: BluetoothDevice,
        autoConnect: Boolean = false,
        gattCallback: BluetoothGattCallback,
    ) {
        bluetoothGatt = device.connectGatt(mContext, autoConnect, gattCallback)
    }


    fun discoverServices() {
        bluetoothGatt?.discoverServices()
    }

    fun getSupportedGattServices(): List<BluetoothGattService>? {
        return bluetoothGatt?.services
    }

    fun disconnectGatt() {
        bluetoothGatt?.disconnect()
    }

    fun closeGatt() {
        bluetoothGatt?.let { gatt ->
            gatt.close()
            bluetoothGatt = null
        }
    }
}