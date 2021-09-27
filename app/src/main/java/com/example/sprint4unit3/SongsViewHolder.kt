package com.example.sprint4unit3

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*
import java.text.FieldPosition

class SongsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun setData(resultsDTO: ResultsDTO){
        Glide.with(view.songPreviewImage).load(resultsDTO.artworkUrl100).into(view.songPreviewImage)
        view.tvTrackName.text=resultsDTO.trackName;
        view.tvArtistName.text=resultsDTO.artistName
    }
}