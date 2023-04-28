package com.example.composewithhilt.model.data.local.repository

import com.example.composewithhilt.model.data.local.entity.KeepBook
import kotlinx.coroutines.flow.Flow


interface KeepBookRepository {
    fun addIncome(keepBook: KeepBook, income: Int): Flow<Boolean>
    fun addPayOut(keepBook: KeepBook, payOut: Int): Flow<Boolean>
    fun getKeepBook(): Flow<KeepBook>
}