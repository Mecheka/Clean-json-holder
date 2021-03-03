package com.example.data.repository

import com.example.data.entities.DataResponse
import com.example.data.entities.Posts
import kotlinx.coroutines.flow.Flow

interface PostsDataStore {

    suspend fun getPosts(): Flow<DataResponse<List<Posts>>>
}