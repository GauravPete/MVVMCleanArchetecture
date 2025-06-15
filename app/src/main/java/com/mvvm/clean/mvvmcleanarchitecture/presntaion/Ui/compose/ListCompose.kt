package com.mvvm.clean.mvvmcleanarchitecture.presntaion.Ui.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyListCompose() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(100) { index ->
            // Replace with your item composable
            Text(
                text = "Item #$index",
                modifier = Modifier.padding(16.dp),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }

}