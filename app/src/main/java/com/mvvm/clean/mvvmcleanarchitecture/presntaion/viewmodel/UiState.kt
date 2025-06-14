package com.mvvm.clean.mvvmcleanarchitecture.presntaion.viewmodel

import com.mvvm.clean.mvvmcleanarchitecture.domain.model_domain.PhotoSize_domain

data class UiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val photoSizeList: List<PhotoSize_domain> = emptyList()
)
