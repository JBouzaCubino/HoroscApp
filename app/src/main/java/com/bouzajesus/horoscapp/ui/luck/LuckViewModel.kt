package com.bouzajesus.horoscapp.ui.luck

import androidx.lifecycle.ViewModel
import com.bouzajesus.horoscapp.domain.usecases.GetRandomLuckyModelUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class LuckViewModel @Inject constructor(private val getRandomLuckyModelUseCase: GetRandomLuckyModelUseCase): ViewModel() {

    private var _state = MutableStateFlow<LuckState>(LuckState.Error)
    val state: StateFlow<LuckState> = _state

    fun getRandomPrediction(){
        val luckModel = getRandomLuckyModelUseCase.execute()

        if(luckModel != null){
            _state.value = LuckState.Success(luckModel)
        }
        else{
            _state.value = LuckState.Error
        }
    }
}