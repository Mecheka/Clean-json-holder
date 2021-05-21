package com.example.cleanjsonholder

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.DataEntity
import com.example.domain.entities.PostsEntity
import com.example.domain.usecase.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: GetPostsUseCase) : ViewModel() {

    private val _postsLiveData = MutableLiveData<DataEntity<List<PostsEntity>>>()
    val postsLiveData: LiveData<DataEntity<List<PostsEntity>>>
        get() = _postsLiveData

    fun loadPosts() {
        viewModelScope.launch {
            useCase().collect {
                Log.d("Collect", "In functions")
                _postsLiveData.value = it
            }
        }
    }
}