package com.mvvm.clean.mvvmcleanarchitecture.presenter.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvvm.clean.mvvmcleanarchitecture.presenter.compose.GradientBox

@Composable
fun LoginScreen(){
    val context = LocalContext.current
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

                Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.70f),
                    contentAlignment = Alignment.Center){
                    Column(
                        modifier = Modifier.wrapContentSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        LoginField(
                            Text = "User Name",
                            placeholder = "Enter UserName",
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        LoginField(
                            Text = "Password",
                            placeholder = "Enter Password",
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )

                        Button(onClick = {
                            Toast.makeText(context,"This is Login Demo Screen",Toast.LENGTH_SHORT).show()
                        },
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(horizontal = 14.dp, vertical = 14.dp),
                            ) {
                            Text(
                                text = "Login",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp,
                                color = Color.White
                            )
                        }
                    }
                }

            }
        }



}


@Composable
fun LoginField(
    Text: String,
    placeholder: String,
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = Text,
            color = Color.Black,
            fontSize = 18.sp,
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 16.dp, top = 8.dp),

        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = placeholder) },
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
        )
    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
   /* LoginField(
        Text = "Email",
        placeholder = "Enter your email",
        modifier = Modifier.padding(16.dp)
    )*/
}