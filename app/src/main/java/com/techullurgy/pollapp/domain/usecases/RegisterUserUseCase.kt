package com.techullurgy.pollapp.domain.usecases

import com.techullurgy.pollapp.data.DataSource
import com.techullurgy.pollapp.data.network.ServiceResult

class RegisterUserUseCase(
    private val dataSource: DataSource
) {
    suspend operator fun invoke(username: String, age: Int, password: String, confirmPassword: String): ServiceResult<Boolean> {
        if(password.length < 8) {
            return ServiceResult.Failure("Password must be 8 characters long")
        }

        if(password != confirmPassword) {
            return ServiceResult.Failure("Passwords don't match")
        }

        dataSource.registerUser(username = username, age = age, password = password).data()
        return ServiceResult.Success(true)
    }
}