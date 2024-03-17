package edu.put.jetpackcomposetrailsapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import edu.put.jetpackcomposetrailsapp.composable.DetailScreen
import edu.put.jetpackcomposetrailsapp.composable.list.RecyclerViewContent
import edu.put.jetpackcomposetrailsapp.composable.list.RecyclerViewContentTablet
import edu.put.jetpackcomposetrailsapp.composable.list.Trail
import edu.put.jetpackcomposetrailsapp.viewmodel.TrailViewModel

@Composable
fun Navigation() {

    val navController = rememberNavController()
    val viewModel: TrailViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Screen.ListScreen.route) {
        composable(
            route = Screen.ListScreen.route
        ) {

            val trails = remember { mutableStateListOf<Trail>() }
            LaunchedEffect(key1 = viewModel) {
                viewModel.uiState.collect { state ->
                    trails.addAll(state.trails)
                }
            }

            val windowInfo = rememberWindowInfo()

            if(windowInfo.screenWidthInfo is WindowInfo.WindowType.Small) {
                RecyclerViewContent(navController = navController, trails = trails)
            }
            else {
                RecyclerViewContentTablet(navController = navController, trails = trails)
            }
        }

        composable(
            route = Screen.DetailsScreen.route,
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->

            val trailId = backStackEntry.arguments?.getString("id")?.toInt()
            trailId?.let { viewModel.getTrailById(it) }
            val selectedTrailState = viewModel.uiState.collectAsState(TrailViewModel.State.DEFAULT).value.selectedTrail

            selectedTrailState?.let { selectedTrail ->
                DetailScreen(navController = navController, selectedTrail = selectedTrail)
            }
        }
    }
}

