package com.example.domain.repository

import com.example.domain.entities.DataEntity
import com.example.domain.entities.PostsEntity
import kotlinx.coroutines.flow.Flow

interface PostsRepository {

    suspend fun getPosts(): Flow<DataEntity<List<PostsEntity>>>
}