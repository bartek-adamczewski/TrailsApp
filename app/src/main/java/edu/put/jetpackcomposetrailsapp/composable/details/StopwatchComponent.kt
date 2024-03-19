package edu.put.jetpackcomposetrailsapp.composable.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.put.jetpackcomposetrailsapp.viewmodel.TrailViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

@Composable
fun StopwatchComponent(trailId: Int) {
    val viewModel: TrailViewModel = hiltViewModel()
    val isRunning = viewModel.uiState.collectAsState(TrailViewModel.State.DEFAULT).value.isRunning
    val timeElapsed = viewModel.uiState.collectAsState(TrailViewModel.State.DEFAULT).value.timeElapsed

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = formatTime(timeElapsed),
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
        )
        Row {
            Button(onClick = { viewModel.toggleStopwatch() }) {
                Text(text = if (isRunning) "Stop" else "Start")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { viewModel.resetStopwatch() }) {
                Text(text = "Reset")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { viewModel.saveRecordedTimeForTrail(trailId) }) {
                Text(text = "Save")
            }
        }
    }
}

fun formatTime(seconds: Long): String {
    val hours = seconds / 3600
    val minutes = (seconds % 3600) / 60
    val secs = seconds % 60
    return String.format("%02d:%02d:%02d", hours, minutes, secs)
}