package edu.put.jetpackcomposetrailsapp.ui.theme.custom

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp


data class AppColorScheme(
    val listBackground: Color,
    val border: Color,
    val element: Color
)

data class AppTypography(
    val name: TextStyle,
    val details: TextStyle
)

data class AppSize(
    val large: Dp,
    val big: Dp,
    val medium: Dp,
    val small: Dp
)

val LocalAppColorScheme = staticCompositionLocalOf {
    AppColorScheme(
        listBackground = Color.Unspecified,
        border = Color.Unspecified,
        element = Color.Unspecified
    )
}

val LocalAppTypography = staticCompositionLocalOf {
    AppTypography(
        name = TextStyle.Default,
        details = TextStyle.Default
    )
}

val LocalAppSize = staticCompositionLocalOf {
    AppSize(
        large = Dp.Unspecified,
        big = Dp.Unspecified,
        medium = Dp.Unspecified,
        small = Dp.Unspecified
    )
}