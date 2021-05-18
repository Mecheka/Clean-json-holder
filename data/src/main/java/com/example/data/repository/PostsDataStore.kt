package com.example.data.repository

import com.example.domain.entities.DataEntity
import com.example.domain.entities.PostsEntity
import kotlinx.coroutines.flow.Flow

interface PostsDataStore {

    suspend fun getPosts(): Flow<DataEntity<List<PostsEntity>>>
}