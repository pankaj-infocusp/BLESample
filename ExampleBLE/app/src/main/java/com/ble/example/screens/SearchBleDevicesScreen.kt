package com.ble.example.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@SuppressLint("MissingPermission")
@Composable
fun SearchBleDevicesScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchBleDeviceViewModel
) {

    val isBleConnected by viewModel.isBleConnected.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(viewModel.bleDevices) { item ->
                    OutlinedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(16.dp),
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(
                            width = 1.dp,
                            color = androidx.compose.material3.MaterialTheme.colorScheme.primary
                        ),
                        onClick = {
                            viewModel.connect(item.address)
                        }
                    ) {
                        Column(
                            modifier = Modifier.padding(10.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Text(text = "Name: ${item.name ?: "Unknown"}")
                            Text(text = "Address : ${item.address}")
                            Text(text = "UUIDs : ${item.uuids}")
                            Text(text = "BondState : ${item.bondState}")
                        }
                    }
                }

                item {
                    if (isBleConnected) {
                        Button(modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .align(Alignment.Center),
                            onClick = {
                                viewModel.disconnectGatt()
                            }
                        ) {
                            Text(text = "Disconnect")
                        }
                    }
                }
            }
        }
    }
}