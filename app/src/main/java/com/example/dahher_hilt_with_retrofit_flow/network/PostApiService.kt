package com.example.dahher_hilt_with_retrofit_flow.network

import com.example.dahher_hilt_with_retrofit_flow.model.Post
import retrofit2.http.GET

interface PostApiService {

    @GET("posts/")
    suspend fun getPosts():List<Post>
}