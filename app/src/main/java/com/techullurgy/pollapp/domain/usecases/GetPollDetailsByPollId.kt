package com.techullurgy.pollapp.domain.usecases

import com.techullurgy.pollapp.data.DataSource
import com.techullurgy.pollapp.network.models.Poll

class GetPollDetailsByPollId(
    private val dataSource: DataSource
) {
    suspend operator fun invoke(pollId: Long): Poll {
        return dataSource.fetchPoll(pollId = pollId).data()
    }
}