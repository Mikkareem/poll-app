package com.techullurgy.pollapp.network.responses

import kotlinx.serialization.Serializable

@Serializable
data class PollAssignResponse(
    val success: Boolean,
    val assignedPollId: Long
)
