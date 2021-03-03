package com.example.cleanjsonholder

import android.app.Application
import com.example.cleanjsonholder.di.networkModule
import com.example.cleanjsonholder.di.repositoryModule
import com.example.cleanjsonholder.di.usecaseModule
import com.example.cleanjsonholder.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PostsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@PostsApplication)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    usecaseModule,
                    viewModelModule
                )
            )
        }
    }
}