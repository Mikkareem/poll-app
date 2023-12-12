package com.techullurgy.pollapp.network.requests

import kotlinx.serialization.Serializable

@Serializable
data class AddUserToGroupRequest(
    val groupId: Long,
    val userId: Long
)