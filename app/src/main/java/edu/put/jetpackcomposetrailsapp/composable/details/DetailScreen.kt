package edu.put.jetpackcomposetrailsapp.composable.details

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.put.jetpackcomposetrailsapp.database.entity.TrailEntity
import edu.put.jetpackcomposetrailsapp.navigation.Screen
import edu.put.jetpackcomposetrailsapp.ui.theme.custom.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(selectedTrail: TrailEntity, navController: NavController) {
    val context = LocalContext.current
    AppTheme {
        Scaffold(

            topBar = {
                TopAppBar(
                    title = { Text(text = selectedTrail.name) },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate(Screen.ListScreen.route) }) {
                            Icon(Icons.Filled.ArrowBack, "Back")
                        }
                    }
                )
            },

            floatingActionButton = {
                FloatingActionButton(onClick = {
                    Toast.makeText(context, "Camera clicked!", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(Icons.Filled.AddCircle, contentDescription = "Camera")
                }
            }
        ) { padding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
                    .padding(AppTheme.size.medium)
            ) {
                TrailImage(selectedTrail.imageId)
                Spacer(modifier = Modifier.height(AppTheme.size.big))
                Text(
                    text = selectedTrail.shortDescription,
                    style = AppTheme.typography.name
                )
                Spacer(modifier = Modifier.height(AppTheme.size.small))
                Text(
                    modifier = Modifier.padding(horizontal = AppTheme.size.large),
                    text = selectedTrail.longDescription,
                    style = AppTheme.typography.details
                )
                Spacer(modifier = Modifier.height(AppTheme.size.small))
                Text(
                    text = "Czas przejścia: ${selectedTrail.walkTime} min",
                    style = AppTheme.typography.details
                )
                Spacer(modifier = Modifier.height(AppTheme.size.small))
                StopwatchComponent(selectedTrail.id)

                val recordText = if (selectedTrail.recordedTime == null || selectedTrail.recordedTime == 0L) {
                    "Szlak nie posiada rekordu"
                } else {
                    "Aktualny rekord szlaku wynosi: ${formatTime(selectedTrail.recordedTime)}"
                }

                Text(
                    text = recordText,
                    style = AppTheme.typography.details,
                    modifier = Modifier.padding(AppTheme.size.medium)
                )
            }
        }
    }
}

@Composable
private fun TrailImage(imageId: Int) {
    val context = LocalContext.current
    val imageName = "photo$imageId"
    val resourceId = context.resources.getIdentifier(imageName, "drawable", context.packageName)
    Image(
        painter = painterResource(id = resourceId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(250.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            .border(2.dp, AppTheme.colorScheme.border, RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

