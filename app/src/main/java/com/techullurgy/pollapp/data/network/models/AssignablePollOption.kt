package com.techullurgy.pollapp.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class AssignablePollOption(
    val optionName: String,
    val optionIndex: Int
)