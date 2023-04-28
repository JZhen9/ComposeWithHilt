package com.example.composewithhilt.model.data.local.repositoryimpl

import com.example.composewithhilt.model.data.local.dao.KeepBookDao
import com.example.composewithhilt.model.data.local.entity.KeepBook
import com.example.composewithhilt.model.data.local.entity.isNull
import com.example.composewithhilt.model.data.local.repository.KeepBookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KeepBookRepositoryImpl @Inject constructor(private val dao: KeepBookDao) :
    KeepBookRepository {
    override fun addIncome(keepBook: KeepBook, income: Int): Flow<Boolean> {
        return flow {
            val res = dao.update(keepBook.copy(income = keepBook.income + income))
            emit(res != 0)
        }
    }

    override fun addPayOut(keepBook: KeepBook, payOut: Int): Flow<Boolean> {
        return flow {
            val res = dao.update(keepBook.copy(payOut = keepBook.payOut + payOut))
            emit(res != 0)
        }
    }

    override fun getKeepBook(): Flow<KeepBook> {
        return flow {
            dao.getKeepBook().collect {
                if (it.isNull()) {
                    dao.insert(KeepBook(0, 0, 0))
                    return@collect
                }
                emit(it!!)
            }
        }
    }
}