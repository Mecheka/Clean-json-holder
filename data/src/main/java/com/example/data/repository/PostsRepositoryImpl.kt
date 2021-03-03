package com.example.data.repository

import com.example.data.entities.DataResponse
import com.example.domain.entities.DataEntity
import com.example.domain.entities.ErrorEntity
import com.example.domain.entities.PostsEntity
import com.example.domain.repository.PostsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class PostsRepositoryImpl(private val remote: PostsDataStore) : PostsRepository {
    override suspend fun getPosts(): Flow<DataEntity<List<PostsEntity>>> {
        return flow {
            remote.getPosts().collect {
                when (it) {
                    is DataResponse.ERROR -> emit(DataEntity.ERROR<List<PostsEntity>>(ErrorEntity(it.error?.message)))
                    is DataResponse.LOADING -> emit(DataEntity.LOADING<List<PostsEntity>>())
                    is DataResponse.SUCCESS -> emit(DataEntity.SUCCESS(it.data?.map { posts ->
                        PostsEntity(
                            posts.body,
                            posts.id,
                            posts.title,
                            posts.userId
                        )
                    } ?: emptyList()))
                }
            }
        }
    }
}