package com.mvvm.clean.mvvmcleanarchitecture.presenter.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mvvm.clean.mvvmcleanarchitecture.presenter.compose.GradientBox

@Composable
fun LoginScreen(){

    GradientBox(modifier = Modifier.fillMaxSize())

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.35F),
                contentAlignment = Alignment.Center,

                ){
                Text(text = "Welcome to Login",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White,
                )
            }
            Column(modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .background(color = Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,

                )
            {
                Text(text = "Sign In",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.Black,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(top = 30.dp)
                )
            }
        }



}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}