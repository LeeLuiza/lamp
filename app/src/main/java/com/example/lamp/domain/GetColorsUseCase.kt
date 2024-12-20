package com.example.lamp.domain

import com.example.lamp.data.repository.LampRepository
import retrofit2.Response
import javax.inject.Inject

interface GetColorUseCase {
    suspend operator fun invoke(): List<String>
}

class GetColorUseCaseImpl @Inject constructor(
    private val lampRepository: LampRepository,
): GetColorUseCase {

    override suspend fun invoke(): List<String> {
        return lampRepository.getColors()
    }
}