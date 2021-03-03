package com.example.domain.usecase

import com.example.domain.entities.DataEntity
import com.example.domain.entities.PostsEntity
import com.example.domain.repository.PostsRepository
import kotlinx.coroutines.flow.Flow

class GetPostsUseCase(private val repository: PostsRepository) {

    suspend operator fun invoke(): Flow<DataEntity<List<PostsEntity>>> {
        return repository.getPosts()
    }
}