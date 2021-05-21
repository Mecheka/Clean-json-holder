package com.example.cleanjsonholder.di

import com.example.data.repository.PostsRemoteImpl
import com.example.domain.repository.PostsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPostsRemote(impl: PostsRemoteImpl): PostsRepository
}