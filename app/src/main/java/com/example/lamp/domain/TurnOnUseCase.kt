package com.example.lamp.domain

import com.example.lamp.data.repository.LampRepository
import javax.inject.Inject

interface TurnOnUseCase {
    suspend operator fun invoke(): Boolean
}

class TurnOnUseCaseImpl @Inject constructor(
    private val lampRepository: LampRepository
) : TurnOnUseCase {

    override suspend fun invoke(): Boolean {
        return lampRepository.turnOn()
    }
}