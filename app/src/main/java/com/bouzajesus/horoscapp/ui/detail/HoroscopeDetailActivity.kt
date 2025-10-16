package com.bouzajesus.horoscapp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.navArgs
import com.bouzajesus.horoscapp.databinding.ActivityHoroscopeDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel by viewModels<HoroscopeDetailViewModel>()

    private val args: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()

        horoscopeDetailViewModel.getHoroscope(args.type.name)
    }

    private fun initUI() {
        initUIState()

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            horoscopeDetailViewModel.state.collect { state ->
                when (state) {
                    is HoroscopeDetailState.Error -> errorState()
                    HoroscopeDetailState.Laoding -> loadingState()
                    is HoroscopeDetailState.Success -> successState()
                }
            }
        }
    }

    private fun loadingState(){
        binding.pbLoading.isVisible = true
    }

    private fun successState(){
        binding.pbLoading.isVisible = false
    }

    private fun errorState(){
        binding.pbLoading.isVisible = false
    }
}