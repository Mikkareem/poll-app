package com.techullurgy.pollapp.components

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
internal fun ResultedPollOptions(
    options: List<String>,
    resultIndex: Int,
    pollResults: List<Int>
) {
    Column {
        options.forEachIndexed { index, option ->
            ResultedPollOption(
                option = option,
                resultPercentage = pollResults[index],
                isSelectedAnswer = index == resultIndex
            )
            if(index != options.lastIndex) {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
private fun ResultedPollOption(
    option: String,
    resultPercentage: Int,
    isSelectedAnswer: Boolean
) {
    val animatedPercentage by animateIntAsState(
        targetValue = resultPercentage,
        label = "",
        animationSpec = tween(durationMillis = 2000)
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                drawRoundRect(
                    color = if (isSelectedAnswer) Color.Green else Color.LightGray,
                    cornerRadius = CornerRadius(30f),
                    size = Size(size.width * (animatedPercentage / 100f), size.height)
                )
            }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = isSelectedAnswer,
                onClick = { },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Magenta,
                    unselectedColor = Color.Blue
                )
            )
            Text(text = option, fontSize = 24.sp, fontWeight = FontWeight.Medium)
        }
        Text(text = "$animatedPercentage%", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
    }
}