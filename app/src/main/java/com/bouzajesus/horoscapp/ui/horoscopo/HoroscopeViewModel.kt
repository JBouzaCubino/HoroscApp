package com.bouzajesus.horoscapp.ui.horoscopo

import androidx.lifecycle.ViewModel
import com.bouzajesus.horoscapp.data.HoroscopeInfo
import com.bouzajesus.horoscapp.data.HoroscopeInfo.*
import com.bouzajesus.horoscapp.data.provider.HoroscopeProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider): ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        _horoscope.value = horoscopeProvider.getHoroscope()
    }

}