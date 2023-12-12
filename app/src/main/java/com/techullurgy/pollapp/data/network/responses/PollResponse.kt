package com.techullurgy.pollapp.network.responses

import com.techullurgy.pollapp.network.models.Poll
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class PollResponse(val isCompleted: Boolean) {
    abstract val poll: Poll
}

@Serializable
@SerialName("answered")
data class AnsweredPollResponse(
    override val poll: Poll,
    val answers: List<Long>,
): PollResponse(isCompleted = true)

@Serializable
@SerialName("non-answered")
data class NonAnsweredPollResponse(
    override val poll: Poll
): PollResponse(isCompleted = false)