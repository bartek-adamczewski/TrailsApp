package edu.put.jetpackcomposetrailsapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.put.jetpackcomposetrailsapp.navigation.Navigation
import edu.put.jetpackcomposetrailsapp.navigation.Screen
import edu.put.jetpackcomposetrailsapp.navigation.currentRouteAsState
import edu.put.jetpackcomposetrailsapp.ui.theme.JetpackComposeTrailsAppTheme
import edu.put.jetpackcomposetrailsapp.ui.theme.custom.AppTheme
import edu.put.jetpackcomposetrailsapp.viewmodel.TrailViewModel

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String
)

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedCrossfadeTargetStateParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val viewModel: TrailViewModel = hiltViewModel()
                val navController = rememberNavController()
                val currentRoute = navController.currentRouteAsState().value

                navController.addOnDestinationChangedListener { _, destination, _ ->
                    when (destination.route) {
                        "splash_screen" -> viewModel.setBottomBarVisibility(false)
                        else -> viewModel.setBottomBarVisibility(true)
                    }
                }

                val bottomBarVisible by viewModel.bottomBarVisible.collectAsState()


                val items = listOf(
                    BottomNavigationItem(
                        title = "Home",
                        selectedIcon = Icons.Filled.Home,
                        unselectedIcon = Icons.Outlined.Home,
                        route = Screen.HomeScreen.route
                    ),
                    BottomNavigationItem(
                        title = "Beginner",
                        selectedIcon = Icons.Filled.CheckCircle,
                        unselectedIcon = Icons.Outlined.CheckCircle,
                        route = Screen.ListScreen.route
                    ),
                    BottomNavigationItem(
                        title = "Advanced",
                        selectedIcon = Icons.Filled.Warning,
                        unselectedIcon = Icons.Outlined.Warning,
                        route = Screen.TemporaryScreen.route
                    )

                )

                var selectedItemIndex by rememberSaveable { mutableStateOf(0) }


                Scaffold(
                    bottomBar = {
                        if (bottomBarVisible) {
                            Surface(
                                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                                border = BorderStroke(3.dp, AppTheme.colorScheme.border),
                                modifier = Modifier.background(AppTheme.colorScheme.listBackground) // Dopasowanie koloru tła
                            ) {
                                BottomNavigationBar(items, selectedItemIndex) { selectedIndex ->
                                    selectedItemIndex = selectedIndex
                                    navController.navigate(items[selectedIndex].route) {
                                        popUpTo(navController.graph.startDestinationId)
                                        launchSingleTop = true
                                    }
                                }
                            }
                        }
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = { onItemSelected(index) },
                label = { Text(text = item.title) },
                icon = {
                    Icon(
                        imageVector = if (selectedItemIndex == index) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.title
                    )
                }
            )
        }
    }

}