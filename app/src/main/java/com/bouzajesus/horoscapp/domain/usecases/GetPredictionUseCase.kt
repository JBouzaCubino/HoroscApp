package com.bouzajesus.horoscapp.domain.usecases

import com.bouzajesus.horoscapp.domain.Repository
import com.bouzajesus.horoscapp.domain.model.PredictionModel
import jakarta.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {

    suspend fun execute(sign: String): PredictionModel? {
        return repository.getPrediction(sign)
    }
}