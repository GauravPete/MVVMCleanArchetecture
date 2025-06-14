package com.mvvm.clean.mvvmcleanarchitecture.presntaion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvvm.clean.mvvmcleanarchitecture.domain.usecases.PhotoListUsecase
import com.mvvm.clean.mvvmcleanarchitecture.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    val photoListUsecase: PhotoListUsecase
) : ViewModel() {
    private val _photoList = MutableStateFlow(UiState())
    val photoList: StateFlow<UiState> = _photoList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            photoListUsecase.invoke().collect {
                when (it) {
                    is NetworkResult.Loading -> {
                        _photoList.value = UiState(
                            isLoading = true,
                            photoSizeList = emptyList()
                        )
                    }

                    is NetworkResult.Success -> {
                        _photoList.value = UiState(
                            isLoading = false,
                            photoSizeList = it.data ?: emptyList()
                        )
                    }

                    is NetworkResult.Error -> {
                        _photoList.value = UiState(
                            isLoading = false,
                            errorMessage = it.message ?: "An unexpected error occurred"
                        )
                    }
                }
            }
        }
    }

}