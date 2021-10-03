package com.example.cleanjsonholder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.DataEntity
import com.example.domain.entities.PostsEntity
import com.example.domain.usecase.GetPostsUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(private val useCase: GetPostsUseCase) : ViewModel() {

    private val _postsLiveData = MutableLiveData<DataEntity<List<PostsEntity>>>()
    val postsLiveData: LiveData<DataEntity<List<PostsEntity>>>
        get() = _postsLiveData

    fun loadPosts() {
        viewModelScope.launch {
            useCase().collect {
                _postsLiveData.value = it
            }
        }
    }
}