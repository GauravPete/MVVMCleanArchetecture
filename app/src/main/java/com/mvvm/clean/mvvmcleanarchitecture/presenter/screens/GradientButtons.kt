package com.mvvm.clean.mvvmcleanarchitecture.presenter.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.mvvm.clean.mvvmcleanarchitecture.presenter.compose.GradientBtnCompose
import com.mvvm.clean.mvvmcleanarchitecture.ui.theme.EndColor1
import com.mvvm.clean.mvvmcleanarchitecture.ui.theme.EndColor2
import com.mvvm.clean.mvvmcleanarchitecture.ui.theme.MidColor2
import com.mvvm.clean.mvvmcleanarchitecture.ui.theme.StartColor1
import com.mvvm.clean.mvvmcleanarchitecture.ui.theme.StartColor2

@Composable
fun GradientButtons() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GradientBtnCompose(
            text = "Button 1",
            gradient = Brush.linearGradient(
                colors = listOf(
                    StartColor1,
                    EndColor1
                )
            )

        ) { }
        GradientBtnCompose(
            text = "Button 2",
            gradient = Brush.linearGradient(
                colors = listOf(
                    StartColor2,
                    MidColor2,
                    EndColor2
                )
            )

        ) { }

    }
}