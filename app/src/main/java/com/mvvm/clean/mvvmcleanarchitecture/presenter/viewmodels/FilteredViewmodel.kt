package com.mvvm.clean.mvvmcleanarchitecture.presenter.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class FilteredViewmodel : ViewModel() {
    private val _viewState = MutableStateFlow(ViewState())
    val viewState = _viewState.asStateFlow()

    init {
        _viewState.update {
            it.copy(filteredList = getList())
        }

    }

    fun getFilteredList(query: String) {
        viewModelScope.launch(Dispatchers.Default) {
            _viewState.update { currentState ->
                val filtered = getList().filter { it.contains(query, ignoreCase = true) }
                currentState.copy(filteredList = filtered)
            }
        }
    }

    fun getList() = listOf<String>(
        "Apple",
        "Banana",
        "Cherry",
        "Date",
        "Elderberry",
        "Fig",
        "Grape",
        "Honeydew",
        "Kiwi",
        "Lemon",
        "Mango",
        "Nectarine",
        "Orange",
        "Papaya",
        "Quince",
    )

}

data class ViewState(val filteredList: List<String> = emptyList())