package com.ble.example.screens

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothGattService
import android.bluetooth.BluetoothProfile
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanFilter
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ble.example.ble.ApolloIdentifiers
import com.ble.example.ble.ApolloIdentifiers.ApolloService.blockTransferServiceUUID
import com.ble.example.ble.ApolloIdentifiers.Characteristics.inputBufferCharacteristicUUID
import com.ble.example.ble.ApolloIdentifiers.Characteristics.inputSizeCharacteristicUUID
import com.ble.example.ble.BleManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.UUID


@Suppress("DEPRECATION")
@SuppressLint("MissingPermission")
class SearchBleDeviceViewModel(
    private val bluetoothAdapter: BluetoothAdapter
) : ViewModel() {
    private val _bleDevices = mutableStateListOf<BluetoothDevice>()
    val bleDevices: List<BluetoothDevice> = _bleDevices

    private val _isBleConnected = MutableStateFlow(false)
    val isBleConnected: MutableStateFlow<Boolean> = _isBleConnected

    private val bluetoothLeScanner = bluetoothAdapter.bluetoothLeScanner
    private var scanning = false

    companion object {
        private const val SCAN_PERIOD = 10000L
    }

    private val scanCallback = object : ScanCallback() {
        override fun onScanResult(callbackType: Int, result: ScanResult) {
            super.onScanResult(callbackType, result)
            if (bleDevices.contains(result.device).not()) {
                _bleDevices.add(result.device)
            }
            Log.d("ScanResult", "onScanResult: ${result.device.name} ==> ${result.device.address}")
        }

        override fun onScanFailed(errorCode: Int) {
            super.onScanFailed(errorCode)
            Log.d("ScanResult", "onScanFailed: $errorCode")
        }
    }

    init {
        startScanWithTimeout()
    }

    private fun startScanWithTimeout() {
        viewModelScope.launch(Dispatchers.IO) {
            if (!scanning) {
                scanning = true

                startScanning()

                delay(SCAN_PERIOD)
                scanning = false
                bluetoothLeScanner.stopScan(scanCallback)
            }
        }
    }

    private fun startScanning() {
        val scanFilter = mutableStateListOf(
            ScanFilter.Builder().apply {
                setManufacturerData(ApolloIdentifiers.APOLLO_COMPANY_IDENTIFIER, null)
            }.build()
        )
        val scanSettings = ScanSettings.Builder().apply {
            setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
        }.build()

        bluetoothLeScanner.startScan(scanFilter, scanSettings, scanCallback)
    }

    private val bluetoothGattCallback = object : BluetoothGattCallback() {
        override fun onConnectionStateChange(gatt: BluetoothGatt?, status: Int, newState: Int) {
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                // successfully connected to the GATT Server
                Log.d("BluetoothConnection", "onConnectionStateChange: Connected to the GATT Server")
                _isBleConnected.value = true
                //Discover services after connection established
                BleManager.discoverServices()
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                // disconnected from the GATT Server
                Log.d("BluetoothConnection", "onConnectionStateChange: Disconnected to the GATT Server")
                _isBleConnected.value = false
                BleManager.closeGatt()
            }
        }

        override fun onServicesDiscovered(gatt: BluetoothGatt?, status: Int) {
            super.onServicesDiscovered(gatt, status)
            if (status == BluetoothGatt.GATT_SUCCESS) {
                Log.d("BluetoothConnection", "onServicesDiscovered: Services discovered successfully")
                val services = BleManager.getSupportedGattServices()
                services?.forEach { service ->
                    Log.d("BluetoothConnection", "onServicesDiscovered: Service UUID: ${service.uuid}")
                    readCharacteristics(gatt, service)
                }
            }
        }

        override fun onCharacteristicRead(
            gatt: BluetoothGatt,
            characteristic: BluetoothGattCharacteristic,
            value: ByteArray,
            status: Int
        ) {
            super.onCharacteristicRead(gatt, characteristic, value, status)
            if (status == BluetoothGatt.GATT_SUCCESS) {
                when (characteristic.uuid) {
                    inputBufferCharacteristicUUID -> {
                        val properties = characteristic.properties
                        Log.d("Characteristic", "InputBuffer Properties : $properties")
                        setCharacteristicNotification(gatt, characteristic)
                    }

                    inputSizeCharacteristicUUID -> {
                        val properties = characteristic.properties
                        Log.d("Characteristic", "InputSize Properties : $properties")
                        setCharacteristicNotification(gatt, characteristic)
                    }

                    else -> {
                        val properties = characteristic.properties
                        Log.d("Characteristic", "Properties : $properties")
                    }
                }
            }
        }

        override fun onCharacteristicChanged(
            gatt: BluetoothGatt,
            characteristic: BluetoothGattCharacteristic,
            value: ByteArray
        ) {
            super.onCharacteristicChanged(gatt, characteristic, value)
            when (characteristic.uuid) {
                inputBufferCharacteristicUUID -> {
                    val byteArray = characteristic.value
                    Log.d("CharacteristicChanged", "Data size : ${byteArray.size}")
                }
            }
        }
    }

    private fun setCharacteristicNotification(
        gatt: BluetoothGatt,
        characteristic: BluetoothGattCharacteristic,
        uuid: UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb")
    ) {
        gatt.setCharacteristicNotification(characteristic, true)
        val descriptor = characteristic.getDescriptor(uuid)
        descriptor.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
        gatt.writeDescriptor(descriptor)
    }

    private fun readCharacteristics(gatt: BluetoothGatt?, service: BluetoothGattService) {
        if (service.uuid == blockTransferServiceUUID) {
            val inputBufferChar = service.getCharacteristic(
                inputBufferCharacteristicUUID
            )
            gatt?.readCharacteristic(inputBufferChar)

            val inputSizeChar = service.getCharacteristic(
                inputSizeCharacteristicUUID
            )
            gatt?.readCharacteristic(inputSizeChar)
        }
    }

    fun connect(address: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val device = bluetoothAdapter.getRemoteDevice(address)
                BleManager.connectGatt(
                    device = device,
                    autoConnect = false,
                    gattCallback = bluetoothGattCallback
                )
            } catch (e: IllegalArgumentException) {
                Log.d("BluetoothConnection", "Exception Device is not found with this address")
            }
        }
    }

    fun disconnectGatt() {
        BleManager.disconnectGatt()
    }

}