package com.bouzajesus.horoscapp.ui.luck

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bouzajesus.horoscapp.R
import com.bouzajesus.horoscapp.databinding.FragmentLuckBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.Random

@AndroidEntryPoint
class LuckFragment : Fragment() {

    private var _binding: FragmentLuckBinding? = null
    private val binding get() = _binding!!

    private val luckViewModel by viewModels<LuckViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLuckBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        luckViewModel.getRandomPrediction()
        initUI()
    }

    private fun initUI() {
        initListeners()

        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            luckViewModel.state.collect { state ->
                when(state){
                    LuckState.Error -> errorState()
                    is LuckState.Success -> successState(state.luckyModel.image, state.luckyModel.text)
                }
            }
        }
    }

    private fun errorState(){
        binding.tvLucky.text = getString(R.string.error)

        Toast.makeText(this.context, "An error occurred", Toast.LENGTH_SHORT).show()
    }

    private fun successState(image: Int, text: Int) {
        binding.ivLuckyCard.setImageResource(image)
        binding.tvLucky.text = getString(text)
    }

    private fun initListeners() {
        binding.ivCardRoulette.setOnClickListener { spinRoulette() }
    }

    private fun growCard(){
        val animator = AnimatorInflater.loadAnimator(this.context, R.animator.grow_up)
        animator.setTarget(binding.ivReverse)
        animator.doOnEnd {
            binding.ivReverse.isVisible = false
            showPredictionView()
        }
        animator.start()
    }

    private fun slideCard(){
        val animator = AnimatorInflater.loadAnimator(this.context, R.animator.slide_up)
        animator.setTarget(binding.ivReverse)
        binding.ivReverse.isVisible = true
        animator.doOnEnd { growCard() }
        animator.start()
    }

    private fun showPredictionView(){
        val disappearAnimator = AnimatorInflater.loadAnimator(this.context, R.animator.disappear)
        val appearAnimator = AnimatorInflater.loadAnimator(this.context, R.animator.appear)

        disappearAnimator.setTarget(binding.preview)
        appearAnimator.setTarget(binding.prediction)

        disappearAnimator.doOnEnd {
            binding.preview.isVisible = false
            binding.prediction.isVisible = true
        }

        disappearAnimator.start()
        appearAnimator.start()
    }

    private fun spinRoulette(){
        val random = Random()
        val degrees = random.nextInt(1440) + 360
        val animator = ObjectAnimator.ofFloat(binding.ivCardRoulette, View.ROTATION, 0f, degrees.toFloat())
        animator.duration = 2000
        animator.interpolator = DecelerateInterpolator()
        animator.doOnEnd { slideCard() }
        animator.start()
    }

}