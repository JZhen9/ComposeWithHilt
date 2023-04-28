package com.example.composewithhilt.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composewithhilt.model.data.local.entity.KeepBook
import com.example.composewithhilt.model.domain.usecase.UseCaseGetKeepBook
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCaseGetKeepBook: UseCaseGetKeepBook) :
    ViewModel() {
    val currentKeepBook = useCaseGetKeepBook.execute()
        .stateIn(viewModelScope, SharingStarted.Eagerly, KeepBook(0, 0, 0))
}