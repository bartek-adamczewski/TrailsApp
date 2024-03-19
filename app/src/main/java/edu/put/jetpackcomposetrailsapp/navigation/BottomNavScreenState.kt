package edu.put.jetpackcomposetrailsapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.State

@Composable
fun NavController.currentRouteAsState(): State<String?> {
    val navBackStackEntry by currentBackStackEntryAsState()
    return remember(navBackStackEntry) {
        derivedStateOf { navBackStackEntry?.destination?.route }
    }
}