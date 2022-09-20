package com.example.diffutils.repository

import com.example.diffutils.api.RetrofitService

class MainRepository(private val retrofitService: RetrofitService) {

    fun getAllPosts() = retrofitService?.getAllPosts()
}