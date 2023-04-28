package com.example.composewithhilt.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composewithhilt.model.data.local.entity.KeepBook
import com.example.composewithhilt.model.domain.usecase.UseCaseAddIncome
import com.example.composewithhilt.model.domain.usecase.UseCaseGetKeepBook
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IncomeViewModel @Inject constructor(
    private val useCaseGetKeepBook: UseCaseGetKeepBook,
    private val useCaseAddIncome: UseCaseAddIncome
) :
    ViewModel() {
    val item = useCaseGetKeepBook.execute()
        .stateIn(viewModelScope, SharingStarted.Eagerly, KeepBook(0, 0, 0))

    fun addIncome(input: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            useCaseAddIncome.execute(item.value, input).collect {
                Log.i("jess", "addIncome status: $it")
            }
        }
    }
}