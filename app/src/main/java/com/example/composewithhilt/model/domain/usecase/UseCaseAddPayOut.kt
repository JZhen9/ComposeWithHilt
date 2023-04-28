package com.example.composewithhilt.model.domain.usecase

import com.example.composewithhilt.model.data.local.entity.KeepBook
import kotlinx.coroutines.flow.Flow

interface UseCaseAddPayOut {
    fun execute(keepBook: KeepBook, payOut: Int): Flow<Boolean>
}