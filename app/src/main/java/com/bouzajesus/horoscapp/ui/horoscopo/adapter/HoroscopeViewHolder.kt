package com.bouzajesus.horoscapp.ui.horoscopo.adapter

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.content.ContextCompat.getString
import androidx.recyclerview.widget.RecyclerView
import com.bouzajesus.horoscapp.databinding.ItemHoroscopeBinding
import com.bouzajesus.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    private val ROTATION_ANIMATION_DURATION: Long = 800

    fun render(info: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        binding.ivHoroscope.setImageResource(info.img)
        binding.tvTitle.text = getString(binding.tvTitle.context, info.name)

        binding.ivHoroscope.setOnClickListener {
            initRotationAnimation { onItemSelected(info) }
        }
    }

    private fun initRotationAnimation(endAction: () -> Unit) {
        val animator = ObjectAnimator.ofFloat(binding.ivHoroscope, View.ROTATION, 0f, 360f)
        animator.duration = ROTATION_ANIMATION_DURATION
        animator.interpolator = LinearInterpolator()
        animator.doOnEnd { endAction() }
        animator.start()
    }
}