package com.example.sprint4unit3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SongsAdapter(private val responseDTO: ResponseDTO) : RecyclerView.Adapter<SongsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return SongsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongsViewHolder, position: Int) {
        val responseDTO=responseDTO
        holder.setData(responseDTO)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}