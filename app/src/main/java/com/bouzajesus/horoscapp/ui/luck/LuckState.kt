package com.bouzajesus.horoscapp.ui.luck

import com.bouzajesus.horoscapp.domain.model.LuckyModel

sealed class LuckState {
    data class Success(val luckyModel: LuckyModel): LuckState()
    data object Error: LuckState()
}