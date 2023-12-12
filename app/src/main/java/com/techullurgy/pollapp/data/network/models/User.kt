package com.techullurgy.pollapp.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Long = -1,
    val name: String,
    val age: Int
)