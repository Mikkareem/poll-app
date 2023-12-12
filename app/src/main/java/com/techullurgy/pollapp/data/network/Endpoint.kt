package com.techullurgy.pollapp.data.network

sealed class Endpoint(path: String) {

    val endpoint: String = "$BASE_URL/$path"

    companion object {
        private const val BASE_URL = "http://10.0.2.2/8080/"
        const val AUTHORIZATION_NEEDED = "/********"

        private fun getAuthorizationEndpointPath(actualPath: String): String = "$actualPath$AUTHORIZATION_NEEDED"
    }

    data class FetchPollDetailById(val id: Long): Endpoint(getAuthorizationEndpointPath("poll/$id"))
    object FetchAssignedPollsForUser: Endpoint(getAuthorizationEndpointPath("polls/assigned"))
    object SubmitPollCreation: Endpoint(getAuthorizationEndpointPath("poll/create"))
    object AssignPoll: Endpoint(getAuthorizationEndpointPath("poll/assign"))
    object SubmitPollAnswers: Endpoint(getAuthorizationEndpointPath("poll/submit"))

    object CreateGroup: Endpoint(getAuthorizationEndpointPath("group/create"))
    object AddUserToGroup: Endpoint(getAuthorizationEndpointPath("group/add"))
    data class GetGroupMembers(val groupId: String): Endpoint(getAuthorizationEndpointPath("group/$groupId"))

    data class Register(val username: String, val password: String, val age: Int): Endpoint("register?username=$username&password=$password&age=$age")
    data class Login(val username: String, val password: String): Endpoint("login?username=$username&password=$password")
    object Logout: Endpoint(getAuthorizationEndpointPath("logout"))
}