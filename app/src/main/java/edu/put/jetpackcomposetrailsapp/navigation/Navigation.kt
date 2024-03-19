package edu.put.jetpackcomposetrailsapp.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import edu.put.jetpackcomposetrailsapp.composable.details.DetailScreen
import edu.put.jetpackcomposetrailsapp.composable.home.HomeScreen
import edu.put.jetpackcomposetrailsapp.composable.home.TemporaryScreen
import edu.put.jetpackcomposetrailsapp.composable.list.RecyclerViewContent
import edu.put.jetpackcomposetrailsapp.composable.list.RecyclerViewContentTablet
import edu.put.jetpackcomposetrailsapp.composable.list.Trail
import edu.put.jetpackcomposetrailsapp.composable.splash.SplashScreen
import edu.put.jetpackcomposetrailsapp.ui.theme.custom.AppTheme
import edu.put.jetpackcomposetrailsapp.viewmodel.TrailViewModel

@Composable
fun Navigation(navController: NavHostController) {
    val viewModel: TrailViewModel = hiltViewModel()
    Box(modifier = Modifier.background(AppTheme.colorScheme.listBackground)) {
        NavHost(navController = navController, startDestination = "splash_screen") {
            composable("splash_screen") {
                SplashScreen() {
                    navController.navigate(Screen.HomeScreen.route) {
                        popUpTo(0)
                    }
                }
            }
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

                if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Small) {
                    RecyclerViewContent(navController = navController, trails = trails)
                } else {
                    RecyclerViewContentTablet(navController = navController, trails = trails)
                }
            }

            composable(
                route = Screen.DetailsScreen.route,
                arguments = listOf(navArgument("id") { type = NavType.StringType })
            ) { backStackEntry ->

                val trailId = backStackEntry.arguments?.getString("id")?.toInt()
                trailId?.let { viewModel.getTrailById(it) }
                val selectedTrailState =
                    viewModel.uiState.collectAsState(TrailViewModel.State.DEFAULT).value.selectedTrail

                selectedTrailState?.let { selectedTrail ->
                    DetailScreen(navController = navController, selectedTrail = selectedTrail)
                }
            }
            composable(route = Screen.HomeScreen.route) {
                HomeScreen()
            }
            composable(route = Screen.TemporaryScreen.route) {
                TemporaryScreen()
            }
        }
    }
}

