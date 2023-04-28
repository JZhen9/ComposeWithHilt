package com.example.composewithhilt.model.domain.usecaseimpl

import com.example.composewithhilt.model.data.local.entity.KeepBook
import com.example.composewithhilt.model.data.local.repository.KeepBookRepository
import com.example.composewithhilt.model.domain.usecase.UseCaseGetKeepBook
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UseCaseGetKeepBookImpl @Inject constructor(private val repository: KeepBookRepository) : UseCaseGetKeepBook {
    override fun execute(): Flow<KeepBook> {
        return repository.getKeepBook()
    }
}