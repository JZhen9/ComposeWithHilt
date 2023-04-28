package com.example.composewithhilt.model.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composewithhilt.model.data.local.dao.KeepBookDao
import com.example.composewithhilt.model.data.local.entity.KeepBook

@Database(
    entities = [KeepBook::class],
    version = 1
)
abstract class KeepBookDatabase : RoomDatabase() {
    abstract val keepBookDao: KeepBookDao
}