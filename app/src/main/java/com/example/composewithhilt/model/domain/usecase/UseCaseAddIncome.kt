package com.example.composewithhilt.model.domain.usecase

import com.example.composewithhilt.model.data.local.entity.KeepBook
import kotlinx.coroutines.flow.Flow

interface UseCaseAddIncome {
    fun execute(keepBook: KeepBook, income: Int): Flow<Boolean>
}