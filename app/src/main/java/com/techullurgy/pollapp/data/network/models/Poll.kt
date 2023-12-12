package com.techullurgy.pollapp.network.models

import com.techullurgy.pollapp.data.network.models.PollQuestion
import kotlinx.serialization.Serializable

@Serializable
data class Poll(
    val id: Long,
    val name: String,
    val description: String,
    val questions: List<PollQuestion>
)
