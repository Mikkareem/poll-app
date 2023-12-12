package com.techullurgy.pollapp.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class PollQuestion(
    val id: Long,
    val question: String,
    val options: List<PollOption>
)