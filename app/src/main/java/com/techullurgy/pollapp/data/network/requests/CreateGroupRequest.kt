package com.techullurgy.pollapp.network.requests

import kotlinx.serialization.Serializable

@Serializable
data class CreateGroupRequest(
    val groupName: String,
    val ownerId: Long
)
