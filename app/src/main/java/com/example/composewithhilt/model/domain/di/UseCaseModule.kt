package com.example.composewithhilt.model.domain.di

import com.example.composewithhilt.model.domain.usecase.UseCaseAddIncome
import com.example.composewithhilt.model.domain.usecase.UseCaseAddPayOut
import com.example.composewithhilt.model.domain.usecase.UseCaseGetKeepBook
import com.example.composewithhilt.model.domain.usecaseimpl.UseCaseAddIncomeImpl
import com.example.composewithhilt.model.domain.usecaseimpl.UseCaseAddPayOutImpl
import com.example.composewithhilt.model.domain.usecaseimpl.UseCaseGetKeepBookImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun useCaseAddIncomeBind(useCaseAddIncomeImpl: UseCaseAddIncomeImpl): UseCaseAddIncome

    @Binds
    @Singleton
    abstract fun useCaseAddPayOutBind(useCaseAddPayOutImpl: UseCaseAddPayOutImpl): UseCaseAddPayOut

    @Binds
    @Singleton
    abstract fun useCaseGetKeepBook(useCaseGetKeepBookImpl: UseCaseGetKeepBookImpl): UseCaseGetKeepBook
}