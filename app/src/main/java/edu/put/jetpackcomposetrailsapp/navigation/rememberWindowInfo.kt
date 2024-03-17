package edu.put.jetpackcomposetrailsapp.navigation

import android.health.connect.datatypes.HeightRecord
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun rememberWindowInfo(): WindowInfo {
    val configuration = LocalConfiguration.current
    return WindowInfo(

        screenWidthInfo = when {
            configuration.screenWidthDp < 600 -> WindowInfo.WindowType.Small
            configuration.screenWidthDp < 840 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Big
        },

        screenHeightInfo = when {
            configuration.screenHeightDp < 480 -> WindowInfo.WindowType.Small
            configuration.screenHeightDp < 900 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Big
        },

        screenWidth =  configuration.screenWidthDp.dp,
        screenHeight = configuration.screenHeightDp.dp

    )
}

data class WindowInfo(
    val screenWidthInfo: WindowType,
    val screenHeightInfo: WindowType,
    val screenWidth: Dp,
    val screenHeight: Dp
) {
    sealed class WindowType {
        object Small: WindowType()
        object Medium: WindowType()
        object Big: WindowType()
    }
}