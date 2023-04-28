package com.example.composewithhilt.model.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.composewithhilt.model.data.local.entity.KeepBook
import kotlinx.coroutines.flow.Flow

@Dao
interface KeepBookDao {
    @Query("SELECT * FROM ${KeepBook.TABLE_NAME} LIMIT 1")
    fun getKeepBook(): Flow<KeepBook?>

    @Insert
    suspend fun insert(keepBook: KeepBook): Long

    @Update
    suspend fun update(keepBook: KeepBook): Int
}