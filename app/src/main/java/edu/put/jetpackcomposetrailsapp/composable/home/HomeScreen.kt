package edu.put.jetpackcomposetrailsapp.composable.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.put.jetpackcomposetrailsapp.R
import edu.put.jetpackcomposetrailsapp.ui.theme.custom.AppTheme
import edu.put.jetpackcomposetrailsapp.viewmodel.TrailViewModel

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.splashscreenimage),
                contentDescription = "Logo aplikacji",
                modifier = Modifier
                    .size(300.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(20.dp)))
                    .border(
                        5.dp,
                        AppTheme.colorScheme.border,
                        RoundedCornerShape(corner = CornerSize(20.dp))
                    ),
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Szlakownik",
                fontSize = 37.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Aplikacja jest nieocenionym przewodnikiem dla pasjonatów górskich wypraw. Znajdź i odkryj najbardziej malownicze szlaki w polskich górach, a także rzuć sobie wyzwanie, poprawiając swój czas przejścia.",
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Autorzy: Bartosz Adamczewski, Kacper Leporowski",
                fontSize = 14.sp
            )
        }
    }
}


@Composable
fun TemporaryScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Temporary Screen", fontSize = 40.sp)
    }
}