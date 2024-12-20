package com.example.lamp.data.repository

import com.example.lamp.data.api.LampService
import retrofit2.Response
import javax.inject.Inject


interface LampRepository {

    suspend fun turnOn(): Boolean
    suspend fun turnOff(): Boolean
    suspend fun setColor(colorName: String): Boolean
    suspend fun getColors():List<String>
    suspend fun setBrightnessLevel(brightnessLevel: Int): Boolean
}
class LampRepositoryImpl @Inject constructor(
    private val lampApi: LampService
) : LampRepository {

    override suspend fun turnOn(): Boolean {
        return lampApi.turnOn()
    }

    override suspend fun turnOff(): Boolean {
        return lampApi.turnOff()
    }

    override suspend fun setColor(colorName: String): Boolean {
        return lampApi.setColor(colorName)
    }

    override suspend fun getColors(): List<String> {
        return lampApi.getColors()
    }

    override suspend fun setBrightnessLevel(brightnessLevel: Int): Boolean {
        return lampApi.setBrightnessLevel(brightnessLevel)
    }
}