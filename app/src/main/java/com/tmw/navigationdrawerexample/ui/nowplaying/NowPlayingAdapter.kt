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

//    var mClickListener: clickListener? = null
//
//    fun setOnClickListener(clickListener: clickListener) {
//        this.mClickListener = clickListener
//    }

    inner class NowPlayingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var result: Result
//
//        init {
//            itemView.setOnClickListener(this)
//        }

        fun bindNow(result: Result) {
            this.result = result

            itemView.txtAdult.text = result.adult.toString()
            Picasso.get().load(result.backdrop_path).placeholder(R.drawable.ic_launcher_background)
                .into(itemView.imgBackdropPath)
            itemView.txtID.text = result.id.toString()
            itemView.txtOrgLanguage.text = result.original_language
            itemView.txtOrgTitle.text = result.original_title
            itemView.txtOverView.text = result.overview
            itemView.txtPopularity.text = result.popularity.toString()
            Picasso.get().load(result.poster_path).placeholder(R.drawable.ic_launcher_background)
                .into(itemView.imgPoster)
            itemView.txtTitle.text = result.title
            itemView.txtVideo.text = result.video.toString()
            itemView.txtVoteAvg.text = result.vote_average.toString()
            itemView.txtVoteCount.text = result.vote_count.toString()
        }
//
//        override fun onClick(view: View?) {
//            mClickListener?.onClick(result)
//        }
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

//    interface clickListener {
//        fun onClick(result: Result)
//    }
}