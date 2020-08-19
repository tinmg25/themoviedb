package com.tmw.navigationdrawerexample.ui.nowplaying

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tmw.navigationdrawerexample.R
import kotlinx.android.synthetic.main.item_nowplaying.view.*
import com.tmw.navigationdrawerexample.modelnowplaying.*

class NowPlayingAdapter(var resultList: List<Result> = ArrayList()) :
    RecyclerView.Adapter<NowPlayingAdapter.NowPlayingViewHolder>() {

    inner class NowPlayingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var result: Result

        fun bindNow(result: Result) {
            this.result = result

            itemView.txtAdult.text = result.adult.toString()
            Picasso.get().load("https://image.tmdb.org/t/p/w500/${result.backdrop_path}").placeholder(R.drawable.ic_launcher_background)
                .into(itemView.imgBackdropPath)
            itemView.txtID.text = result.id.toString()
            itemView.txtOrgLanguage.text = result.original_language
            itemView.txtOrgTitle.text = result.original_title
            itemView.txtOverView.text = result.overview
            itemView.txtPopularity.text = result.popularity.toString()
            Picasso.get().load("https://image.tmdb.org/t/p/original/${result.poster_path}").placeholder(R.drawable.ic_launcher_background)
                .into(itemView.imgPoster)
            itemView.txtTitle.text = result.title
            itemView.txtVideo.text = result.video.toString()
            itemView.txtVoteAvg.text = result.vote_average.toString()
            itemView.txtVoteCount.text = result.vote_count.toString()
        }

    }

    fun updateNowPlaying(resultList: List<Result>) {
        this.resultList = resultList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_nowplaying, parent, false)
        return NowPlayingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: NowPlayingViewHolder, position: Int) {
        holder.bindNow(resultList[position])
    }

}