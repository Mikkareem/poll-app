package com.techullurgy.pollapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
internal fun AnswerablePollOptions(
    options: List<String>,
    onOptionSelect: (Int) -> Unit,
    selectedIndex: Int
) {
    Column {
        options.forEachIndexed { index, option ->
            AnswerablePollOption(
                option = option,
                isSelected = index == selectedIndex,
                onSelect = { onOptionSelect(index) }
            )
            if(index != options.lastIndex) {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
private fun AnswerablePollOption(
    option: String,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(30))
            .clickable { onSelect() }
    ) {
        RadioButton(
            selected = isSelected,
            onClick = { onSelect() },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Magenta,
                unselectedColor = Color.Blue
            )
        )
        Text(text = option, fontSize = 20.sp, fontWeight = FontWeight.Medium)
    }
}