package com.techullurgy.pollapp.network.responses

import kotlinx.serialization.Serializable

@Serializable
data class CreateGroupSuccessResponse(
    val success: Boolean = true,
    val groupId: Long,
    val createdBy: Long
)
