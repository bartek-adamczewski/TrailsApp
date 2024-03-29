package edu.put.jetpackcomposetrailsapp.navigation

sealed class Screen(val route: String) {
    object ListScreen : Screen("list_screen")
    object DetailsScreen : Screen("details_screen/{id}") {
        fun createRoute(id: String) = "details_screen/${id}"
    }

    object HomeScreen: Screen("home_screen")
    object ListScreen2: Screen("list_screen2")
}