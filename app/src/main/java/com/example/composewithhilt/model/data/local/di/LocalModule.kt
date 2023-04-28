package com.example.composewithhilt.model.data.local.di

import android.content.Context
import androidx.room.Room
import com.example.composewithhilt.model.data.local.dao.KeepBookDao
import com.example.composewithhilt.model.data.local.database.KeepBookDatabase
import com.example.composewithhilt.model.data.local.repository.KeepBookRepository
import com.example.composewithhilt.model.data.local.repositoryimpl.KeepBookRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {
    @Provides
    @Singleton
    fun keepBookDataBaseProvider(@ApplicationContext context: Context): KeepBookDatabase {
        return Room.databaseBuilder(context, KeepBookDatabase::class.java, "keepBook_data_file").build()
    }

    @Provides
    @Singleton
    fun keepBookDaoProvider(keepBookDatabase: KeepBookDatabase): KeepBookDao {
        return keepBookDatabase.keepBookDao
    }

    @Provides
    @Singleton
    fun keepBookRepositoryProvider(keepBookRepositoryImpl: KeepBookRepositoryImpl): KeepBookRepository {
        return keepBookRepositoryImpl
    }
}