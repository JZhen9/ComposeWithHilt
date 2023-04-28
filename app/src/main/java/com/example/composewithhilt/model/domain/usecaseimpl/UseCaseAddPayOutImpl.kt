package com.example.composewithhilt.model.domain.usecaseimpl

import com.example.composewithhilt.model.data.local.entity.KeepBook
import com.example.composewithhilt.model.data.local.repository.KeepBookRepository
import com.example.composewithhilt.model.domain.usecase.UseCaseAddPayOut
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UseCaseAddPayOutImpl @Inject constructor(private val repository: KeepBookRepository) : UseCaseAddPayOut {
    override fun execute(keepBook: KeepBook, payOut: Int): Flow<Boolean> {
        return repository.addPayOut(keepBook, payOut)
    }
}