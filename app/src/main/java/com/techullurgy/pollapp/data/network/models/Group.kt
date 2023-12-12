package com.techullurgy.pollapp.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Group(
    val id: Long = -1,
    val name: String,
    val owner: User,
    val members: List<User>
)
