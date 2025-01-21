package com.example.apppost2.data.models

data class Post (
    val id: Int,
    val title: String,
    val content: String,
    val ower_id: Int
)

data class CreatePostRequest(
    val title: String,
    val content: String,
)