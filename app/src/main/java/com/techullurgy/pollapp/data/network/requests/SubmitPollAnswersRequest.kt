package com.techullurgy.pollapp.network.requests

import com.techullurgy.pollapp.data.network.models.AnsweredPoll
import kotlinx.serialization.Serializable

@Serializable
data class SubmitPollAnswersRequest(
    val answeredPoll: AnsweredPoll
)