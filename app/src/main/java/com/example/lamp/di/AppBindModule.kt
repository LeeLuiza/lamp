package com.example.lamp.di

import com.example.lamp.data.repository.LampRepository
import com.example.lamp.data.repository.LampRepositoryImpl
import com.example.lamp.domain.GetColorUseCase
import com.example.lamp.domain.GetColorUseCaseImpl
import com.example.lamp.domain.SetColorUseCase
import com.example.lamp.domain.SetColorUseCaseImpl
import com.example.lamp.domain.TurnOffUseCase
import com.example.lamp.domain.TurnOffUseCaseImpl
import com.example.lamp.domain.TurnOnUseCase
import com.example.lamp.domain.TurnOnUseCaseImpl
import com.example.lamp.domain.SetBrightnessLevelUseCase
import com.example.lamp.domain.SetBrightnessLevelUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface  AppBindModule {
    @Binds
    fun bindLampRepository(repository: LampRepositoryImpl): LampRepository

    @Binds
    fun bindTurnOnUseCase(useCase: TurnOnUseCaseImpl): TurnOnUseCase

    @Binds
    fun bindTurnOffUseCase(useCase: TurnOffUseCaseImpl): TurnOffUseCase

    @Binds
    fun bindSetBrightnessUseCase(useCase: SetBrightnessLevelUseCaseImpl): SetBrightnessLevelUseCase

    @Binds
    fun bindGetColorsUseCase(useCase: GetColorUseCaseImpl): GetColorUseCase

    @Binds
    fun bindSetColorUseCase(useCase: SetColorUseCaseImpl): SetColorUseCase
}