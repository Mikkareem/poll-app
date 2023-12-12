package com.techullurgy.pollapp.data.network

import com.techullurgy.pollapp.data.DataSource
import com.techullurgy.pollapp.data.network.models.AssignablePoll
import com.techullurgy.pollapp.data.network.models.User
import com.techullurgy.pollapp.network.models.Poll
import com.techullurgy.pollapp.network.requests.AddUserToGroupRequest
import com.techullurgy.pollapp.network.requests.AssignPollRequest
import com.techullurgy.pollapp.network.requests.CreateGroupRequest
import com.techullurgy.pollapp.network.requests.SubmitPollAnswersRequest
import com.techullurgy.pollapp.network.responses.CreateGroupSuccessResponse
import com.techullurgy.pollapp.network.responses.CreatePollSuccessResponse
import com.techullurgy.pollapp.network.responses.LoginSuccessResponse
import com.techullurgy.pollapp.network.responses.PollAssignResponse
import com.techullurgy.pollapp.network.responses.PollResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.ConnectException

class PollNetworkDataSource(
    private val httpClient: HttpClient,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): DataSource {

    override suspend fun getAllAssignedPolls(): ServiceResult<List<PollResponse>> {
        return withContext(ioDispatcher) {
            try {
                val response = httpClient.get(Endpoint.FetchAssignedPollsForUser.endpoint)
                val polls = response.body<List<PollResponse>>()
                ServiceResult.Success(polls)
            } catch(ce: ConnectException) {
                ce.printStackTrace()
                ServiceResult.Failure(errorMessage = "Couldn't connect to the internet")
            }
        }
    }

    override suspend fun fetchPoll(pollId: Long): ServiceResult<Poll>
            = withContext(ioDispatcher){
                try {
                    val response = httpClient.get(Endpoint.FetchPollDetailById(pollId).endpoint)
                    val pollDetail = response.body<Poll>()
                    ServiceResult.Success(pollDetail)
                } catch(ce: ConnectException) {
                    ce.printStackTrace()
                    ServiceResult.Failure(errorMessage = "Couldn't connect to the internet")
                }
            }

    override suspend fun registerUser(username: String, age: Int, password: String): ServiceResult<User> {
        TODO("Not yet implemented")
    }

    override suspend fun loginUser(
        username: String,
        password: String
    ): ServiceResult<LoginSuccessResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun createPoll(request: AssignablePoll): ServiceResult<CreatePollSuccessResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun assignPoll(request: AssignPollRequest): ServiceResult<PollAssignResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun submitPoll(request: SubmitPollAnswersRequest): ServiceResult<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun createGroup(request: CreateGroupRequest): ServiceResult<CreateGroupSuccessResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun addUserToGroup(request: AddUserToGroupRequest): ServiceResult<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun getGroupMembers(groupId: Long): ServiceResult<List<User>> {
        TODO("Not yet implemented")
    }

    override suspend fun logout(): ServiceResult<Boolean> {
        TODO("Not yet implemented")
    }
}