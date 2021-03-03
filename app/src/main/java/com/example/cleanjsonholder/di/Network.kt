package com.example.cleanjsonholder.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

fun createRetrofit(): Retrofit = retrofitClient("https://jsonplaceholder.typicode.com/", httpClient())

private fun httpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    val clientBuilder = OkHttpClient.Builder()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    clientBuilder.addInterceptor(httpLoggingInterceptor)
    clientBuilder.readTimeout(120, TimeUnit.SECONDS)
    clientBuilder.writeTimeout(120, TimeUnit.SECONDS)
    return clientBuilder.build()
}

private fun retrofitClient(url: String, httpClient: OkHttpClient) =
    Retrofit.Builder().baseUrl(url).client(httpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()