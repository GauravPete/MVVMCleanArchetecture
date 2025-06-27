package com.mvvm.clean.mvvmcleanarchitecture.presenter.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavHostController
import com.mvvm.clean.mvvmcleanarchitecture.R

@Composable
fun PasswordTextField(navController: NavHostController) {
    var password by rememberSaveable { mutableStateOf("") }
    var visibility by rememberSaveable { mutableStateOf(false) }
    val icon = if (visibility) {
        painterResource(id = R.drawable.ic_visible_icon)
    } else {
        painterResource(id = R.drawable.in_visible)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            placeholder = { Text("Enter your password") },
            isError = false,
            supportingText = { Text("Must be at least 8 characters") },
            visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            trailingIcon = {
                IconButton(onClick = { visibility = !visibility }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Toggle Password Visibility"
                    )
                }
            }
        )
    }
}