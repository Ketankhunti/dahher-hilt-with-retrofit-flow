package com.example.dahher_hilt_with_retrofit_flow.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.dahher_hilt_with_retrofit_flow.model.Post
import com.example.dahher_hilt_with_retrofit_flow.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    lateinit var listPosts:MutableLiveData<List<Post>>
    fun getPosts(){
        viewModelScope.launch {
             repository.getPosts().
            catch { e-> Log.d("main",e.message.toString()) }
                .collect {
                    listPosts.value = it
                }
        }
    }
}