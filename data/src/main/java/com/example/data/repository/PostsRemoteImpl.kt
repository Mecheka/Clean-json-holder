package com.example.data.repository

import com.example.data.api.RemotePostsApi
import com.example.domain.entities.DataEntity
import com.example.domain.entities.ErrorEntity
import com.example.domain.entities.PostsEntity
import com.example.domain.repository.PostsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostsRemoteImpl @Inject constructor(private val api: RemotePostsApi): PostsRepository {
    override suspend fun getPosts(): Flow<DataEntity<List<PostsEntity>>> {
        return flow {
            emit(DataEntity.LOADING)
            try {
                val data = api.getPosts()
                if (data.isSuccessful) {
                    emit(DataEntity.SUCCESS(data.body()?.map { PostsEntity(it.body, it.id, it.title, it.userId) }?: listOf()))
                } else {
                    emit(DataEntity.ERROR(ErrorEntity(data.message())))
                }
            } catch (e: Exception) {
                emit(DataEntity.ERROR(ErrorEntity(e.message)))
            }

        }
    }
}