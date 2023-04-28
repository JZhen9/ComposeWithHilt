package com.example.composewithhilt.model.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = KeepBook.TABLE_NAME)
data class KeepBook(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "income")
    val income: Int,

    @ColumnInfo(name = "pay_out")
    val payOut: Int,
) {
    companion object {
        const val TABLE_NAME = "keepBook_data"
    }
}

fun KeepBook?.isNull(): Boolean {
    return this == null
}