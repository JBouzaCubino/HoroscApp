package com.bouzajesus.horoscapp.ui.detail

sealed class HoroscopeDetailState {
    data object Laoding: HoroscopeDetailState()
    data class Error(val error: String): HoroscopeDetailState()
    data class Success(val prediction: String, val sign: String): HoroscopeDetailState()
}