package com.example.animepocapp.api

import com.example.animepocapp.dataModel.AnimeDetailByIdModel
import com.example.animepocapp.dataModel.AnimeDetails
import com.example.animepocapp.dataModel.AnimeListDataModel
import javax.inject.Inject


class ApiRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getAnimeList(): AnimeListDataModel {
        return apiService.getAnimeList()
    }

    suspend fun getAnimeItemDetail(id : Int): AnimeDetailByIdModel {
        return apiService.getAnimeDetails(id)
    }
}
