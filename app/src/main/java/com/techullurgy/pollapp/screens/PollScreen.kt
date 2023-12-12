package com.techullurgy.pollapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.techullurgy.pollapp.components.AnswerablePollOptions
import com.techullurgy.pollapp.components.PollTitle

@Preview
@Composable
fun PollScreen() {
    var selectedIndex by remember { mutableIntStateOf(-1) }

    val options = remember { listOf("C++", "Python", "Java", "Kotlin") }

    Column(
        modifier = Modifier.background(Color.White)
    ) {
        PollTitle(title = "Which of the following languages You like most?")
        AnswerablePollOptions(
            options = options,
            onOptionSelect = { selectedIndex = it },
            selectedIndex = selectedIndex
        )
    }
}
