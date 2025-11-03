package com.bouzajesus.horoscapp.domain.usecases

import com.bouzajesus.horoscapp.domain.Repository
import com.bouzajesus.horoscapp.domain.model.LuckyModel
import jakarta.inject.Inject

class GetRandomLuckyModelUseCase @Inject constructor(private val repository: Repository) {

    fun execute(): LuckyModel?{
        return repository.getRandomLuckyModel()
    }
}