package com.example.dahher_hilt_with_retrofit_flow.repository

import androidx.lifecycle.asLiveData
import com.example.dahher_hilt_with_retrofit_flow.model.Post
import com.example.dahher_hilt_with_retrofit_flow.network.PostApiService
import com.example.dahher_hilt_with_retrofit_flow.network.PostServiceImpl
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(private val postServiceImpl: PostServiceImpl) {
    fun getPosts():Flow<List<Post>> = flow {
        val response  =  postServiceImpl.getPosts()
        emit(response)
    }.flowOn(IO)
}