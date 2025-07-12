package com.mvvm.clean.mvvmcleanarchitecture.presenter.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text


import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen2() {
    Box{

        Text(text = "Welcome to Login",
            color = Color.Black,
            fontSize = 20.sp,
        )
    }
    // This is a placeholder for the new login screen implementation.
    // You can add your UI components and logic here.
    // For example, you might want to use TextFields for username and password,
    // and a Button for submitting the login form.
}