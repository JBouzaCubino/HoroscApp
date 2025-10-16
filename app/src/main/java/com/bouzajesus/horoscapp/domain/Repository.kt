package com.bouzajesus.horoscapp.domain

import com.bouzajesus.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}