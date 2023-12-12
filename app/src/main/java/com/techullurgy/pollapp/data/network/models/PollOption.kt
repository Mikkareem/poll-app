package com.techullurgy.pollapp.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class PollOption(
    val id: Long,
    val optionName: String,
    val optionIndex: Int
)
