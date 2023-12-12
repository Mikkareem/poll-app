package com.techullurgy.pollapp.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techullurgy.pollapp.domain.usecases.GetPollDetailsByPollId
import com.techullurgy.pollapp.domain.usecases.RegisterUserUseCase
import com.techullurgy.pollapp.network.models.Poll
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.lang.IllegalArgumentException
import java.net.ConnectException
import java.util.concurrent.CancellationException

class PollDetailViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel(), KoinComponent {
    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> get() = _isLoading.asStateFlow()

    private val _pollDetailScreenStateFlow = MutableStateFlow(PollDetailScreenState())
    val pollDetailScreenStateFlow: StateFlow<PollDetailScreenState> get() = _pollDetailScreenStateFlow.asStateFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        when(exception) {
            is ConnectException -> {
                _pollDetailScreenStateFlow.update { it.copy(networkState = false) }
            }
            else -> {
                exception.localizedMessage!!
            }
        }
        _isLoading.update { false }
    }

    private val getPollDetailsByPollId by inject<GetPollDetailsByPollId>()

    init {
        val pollId = savedStateHandle.get<Long>(KEY_POLL_ID) ?: -1L
        _isLoading.update { true }
        viewModelScope.launch(coroutineExceptionHandler) {
            if(pollId == -1L) throw IllegalArgumentException("Poll Id is missing")

            getPollDetailsByPollId(pollId = pollId)
        }
    }

    companion object {
        const val KEY_POLL_ID = "KEY_POLL_ID"
    }
}

data class PollDetailScreenState(
    val poll: Poll = emptyPoll,
    val selectedIndices: List<Int> = emptyList(),
    val networkState: Boolean = true
)

private val emptyPoll = Poll(id = -1, name = "", description = "", questions = emptyList())