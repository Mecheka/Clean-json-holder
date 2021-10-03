package com.example.cleanjsonholder.di

import com.example.cleanjsonholder.MainViewModel
import com.example.data.api.RemotePostsApi
import com.example.data.repository.PostsDataStore
import com.example.data.repository.PostsRemoteImpl
import com.example.data.repository.PostsRepositoryImpl
import com.example.domain.repository.PostsRepository
import com.example.domain.usecase.GetPostsUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    factory<PostsDataStore> { PostsRemoteImpl(get()) }
    factory<PostsRepository> { PostsRepositoryImpl(get()) }
}

val usecaseModule = module {
    factory { GetPostsUseCase(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val networkModule = module {
    single<RemotePostsApi> { createRetrofit().create(RemotePostsApi::class.java) }
}