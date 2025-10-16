package com.bouzajesus.horoscapp.domain.model

import com.bouzajesus.horoscapp.R

sealed class HoroscopeInfo(val name: Int, val img: Int) {
    data object Aries : HoroscopeInfo(R.string.aries, R.drawable.aries)
    data object Aquario : HoroscopeInfo(R.string.aquarius, R.drawable.aquario)
    data object Cancer : HoroscopeInfo(R.string.cancer, R.drawable.cancer)
    data object Capricorn : HoroscopeInfo(R.string.capricorn, R.drawable.capricornio)
    data object Scorpio : HoroscopeInfo(R.string.scorpio, R.drawable.escorpio)
    data object Gemini : HoroscopeInfo(R.string.gemini, R.drawable.geminis)
    data object Leo : HoroscopeInfo(R.string.leo, R.drawable.leo)
    data object Libra : HoroscopeInfo(R.string.libra, R.drawable.libra)
    data object Piscis : HoroscopeInfo(R.string.pisces, R.drawable.piscis)
    data object Sagittarius : HoroscopeInfo(R.string.sagittarius, R.drawable.sagitario)
    data object Taurus : HoroscopeInfo(R.string.taurus, R.drawable.tauro)
    data object Virgo : HoroscopeInfo(R.string.virgo, R.drawable.virgo)
}