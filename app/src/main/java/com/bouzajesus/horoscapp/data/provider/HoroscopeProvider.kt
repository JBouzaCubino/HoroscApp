package com.bouzajesus.horoscapp.data.provider

import com.bouzajesus.horoscapp.data.HoroscopeInfo
import com.bouzajesus.horoscapp.data.HoroscopeInfo.*
import jakarta.inject.Inject

class HoroscopeProvider @Inject constructor() {

    fun getHoroscope(): List<HoroscopeInfo> = listOf(
        Aries,
        Aquario,
        Cancer,
        Capricorn,
        Scorpio,
        Gemini,
        Leo,
        Libra,
        Piscis,
        Sagittarius,
        Taurus,
        Virgo
    )
}