package com.bouzajesus.horoscapp.ui.horoscopo.adapter

import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import androidx.core.content.ContextCompat.getString
import androidx.core.graphics.rotationMatrix
import androidx.recyclerview.widget.RecyclerView
import com.bouzajesus.horoscapp.R
import com.bouzajesus.horoscapp.data.HoroscopeInfo
import com.bouzajesus.horoscapp.databinding.ItemHoroscopeBinding

class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(info: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        binding.ivHoroscope.setImageResource(info.img)
        binding.tvTitle.text = getString(binding.tvTitle.context, info.name)

        binding.ivHoroscope.setOnClickListener {
            onItemSelected(info)
        }
    }
}