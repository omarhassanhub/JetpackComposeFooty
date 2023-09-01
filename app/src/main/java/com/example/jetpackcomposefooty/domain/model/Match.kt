package com.example.jetpackcomposefooty.domain.model

data class Match(
    val data: List<Data>
)

data class Data(
    val code: String?,
    val continent: String,
    val id: Int,
    val name: String,
    val sub_region: String?
)
