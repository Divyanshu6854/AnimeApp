package com.example.animepocapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animepocapp.R
import com.example.animepocapp.dataModel.AnimeDetails
import com.example.animepocapp.utils.OnClickListeners

class AnimeListAdapter(val context: Context, val list: List<AnimeDetails>, val listener : OnClickListeners) :
    RecyclerView.Adapter<AnimeListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val animeImage: ImageView = view.findViewById(R.id.img_anime_poster)
        val animeName: TextView = view.findViewById(R.id.tv_anime_name)
        val animeEpsNumber: TextView = view.findViewById(R.id.tv_episode_numbers)
        val animeRating: TextView = view.findViewById(R.id.tv_rating)
        val rootItemAnime: CardView = view.findViewById(R.id.root_anime_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_anime_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //anime title image
        Glide.with(context).load(list[position].images.jpg.image_url).into(holder.animeImage)

        //anime title
        holder.animeName.text = list[position].title

        //anime episode number
        holder.animeEpsNumber.text = "Episodes : "+list[position].episodes.toString()

        //anime rating
        holder.animeRating.text = "Rating : "+list[position].rating

        holder.rootItemAnime.setOnClickListener {
            listener.onAnimeItemSelected(list[position].mal_id, position)
        }
    }
}