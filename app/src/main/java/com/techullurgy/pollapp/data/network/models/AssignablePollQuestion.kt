package com.techullurgy.pollapp.data.network.models

import com.techullurgy.pollapp.data.network.models.AssignablePollOption
import kotlinx.serialization.Serializable

@Serializable
data class AssignablePollQuestion(
    val question: String,
    val options: List<AssignablePollOption>
)