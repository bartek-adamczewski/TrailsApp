package edu.put.jetpackcomposetrailsapp.composable.list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import edu.put.jetpackcomposetrailsapp.ui.theme.custom.AppTheme

@Composable
fun TrailListItem(trail: Trail) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .background(AppTheme.colorScheme.listBackground),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        border = BorderStroke(3.dp, AppTheme.colorScheme.border),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(8.dp),
        ) {
            TrailImage(imageId = trail.imageId)
            Text(
                text = trail.name,
                modifier = Modifier.padding(top = 8.dp),
                style = AppTheme.typography.name
            )
            Text(
                text = "Zobacz szczegóły",
                modifier = Modifier.padding(top = 4.dp),
                style = AppTheme.typography.details
            )
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
            .size(150.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            .border(2.dp, AppTheme.colorScheme.border, RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

