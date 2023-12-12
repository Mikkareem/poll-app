package com.techullurgy.pollapp.data

import com.techullurgy.pollapp.data.network.ServiceResult
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

interface DataSource {
    suspend fun getAllAssignedPolls(): ServiceResult<List<PollResponse>>

    suspend fun fetchPoll(pollId: Long): ServiceResult<Poll>

    suspend fun registerUser(username: String, age: Int, password: String): ServiceResult<User>

    suspend fun loginUser(username: String, password: String): ServiceResult<LoginSuccessResponse>

    suspend fun createPoll(request: AssignablePoll): ServiceResult<CreatePollSuccessResponse>

    suspend fun assignPoll(request: AssignPollRequest): ServiceResult<PollAssignResponse>

    suspend fun submitPoll(request: SubmitPollAnswersRequest): ServiceResult<Boolean>

    suspend fun createGroup(request: CreateGroupRequest): ServiceResult<CreateGroupSuccessResponse>

    suspend fun addUserToGroup(request: AddUserToGroupRequest): ServiceResult<Boolean>

    suspend fun getGroupMembers(groupId: Long): ServiceResult<List<User>>

    suspend fun logout(): ServiceResult<Boolean>
}