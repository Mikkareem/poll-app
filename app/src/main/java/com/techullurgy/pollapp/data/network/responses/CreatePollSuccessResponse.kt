package com.techullurgy.pollapp.network.responses

import kotlinx.serialization.Serializable

@Serializable
data class CreatePollSuccessResponse(
    val success: Boolean = true,
    val pollId: Long,
    val createdBy: Long
)
