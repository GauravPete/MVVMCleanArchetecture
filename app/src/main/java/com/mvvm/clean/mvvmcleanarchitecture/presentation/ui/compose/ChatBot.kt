package com.mvvm.clean.mvvmcleanarchitecture.presentation.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvvm.clean.mvvmcleanarchitecture.domain.model_domain.MessageModel

@Composable
fun AppHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Easy Bot",
            color = Color.White,
            fontSize = 22.sp
        )
    }

}

@Composable
fun MessageList(modifier: Modifier = Modifier, messagesList: List<MessageModel>) {
    LazyColumn(modifier, reverseLayout = true) {
        items(messagesList.reversed().count()) { it ->
            MessageItem(messagesList[it])
        }
    }
}

@Composable
fun MessageItem(message: MessageModel) {
    val isAssistant = message.role == "assistant"
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .align(
                        if (isAssistant)
                            Alignment.BottomStart
                        else
                            Alignment.BottomEnd
                    )
                    .padding(
                        start = if (isAssistant) 8.dp else 70.dp,
                        end = if (isAssistant) 70.dp else 8.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    )
                    .clip(RoundedCornerShape(50f))
                    .background(
                        brush = Brush.linearGradient(
                            colors = if (isAssistant) listOf(
                                MaterialTheme.colorScheme.secondaryContainer,
                                MaterialTheme.colorScheme.primaryContainer
                            ) else listOf(
                                MaterialTheme.colorScheme.primaryContainer,
                                MaterialTheme.colorScheme.secondaryContainer
                            )
                        )

                    )
            ) {

                Text(
                    text = message.message,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 8.dp)
                )
            }
        }


    }
}

@Composable
fun MessageInput(modifier: Modifier = Modifier, onMessageSend: (String) -> Unit) {
    var message by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {


        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            placeholder = { Text(text = "Type your message...") },
            modifier = Modifier.weight(1f)

        )
        IconButton(onClick = {
            if (!message.isEmpty()) {
                onMessageSend(message)
                message = ""
            }// Clear the input field after sending
        }) {
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = "Send"
            )
        }

    }


}

