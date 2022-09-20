package com.example.diffutils.api

import com.example.diffutils.model.PostResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("posts")
    fun getAllPosts():Call<List<PostResponse>>

    companion object{

        var retrofitservice:RetrofitService?=null

        fun getInstance():RetrofitService{

            if (retrofitservice==null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitservice = retrofit.create(RetrofitService::class.java)
            }
           return  retrofitservice!!
        }

    }
}