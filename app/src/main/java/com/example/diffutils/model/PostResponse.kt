package com.example.diffutils.model

data class PostResponse(
    val body: String?=null,
    val id: Int,
    val title: String?,
    val userId: Int
)