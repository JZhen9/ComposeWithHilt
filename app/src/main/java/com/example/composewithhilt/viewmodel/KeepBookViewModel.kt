package com.example.composewithhilt.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class KeepBookViewModel @Inject constructor() : ViewModel() {
    private val _payout = MutableStateFlow(0)
    val payout: StateFlow<Int>
        get() = _payout

    private val _income = MutableStateFlow(0)
    val income: StateFlow<Int>
        get() = _income

}