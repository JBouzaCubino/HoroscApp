package com.bouzajesus.horoscapp.ui.horoscopo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bouzajesus.horoscapp.R
import com.bouzajesus.horoscapp.domain.model.HoroscopeInfo

class HoroscopeAdapter(
    private var horoscopeList: List<HoroscopeInfo> = emptyList(),
    private val onItemSelected: (HoroscopeInfo) -> Unit
) : RecyclerView.Adapter<HoroscopeViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HoroscopeViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        return HoroscopeViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: HoroscopeViewHolder,
        position: Int
    ) {
        holder.render(horoscopeList[position], onItemSelected)
    }

    override fun getItemCount(): Int = horoscopeList.size

    fun updateList(newHoroscopeList: List<HoroscopeInfo>) {
        horoscopeList = newHoroscopeList
        notifyDataSetChanged()
    }
}