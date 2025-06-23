package com.mvvm.clean.mvvmcleanarchitecture.presenter.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun TextField_demo(navController: NavHostController) {
    AllTextFieldProperties()
}

@Composable
fun AllTextFieldProperties() {
    var text by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Label") },
            placeholder = { Text("Placeholder") },
            isError = true,
            supportingText = { Text("Supporting text") })
        /*value = "Hello World"
       onValueChange = { /* Handle value change */ }
      label = { Text("Label") }
       placeholder = { Text("Placeholder") }
       singleLine = true
       maxLines = 1
       minLines = 1
       isError = false
       supportingText = { Text("Supporting text") }
       trailingIcon = { *//* Add trailing icon here *//* }
            leadingIcon = { *//* Add leading icon here *//* }
            shape = MaterialTheme.shapes.small*/


    }
}