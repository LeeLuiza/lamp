package com.example.lamp.domain

import com.example.lamp.data.repository.LampRepository
import retrofit2.Response
import javax.inject.Inject

interface  SetBrightnessLevelUseCase {

    suspend operator fun invoke(level: Int): Boolean
}

class SetBrightnessLevelUseCaseImpl @Inject constructor(
    private val lampRepository: LampRepository,
): SetBrightnessLevelUseCase {

    override suspend fun invoke(level: Int): Boolean {
        return lampRepository.setBrightnessLevel(level)
    }
}

