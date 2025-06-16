package com.mvvm.clean.mvvmcleanarchitecture.presentation.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerativeBackend
import com.google.firebase.ai.type.content
import com.mvvm.clean.mvvmcleanarchitecture.domain.model_domain.MessageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class ChatBotViewModel @Inject constructor() : ViewModel() {
    val messageList by lazy {
        mutableStateListOf<MessageModel>()
    }
    val generativeAiModel = Firebase.ai(
        backend = GenerativeBackend.googleAI()
    )
        .generativeModel("gemini-2.0-flash")

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    fun sendMessage(question: String) {
        messageList.add(MessageModel(question, "user"))
        viewModelScope.launch(Dispatchers.IO) {
            try {
                messageList.add(MessageModel("Thinking...", "assistant"))
                val chat = generativeAiModel.startChat(
                    history = messageList.map {
                        content(it.role) {
                            text(it.message)
                        }
                    }.toList()
                )
                val response = chat.sendMessage(question)
                //val response =generativeAiModel.generateContent(question)
                messageList.remove(MessageModel("Thinking...", "assistant"))
                messageList.add(MessageModel(response.text.toString(), "assistant"))
                println("Message Input: $question")
                println("Message response: ${response.text.toString()}")
            } catch (e: Exception) {
                e.printStackTrace()
                messageList.remove(MessageModel("Thinking...", "assistant"))
                messageList.add(MessageModel("Error: ${e.message}", "assistant"))
                return@launch
            }

        }

    }
}