package com.techullurgy.pollapp.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppTextInput(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String,
    modifier: Modifier = Modifier,
    maxLines: Int = 1,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholderText) },
        singleLine = maxLines < 2,
        maxLines = maxLines,
        modifier = modifier,
        shape = RoundedCornerShape(30, 30, 0, 0)
    )
}