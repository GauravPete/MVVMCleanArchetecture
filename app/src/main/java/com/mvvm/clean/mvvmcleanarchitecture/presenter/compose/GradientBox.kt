package com.mvvm.clean.mvvmcleanarchitecture.presenter.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.mvvm.clean.mvvmcleanarchitecture.ui.theme.Blue
import com.mvvm.clean.mvvmcleanarchitecture.ui.theme.Taild600

@Composable
fun GradientBox(
   modifier : Modifier = Modifier,

) {
    Box(
        modifier = modifier.background(brush = Brush.linearGradient(listOf(
            Color(0xFF0D47A1), Color(0xFF1976D2)
        ),),),
    )
}