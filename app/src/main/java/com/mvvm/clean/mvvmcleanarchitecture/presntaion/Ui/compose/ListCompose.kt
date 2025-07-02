package com.mvvm.clean.mvvmcleanarchitecture.presntaion.Ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.mvvm.clean.mvvmcleanarchitecture.domain.model_domain.PhotoSize_domain

@Composable
fun ListItmeCompose(photoItme: PhotoSize_domain) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(photoItme.download_url)
                    .crossfade(true)
                    .size(
                        Size(
                            width = 600, height = 600
                        )
                    )
                    .build(),
                contentDescription = "Image of ${photoItme.author}",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .clip(CircleShape)
                    .weight(1f)
            )
            Column(modifier = Modifier.weight(2f)) {
                Text(
                    text = "Author: ${photoItme.author}",
                    modifier = Modifier.padding(4.dp),
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )
                Text(
                    text = "Height: ${photoItme.height}",
                    modifier = Modifier.padding(4.dp),
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )
                Text(
                    text = "Width: ${photoItme.width}",
                    modifier = Modifier.padding(4.dp),
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )
            }
        }

    }
}