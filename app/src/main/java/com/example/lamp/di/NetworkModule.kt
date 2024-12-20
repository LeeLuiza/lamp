package com.example.lamp.di

import com.example.lamp.data.api.LampService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideLampApi(): LampService {
        return Retrofit.Builder()
            .baseUrl("http://46.17.45.34:1337/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LampService::class.java)
    }
}