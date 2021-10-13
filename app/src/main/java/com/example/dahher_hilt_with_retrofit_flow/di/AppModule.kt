package com.example.dahher_hilt_with_retrofit_flow.di

import com.example.dahher_hilt_with_retrofit_flow.network.PostApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

     @Provides
    fun BASE_URL():String="https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun providesRetrofit(baseUrl:String):Retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    @Provides
    fun providesApiService(retrofit: Retrofit): PostApiService = retrofit.create(PostApiService::class.java)

}