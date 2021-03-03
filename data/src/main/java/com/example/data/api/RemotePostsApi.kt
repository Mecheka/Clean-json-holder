package com.example.data.api

import com.example.data.entities.Posts
import retrofit2.Response
import retrofit2.http.GET

interface RemotePostsApi {

    @GET("posts")
    suspend fun getPosts(): Response<List<Posts>>
}