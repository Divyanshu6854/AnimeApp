package com.example.animepocapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animepocapp.api.ApiRepository
import com.example.animepocapp.dataModel.AnimeListDataModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetAnimeListViewModel @Inject constructor(private val repository: ApiRepository) :
    ViewModel() {

    private val _posts = MutableLiveData<AnimeListDataModel>()
    val posts: LiveData<AnimeListDataModel> get() = _posts

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private var dataFetched = false

    fun isDataFetched(): Boolean {
        return dataFetched
    }

    fun setDataFetched(fetched: Boolean) {
        dataFetched = fetched
    }

    fun getAnimeList() {
        if (!dataFetched) {
            viewModelScope.launch {
                try {
                    _posts.value = repository.getAnimeList()
                    dataFetched = true
                } catch (e: Exception) {
                    _errorMessage.value = e.message
                }
            }
        }
    }

}