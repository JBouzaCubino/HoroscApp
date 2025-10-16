package com.bouzajesus.horoscapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bouzajesus.horoscapp.domain.usecases.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) : ViewModel() {

    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Laoding)
    val state: StateFlow<HoroscopeDetailState> = _state

    fun getHoroscope(sign: String){
        viewModelScope.launch {
            _state.value = HoroscopeDetailState.Laoding
            val predictionModel = withContext(Dispatchers.IO){
                getPredictionUseCase.execute(sign)
            }
            if(predictionModel == null){
                _state.value = HoroscopeDetailState.Error("Ha ocurrido un error.")
            }
            else{
                _state.value = HoroscopeDetailState.Success(predictionModel.horoscope, predictionModel.sign)
            }

        }
    }

}