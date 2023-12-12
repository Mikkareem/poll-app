package com.techullurgy.pollapp.network.requests

import com.techullurgy.pollapp.network.models.PollAssignType
import kotlinx.serialization.Serializable

@Serializable
data class AssignPollRequest(
    val pollId: Long,
    val pollAssignType: PollAssignType,
    val assignId: Long
)
