package com.tmw.navigationdrawerexample.ui.toprated

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tmw.navigationdrawerexample.R
import com.tmw.navigationdrawerexample.modeltoprated.Result
import kotlinx.android.synthetic.main.item_toprated.view.*

class TopRatedAdapter(var resultList: List<Result> = ArrayList()):RecyclerView.Adapter<TopRatedAdapter.TopRatedViewHolder>(){
    class TopRatedViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        private lateinit var result: Result

        fun bindTop(result: Result) {
            this.result = result

            itemView.txtAdult.text = result.adult.toString()
            Picasso.get().load("https://image.tmdb.org/t/p/w500/${result.backdrop_path}")
                .placeholder(
                    R.drawable.ic_launcher_background
                )
                .into(itemView.imgBackdropPath)
            itemView.txtID.text = result.id.toString()
            itemView.txtOrgLanguage.text = result.original_language
            itemView.txtOrgTitle.text = result.original_title
            itemView.txtOverView.text = result.overview
            itemView.txtPopularity.text = result.popularity.toString()
            Picasso.get().load("https://image.tmdb.org/t/p/original/${result.poster_path}")
                .placeholder(
                    R.drawable.ic_launcher_background
                )
                .into(itemView.imgPoster)
            itemView.txtTitle.text = result.title
            itemView.txtVideo.text = result.video.toString()
            itemView.txtVoteAvg.text = result.vote_average.toString()
            itemView.txtVoteCount.text = result.vote_count.toString()
        }
    }
    fun updateTopRated(resultList: List<Result>) {
        this.resultList = resultList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_toprated,parent,false)
        return TopRatedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        holder.bindTop(resultList.get(position))
    }
}