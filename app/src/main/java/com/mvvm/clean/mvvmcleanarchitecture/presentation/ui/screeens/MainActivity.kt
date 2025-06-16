package com.mvvm.clean.mvvmcleanarchitecture.presentation.ui.screeens

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mvvm.clean.mvvmcleanarchitecture.presentation.ui.compose.AppHeader
import com.mvvm.clean.mvvmcleanarchitecture.presentation.ui.compose.MessageInput
import com.mvvm.clean.mvvmcleanarchitecture.presentation.ui.compose.MessageList
import com.mvvm.clean.mvvmcleanarchitecture.presentation.viewmodels.ChatBotViewModel
import com.mvvm.clean.mvvmcleanarchitecture.ui.theme.MVVMCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: ChatBotViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MVVMCleanArchitectureTheme {
                Scaffold(topBar = { AppHeader() }) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        MessageList(
                            modifier = Modifier
                                .weight(1f),
                            messagesList = viewModel.messageList

                        )
                        MessageInput(
                            onMessageSend = { message ->
                                viewModel.sendMessage(message)
                            }
                        )
                    }

                }
            }
        }
    }
}

