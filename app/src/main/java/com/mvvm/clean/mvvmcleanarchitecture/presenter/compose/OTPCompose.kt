package com.mvvm.clean.mvvmcleanarchitecture.presenter.compose

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OtpCompose() {
    var otpText by remember { mutableStateOf("123456") }
    OtpInputFields(otpText = otpText, onOtpModifier = { value, otpFilled ->
        otpText = value
        if (otpFilled) {
            // Handle OTP filled case, e.g., submit the OTP
            println("OTP Filled: $value")
        }
    })
}

@Composable
fun OtpInputFields(
    modifier: Modifier = Modifier,
    otpText: String = "",
    otpLength: Int = 6,
    onOtpModifier: (String, Boolean) -> Unit = { _, _ -> }
) {
    BasicTextField(
        modifier = modifier,
        value = TextFieldValue(otpText, selection = TextRange(otpText.length)),
        onValueChange = {
            if (it.text.length <= otpLength) {
                onOtpModifier(it.text, it.text.length == otpLength)
            }
        },
        decorationBox = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(otpLength) { index ->
                    CharectorContaner(index, (otpText).toString())
                }
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
    )

}

@Composable
fun CharectorContaner(index: Int, otpText: String, transformetionChar: String = "*") {

    val charector = when {
        index < otpText.length -> transformetionChar
        else -> " "
    }

    Box(
        modifier = Modifier.border(1.dp, Color.Red, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .width(50.dp)
                .height(40.dp)
                .padding(top = 5.dp),
            text = charector,
            color = Color.Black,
            fontSize = 30.sp,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}
