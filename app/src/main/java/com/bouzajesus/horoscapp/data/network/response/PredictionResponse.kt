package com.bouzajesus.horoscapp.data.network.response

import com.bouzajesus.horoscapp.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName

data class PredictionResponse(
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("date") val date: String,
    @SerializedName("sign") val sign: String
){
    fun toDomain(): PredictionModel?{
        return PredictionModel(horoscope, sign)
    }
}