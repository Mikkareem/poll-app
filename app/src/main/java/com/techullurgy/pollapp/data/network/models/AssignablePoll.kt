package com.techullurgy.pollapp.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class AssignablePoll(
    val name: String,
    val description: String,
    val questions: List<AssignablePollQuestion>
)