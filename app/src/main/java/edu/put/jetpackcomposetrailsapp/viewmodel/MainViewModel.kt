package edu.put.jetpackcomposetrailsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.put.jetpackcomposetrailsapp.database.entity.TrailEntity
import edu.put.jetpackcomposetrailsapp.repository.TrailRepository
import edu.put.jetpackcomposetrailsapp.composable.list.Trail
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import javax.inject.Inject

@HiltViewModel
class TrailViewModel @Inject constructor(
    private val repository: TrailRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(State.DEFAULT)
    val uiState: Flow<State> = _uiState
    private val eventChannel = Channel<Event>(Channel.CONFLATED)
    val events = eventChannel.receiveAsFlow()

    private val _bottomBarVisible = MutableStateFlow(false)
    val bottomBarVisible: StateFlow<Boolean> = _bottomBarVisible.asStateFlow()

    fun setBottomBarVisibility(visible: Boolean) {
        _bottomBarVisible.value = visible
    }

    init {
        viewModelScope.launch {
            repository.initializeDatabaseIfNeeded()
            repository.getTrails().collect { trails ->
                val mappedTrails = trails.map { trail ->
                    Trail(
                        id = trail.id,
                        name = trail.name,
                        location = trail.location,
                        description = trail.shortDescription,
                        imageId = trail.imageId
                    )
                }
                _uiState.update { state ->
                    state.copy(trails = mappedTrails)
                }
            }
        }
        handleStopwatch()
    }

    fun toggleStopwatch() {
        val currentState = _uiState.value
        _uiState.value = currentState.copy(isRunning = !currentState.isRunning)
    }

    fun resetStopwatch() {
        _uiState.value = _uiState.value.copy(isRunning = false, timeElapsed = 0L)
    }

    private fun handleStopwatch() {
        viewModelScope.launch {
            while (isActive) {
                if (_uiState.value.isRunning) {
                    delay(1000)
                    _uiState.update { currentState ->
                        currentState.copy(timeElapsed = currentState.timeElapsed + 1)
                    }
                }
                yield()
            }
        }
    }

    fun saveRecordedTimeForTrail(id: Int) {
        viewModelScope.launch {
            val timeElapsed = _uiState.value.timeElapsed
            repository.saveRecordedTime(id, timeElapsed)
            resetStopwatch()
        }
    }

    fun getTrailById(id: Int) {
        viewModelScope.launch {
            val selectedTrail = repository.getTrail(id).firstOrNull()
            _uiState.update { state ->
                state.copy(selectedTrail = selectedTrail)
            }
        }
    }


    data class State(
        val trails: List<Trail>,
        val selectedTrail: TrailEntity?,
        val isRunning: Boolean,
        val timeElapsed: Long
    ) {
        companion object {
            val DEFAULT = State(
                trails = emptyList(),
                selectedTrail = null,
                isRunning = false,
                timeElapsed = 0
            )
        }
    }

    sealed class Event {

    }
}
