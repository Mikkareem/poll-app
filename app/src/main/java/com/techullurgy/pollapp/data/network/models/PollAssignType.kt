package com.techullurgy.pollapp.network.models

import kotlinx.serialization.Serializable

@Serializable
enum class PollAssignType {
    GROUP, USER
}