package com.example.data.repository

import com.example.data.api.RemotePostsApi
import com.example.data.entities.DataResponse
import com.example.data.entities.ErrorResponse
import com.example.data.entities.Posts
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostsRemoteImpl(private val api: RemotePostsApi) : PostsDataStore {
    override suspend fun getPosts(): Flow<DataResponse<List<Posts>>> {
        return flow {
            emit(DataResponse.LOADING())
            try {
                val data = api.getPosts()
                if (data.isSuccessful) {
                    emit(DataResponse.SUCCESS(data.body()))
                } else {
                    emit(DataResponse.ERROR<List<Posts>>(ErrorResponse(data.message())))
                }
            } catch (e: Exception) {
                emit(DataResponse.ERROR<List<Posts>>(ErrorResponse(e.message)))
            }

        }
    }
}