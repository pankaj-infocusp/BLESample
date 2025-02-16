package com.ble.example.ble

import java.util.UUID

class ApolloIdentifiers {
    companion object {
        const val APOLLO_COMPANY_IDENTIFIER = 0x07A1
        val DFUIdentifier = UUID.fromString("0000fe59-0000-1000-8000-00805f9b34fb")
    }

    object ApolloService {
        val blockTransferServiceUUID = UUID.fromString("00001623-1212-efde-1523-785feabcd124")
    }

    object Characteristics {
        val inputBufferCharacteristicUUID = UUID.fromString("00001625-1212-efde-1523-785feabcd124")
        val inputSizeCharacteristicUUID = UUID.fromString("00001627-1212-efde-1523-785feabcd124")
        val outputBufferCharacteristicUUID = UUID.fromString("00001624-1212-efde-1523-785feabcd124")
        val outputSizeCharacteristicUUID = UUID.fromString("00001626-1212-efde-1523-785feabcd124")
    }
}