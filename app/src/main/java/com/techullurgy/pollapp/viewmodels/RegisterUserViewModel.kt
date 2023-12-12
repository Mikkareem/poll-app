package com.techullurgy.pollapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techullurgy.pollapp.domain.usecases.RegisterUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RegisterUserViewModel: ViewModel(), KoinComponent {
    val registerUserUseCase by inject<RegisterUserUseCase>()

    private val _registerScreenStateFlow = MutableStateFlow(RegisterScreenState())
    val registerScreenStateFlow = _registerScreenStateFlow.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    fun onUsernameChange(newUsername: String) {
        _registerScreenStateFlow.update {
            it.copy(
                username = newUsername,
                error = ""
            )
        }
    }

    fun onPasswordChange(newPassword: String) {
        _registerScreenStateFlow.update {
            it.copy(
                password = newPassword,
                error = ""
            )
        }
    }

    fun onConfirmPasswordChange(newConfirmPassword: String) {
        _registerScreenStateFlow.update {
            it.copy(
                confirmPassword = newConfirmPassword,
                error = ""
            )
        }
    }

    fun onAgeChange(newAge: Int) {
        _registerScreenStateFlow.update {
            it.copy(
                age = newAge,
                error = ""
            )
        }
    }

    fun onRegister(onSuccess: () -> Unit) {
        _isLoading.update { true }

        viewModelScope.launch {
            val result = registerUserUseCase(
                username = _registerScreenStateFlow.value.username,
                password = _registerScreenStateFlow.value.password,
                confirmPassword = _registerScreenStateFlow.value.confirmPassword,
                age = _registerScreenStateFlow.value.age,
            ).data()

            _isLoading.update { false }
            if(result) {
                onSuccess()
            }
        }.invokeOnCompletion { throwable ->
            throwable?.let {
                println(it.message)
                println(it.localizedMessage)

                _registerScreenStateFlow.update { state ->
                    state.copy(
                        error = it.localizedMessage ?: "NNNull"
                    )
                }
            }
            _isLoading.update { false }
        }
    }
}

data class RegisterScreenState(
    val username: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val age: Int = 18,
    val error: String = ""
)