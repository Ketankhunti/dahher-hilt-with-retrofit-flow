package com.example.dahher_hilt_with_retrofit_flow.network

import com.example.dahher_hilt_with_retrofit_flow.model.Post
import javax.inject.Inject

class PostServiceImpl @Inject constructor(private val apiService: PostApiService){

    suspend fun getPosts() = apiService.getPosts()
}