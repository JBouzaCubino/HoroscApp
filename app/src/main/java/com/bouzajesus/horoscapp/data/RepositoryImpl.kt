package com.bouzajesus.horoscapp.data

import android.util.Log
import com.bouzajesus.horoscapp.data.network.HoroscopeApiService
import com.bouzajesus.horoscapp.domain.Repository
import com.bouzajesus.horoscapp.domain.model.PredictionModel
import jakarta.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {

    override suspend fun getPrediction(sign: String): PredictionModel? {
        try {
            return apiService.getHoroscopeInfo(sign).toDomain()
        } catch (exception: Exception) {
            Log.e("error", "An error has ocurred ${exception.message}")
            return null
        }
    }
}