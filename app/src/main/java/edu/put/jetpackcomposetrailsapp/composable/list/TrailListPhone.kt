package edu.put.jetpackcomposetrailsapp.composable.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import edu.put.jetpackcomposetrailsapp.navigation.Screen
import edu.put.jetpackcomposetrailsapp.ui.theme.custom.AppTheme
import kotlinx.coroutines.delay

@Composable
fun RecyclerViewContent (navController: NavController, trails: List<Trail>) {

    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        isVisible = true
    }

    Box(
        modifier = Modifier.background(AppTheme.colorScheme.listBackground)
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(animationSpec = tween(durationMillis = 1000)) // Customize the animation as needed
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.background(Color(0xFF37474F))
            ) {
                LazyVerticalGrid(
                    modifier = Modifier
                        .background(Color(0xFF37474F)),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    columns = GridCells.Fixed(2),
                ) {
                    items(trails.size) { index ->
                        val trail = trails[index]
                        Surface(
                            color = AppTheme.colorScheme.listBackground,
                            modifier = Modifier
                                .clickable {
                                    navController.navigate(Screen.DetailsScreen.createRoute(trail.id.toString()))
                                }
                                .padding(4.dp)
                        ) {
                            TrailListItem(trail = trail)
                        }
                    }
                }
            }
        }
    }
}