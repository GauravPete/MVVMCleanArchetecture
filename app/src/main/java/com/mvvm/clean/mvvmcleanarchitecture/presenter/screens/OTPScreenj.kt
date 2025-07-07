package com.mvvm.clean.mvvmcleanarchitecture.presenter.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mvvm.clean.mvvmcleanarchitecture.presenter.compose.OtpCompose

@Composable
fun OTPScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        OtpCompose()
    }

}