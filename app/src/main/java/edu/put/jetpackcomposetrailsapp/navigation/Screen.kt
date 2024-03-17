package edu.put.jetpackcomposetrailsapp.navigation

sealed class Screen(val route: String) {
    object ListScreen : Screen("list_screen")
    object DetailsScreen : Screen("details_screen/{id}") {
        fun createRoute(id: String) = "details_screen/${id}"
    }
}