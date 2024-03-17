package edu.put.jetpackcomposetrailsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.put.jetpackcomposetrailsapp.database.entity.TrailEntity
import edu.put.jetpackcomposetrailsapp.repository.TrailRepository
import edu.put.jetpackcomposetrailsapp.composable.list.Trail
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrailViewModel @Inject constructor(
    private val repository: TrailRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(State.DEFAULT)
    val uiState: Flow<State> = _uiState
    private val eventChannel = Channel<Event>(Channel.CONFLATED)
    val events = eventChannel.receiveAsFlow()

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
        val selectedTrail: TrailEntity?
    ) {
        companion object {
            val DEFAULT = State(
                trails = emptyList(),
                selectedTrail = null
            )
        }
    }

    sealed class Event {

    }
}
