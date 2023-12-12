package com.techullurgy.pollapp.data.network.models

import com.techullurgy.pollapp.network.models.Poll
import kotlinx.serialization.Serializable


@Serializable
data class AnsweredPoll(
    val poll: Poll,
    val answers: List<Long>
)