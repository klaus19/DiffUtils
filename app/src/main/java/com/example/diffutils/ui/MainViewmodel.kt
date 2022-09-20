package com.example.diffutils.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.diffutils.model.PostResponse
import com.example.diffutils.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewmodel(private val mainRepository: MainRepository):ViewModel() {

    val _postResponseData = MutableLiveData<List<PostResponse>>()
    val postResponse:LiveData<List<PostResponse>>get()  = _postResponseData

    init {
        getPosts()
    }

    private fun getPosts() {
        mainRepository?.getAllPosts()?.enqueue(object :
        Callback<List<PostResponse>>{
            override fun onResponse(
                call: Call<List<PostResponse>>,
                response: Response<List<PostResponse>>
            ) {
                _postResponseData.postValue(response?.body())
            }

            override fun onFailure(call: Call<List<PostResponse>>, t: Throwable) {
                t.stackTrace
            }

        })
    }


}