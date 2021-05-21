package com.example.cleanjsonholder.di

import androidx.core.app.ActivityCompat
import com.example.domain.repository.PostsRepository
import com.example.domain.usecase.GetPostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun providesGetPostsUseCase(postsRepository: PostsRepository): GetPostsUseCase {
        return GetPostsUseCase(postsRepository)
    }
}