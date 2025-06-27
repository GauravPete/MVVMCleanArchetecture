package com.mvvm.clean.mvvmcleanarchitecture.presenter.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import coil.transform.CircleCropTransformation
import com.mvvm.clean.mvvmcleanarchitecture.R

@Composable
fun CoilImageLib(navController: NavHostController) {
    val ImageUrl =
        "https://claid.ai/static/4f41617321d67dd5bd777182b985f3c0/67ded/prompt_example_28jpg_d88e4014dd.webp"

    Box(
        modifier = Modifier
            .fillMaxSize()
            .height(200.dp)
            .width(200.dp),
        contentAlignment = Alignment.Center
    ) {
        val model = ImageRequest
            .Builder(LocalContext.current)
            .placeholder(R.drawable.ic_launcher_foreground) // Replace with your placeholder image,
            .size(Size.ORIGINAL)
            .crossfade(1000)
            // Optional: Apply blur transformation
            // Optional: Apply circle crop transformation
            .data(ImageUrl)
            .transformations(
                transformations = listOf(CircleCropTransformation()) // Add grayscale transformation if needed
                // Add any transformations you want here, e.g., CircleCropTransformation()
            )
            .build()
        var imageState = rememberAsyncImagePainter(model = model).state

        AsyncImage(
            model = model,
            contentDescription = "Coil Image",
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
        )
        if (imageState is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator()            // Handle error state if needed
        }
    }
}