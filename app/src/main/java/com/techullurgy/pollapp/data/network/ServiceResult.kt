package com.techullurgy.pollapp.data.network

sealed class ServiceResult<out T> {
    data class Success<T>(val data: T): ServiceResult<T>()
    data class Failure(val errorMessage: String): ServiceResult<Nothing>()

    fun data(): T {
        return when(this) {
            is Success -> data
            is Failure -> throw Exception(errorMessage)
        }
    }
}
