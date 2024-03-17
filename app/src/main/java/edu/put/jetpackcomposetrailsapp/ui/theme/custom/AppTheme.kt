package edu.put.jetpackcomposetrailsapp.ui.theme.custom

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import edu.put.jetpackcomposetrailsapp.ui.theme.BackgroundList
import edu.put.jetpackcomposetrailsapp.ui.theme.Border

private val darkColorScheme = AppColorScheme(
    listBackground = BackgroundList,
    border = Border,
    element = Color.White
)

private val lightColorScheme = AppColorScheme(
    listBackground = BackgroundList,
    border = Border,
    element = Color.White
)

private val typography = AppTypography(
    details = TextStyle(
        color = Color.DarkGray,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        letterSpacing = 0.25.sp
    ),
    name = TextStyle(
        color = Color.DarkGray,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp
    )
)

private val size = AppSize(
    large = 24.dp,
    big = 16.dp,
    medium = 12.dp,
    small = 8.dp
)

@Composable
fun AppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colorScheme = if (isDarkTheme) darkColorScheme else lightColorScheme
    val rippleIndication = rememberRipple()

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isDarkTheme
    val statusBarColor = colorScheme.listBackground

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = statusBarColor,
            darkIcons = useDarkIcons
        )
    }
    CompositionLocalProvider(
        LocalAppColorScheme provides colorScheme,
        LocalAppTypography provides typography,
        LocalAppSize provides size,
        LocalIndication provides rippleIndication,
        content = content
    )
}

object AppTheme {

    val colorScheme: AppColorScheme
        @Composable get() = LocalAppColorScheme.current

    val typography: AppTypography
        @Composable get() = LocalAppTypography.current

    val size: AppSize
        @Composable get() = LocalAppSize.current

}

