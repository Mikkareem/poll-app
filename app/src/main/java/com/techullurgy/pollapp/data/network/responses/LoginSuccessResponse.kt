package com.techullurgy.pollapp.network.responses

import kotlinx.serialization.Serializable

@Serializable
data class LoginSuccessResponse(
    val userId: Long,
    val token: String,
    val success: Boolean
)
