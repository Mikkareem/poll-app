package com.techullurgy.pollapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techullurgy.pollapp.R
import com.techullurgy.pollapp.components.AppTextInput
import com.techullurgy.pollapp.viewmodels.RegisterUserViewModel

@Composable
fun RegisterUserScreen(
    viewModel: RegisterUserViewModel,
    onRegistrationSuccessNavigation: () -> Unit
) {
    val state by viewModel.registerScreenStateFlow.collectAsState()

    StatelessRegisterUserScreen(
        username = state.username,
        age = state.age,
        password = state.password,
        confirmPassword = state.confirmPassword,
        onUsernameChange = viewModel::onUsernameChange,
        onAgeChange = viewModel::onAgeChange,
        onPasswordChange = viewModel::onPasswordChange,
        onConfirmPasswordChange = viewModel::onConfirmPasswordChange,
        onRegister = {},
        onRegisterSuccess = onRegistrationSuccessNavigation
    )
}

@Preview
@Composable
private fun StatelessRegisterUserScreen(
    username: String = "",
    age: Int = 0,
    password: String = "",
    confirmPassword: String = "",
    onUsernameChange: (String) -> Unit = {},
    onAgeChange: (Int) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onConfirmPasswordChange: (String) -> Unit = {},
    error: String = "",
    onRegister: () -> Unit = {},
    onRegisterSuccess: () -> Unit = {},
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 36.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.ra_polls),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(36.dp))
            AppTextInput(
                value = username,
                onValueChange = onUsernameChange,
                placeholderText = "Username",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(14.dp))
            AppTextInput(
                value = if (age == 0) "" else age.toString(),
                onValueChange = { onAgeChange(it.toInt()) },
                placeholderText = "Age",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(14.dp))
            AppTextInput(
                value = password,
                onValueChange = onPasswordChange,
                placeholderText = "Password",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(14.dp))
            AppTextInput(
                value = confirmPassword,
                onValueChange = onConfirmPasswordChange,
                placeholderText = "Confirm Password",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(36.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Register", fontWeight = FontWeight.ExtraBold, fontSize = 21.sp)
            }
            Spacer(modifier = Modifier.height(36.dp))
            Text(text = "Already have an account?", modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Sign in", modifier = Modifier.align(Alignment.CenterHorizontally), color = Color.Blue, fontWeight = FontWeight.Bold)
        }
    }
}