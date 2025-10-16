package com.bouzajesus.horoscapp.data.network

import com.bouzajesus.horoscapp.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {

    @GET("/{sign}")
    suspend fun getHoroscopeInfo(@Path("sign") sign: String): PredictionResponse
}