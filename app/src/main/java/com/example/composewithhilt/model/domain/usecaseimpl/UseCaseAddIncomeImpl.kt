package com.example.composewithhilt.model.domain.usecaseimpl

import com.example.composewithhilt.model.data.local.entity.KeepBook
import com.example.composewithhilt.model.data.local.repository.KeepBookRepository
import com.example.composewithhilt.model.domain.usecase.UseCaseAddIncome
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UseCaseAddIncomeImpl @Inject constructor(private val repository: KeepBookRepository): UseCaseAddIncome {
    override fun execute(keepBook: KeepBook, income: Int): Flow<Boolean> {
        return repository.addIncome(keepBook, income)
    }
}