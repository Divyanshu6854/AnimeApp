package com.example.animepocapp.api

import com.example.animepocapp.dataModel.AnimeDetailByIdModel
import com.example.animepocapp.dataModel.AnimeDetails
import com.example.animepocapp.dataModel.AnimeListDataModel
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    //get anime list
    @GET("v4/top/anime")
    suspend fun getAnimeList() : AnimeListDataModel

    @GET("v4/anime/{anime_id}")
    suspend fun getAnimeDetails(@Path("anime_id") id : Int) : AnimeDetailByIdModel
}