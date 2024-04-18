package com.example.labb_3_android.api

data class NewsItem(
    val id: Int,
    val published: Long,
    val type: Int,
    val tagIds: List<Int>,
    val message: String
)

