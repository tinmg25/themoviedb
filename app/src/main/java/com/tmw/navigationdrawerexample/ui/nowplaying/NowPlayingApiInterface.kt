package com.tmw.navigationdrawerexample.ui.nowplaying

import com.tmw.navigationdrawerexample.modelnowplaying.NowPlaying
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NowPlayingApiInterface {
    @GET("now_playing")
    fun getNowPlaying(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: String
    ): Call<NowPlaying>
}