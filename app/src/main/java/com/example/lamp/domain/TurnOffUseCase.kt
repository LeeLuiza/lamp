package com.example.lamp.domain

import com.example.lamp.data.repository.LampRepository
import javax.inject.Inject

interface TurnOffUseCase {
    suspend operator fun invoke(): Boolean
}

class TurnOffUseCaseImpl @Inject constructor(
    private val lampRepository: LampRepository
) : TurnOffUseCase {

    override suspend fun invoke(): Boolean {
        return lampRepository.turnOff()
    }
}