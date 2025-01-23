package com.example.animepocapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animepocapp.api.ApiRepository
import com.example.animepocapp.dataModel.AnimeDetailByIdModel
import com.example.animepocapp.dataModel.AnimeDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetAnimeDetailByIdViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel(){

    private val _posts = MutableLiveData<AnimeDetailByIdModel>()
    val posts: LiveData<AnimeDetailByIdModel> get() = _posts

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun getAnimeDetail(id : Int) {
        viewModelScope.launch {
            try {
                _posts.value = repository.getAnimeItemDetail(id)
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }
}