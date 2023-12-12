package com.techullurgy.pollapp.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techullurgy.pollapp.R
import com.techullurgy.pollapp.components.AnswerablePollOptions
import com.techullurgy.pollapp.components.PollTitle
import com.techullurgy.pollapp.data.network.models.PollOption
import com.techullurgy.pollapp.data.network.models.PollQuestion
import com.techullurgy.pollapp.network.models.Poll

@Composable
fun PollDetailScreen(

) {

}


@ExperimentalFoundationApi
@Composable
private fun PollDetailScreen(
    poll: Poll
) {
    val pagerState = rememberPagerState { poll.questions.size }
    val selectedIndices = remember {
        mutableStateListOf<Int>().also {
            poll.questions.forEach { _ -> it.add(-1) }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ra_polls),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = poll.name, fontSize = 23.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = poll.description, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Question ${pagerState.currentPage + 1}/${poll.questions.size}",
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Magenta,
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(16.dp))

        HorizontalPager(state = pagerState) { index ->
            val currentQuestion = poll.questions[index]
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(30f))
                    .background(Color(0xffcf9fff))
            ) {
                PollTitle(title = currentQuestion.question)
                AnswerablePollOptions(
                    options = currentQuestion.options.map { it.optionName },
                    onOptionSelect = {
                        selectedIndices[index] = it
                    },
                    selectedIndex = selectedIndices[index]
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                ),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Cancel")
            }
            AnimatedVisibility(visible = pagerState.currentPage == poll.questions.size - 1) {
                Button(
                    enabled = !selectedIndices.contains(-1),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "Submit")
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun PollDetailScreenPreview(
    @PreviewParameter(PollPreviewParameterProvider::class) poll: Poll
) {
    PollDetailScreen(poll = poll)
}

private class PollPreviewParameterProvider: PreviewParameterProvider<Poll> {
    override val count: Int
        get() = 1
    override val values: Sequence<Poll>
        get() = sequenceOf(
            Poll(
                id = 1,
                name = "General Poll",
                description = "General Poll which needs to know about your feedback on today's events.",
                questions = listOf(
                    PollQuestion(
                        id = 1,
                        question = "How is today?",
                        options = listOf(
                            PollOption(id = 1, optionName = "Bad", optionIndex = 1),
                            PollOption(id = 2, optionName = "Normal", optionIndex = 2),
                            PollOption(id = 3, optionName = "Good", optionIndex = 3),
                            PollOption(id = 4, optionName = "Very Good", optionIndex = 4),
                        )
                    ),
                    PollQuestion(
                        id = 2,
                        question = "How is yesterday?",
                        options = listOf(
                            PollOption(id = 5, optionName = "Bad 1", optionIndex = 1),
                            PollOption(id = 6, optionName = "Normal 1", optionIndex = 2),
                            PollOption(id = 7, optionName = "Good 1", optionIndex = 3),
                            PollOption(id = 8, optionName = "Very Good 1", optionIndex = 4),
                        )
                    ),
                    PollQuestion(
                        id = 3,
                        question = "How is day 2?",
                        options = listOf(
                            PollOption(id = 9, optionName = "Bad 2", optionIndex = 1),
                            PollOption(id = 10, optionName = "Normal 2", optionIndex = 2),
                            PollOption(id = 11, optionName = "Good 2", optionIndex = 3),
                            PollOption(id = 12, optionName = "Very Good 2", optionIndex = 4),
                        )
                    ),
                    PollQuestion(
                        id = 4,
                        question = "How is day 3?",
                        options = listOf(
                            PollOption(id = 13, optionName = "Bad 3", optionIndex = 1),
                            PollOption(id = 14, optionName = "Normal 3", optionIndex = 2),
                            PollOption(id = 15, optionName = "Good 3", optionIndex = 3),
                            PollOption(id = 16, optionName = "Very Good 3", optionIndex = 4),
                        )
                    )
                )
            )
        )
}