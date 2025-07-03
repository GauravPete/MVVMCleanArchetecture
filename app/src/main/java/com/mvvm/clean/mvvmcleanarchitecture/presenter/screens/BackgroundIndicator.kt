package com.mvvm.clean.mvvmcleanarchitecture.presenter.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mvvm.clean.mvvmcleanarchitecture.presenter.compose.CustomIndicatorCanvas

@Composable
fun BackgroundIndicator() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var value by remember { mutableStateOf(0) }
        CustomIndicatorCanvas(indicatorValue = value)
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = value.toString(),
            onValueChange = {
                if (it.isNotEmpty()) {
                    value = it.toInt()
                } else {
                    value = 0
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )


        )
    }
}