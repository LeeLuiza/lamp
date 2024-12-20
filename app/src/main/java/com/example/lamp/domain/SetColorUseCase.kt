package com.example.lamp.domain

import com.example.lamp.data.repository.LampRepository
import javax.inject.Inject

interface SetColorUseCase {
    suspend operator fun invoke(color: String): Boolean
}

class SetColorUseCaseImpl @Inject constructor(
    private val lampRepository: LampRepository,
): SetColorUseCase {

    override suspend fun invoke(color: String): Boolean {
        return lampRepository.setColor(color)
    }
}