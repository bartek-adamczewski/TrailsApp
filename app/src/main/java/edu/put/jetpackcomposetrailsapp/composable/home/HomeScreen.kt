package edu.put.jetpackcomposetrailsapp.composable.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.put.jetpackcomposetrailsapp.viewmodel.TrailViewModel

@Composable
fun HomeScreen() {

    val viewModel: TrailViewModel = hiltViewModel()
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        isVisible = true
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(animationSpec = tween(durationMillis = 1000)) // Customize the animation as needed
        ) {
            Text(text = "Home Screen", fontSize = 40.sp)
        }
    }
}

@Composable
fun TemporaryScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Temporary Screen", fontSize = 40.sp)
    }
}