package com.example.appl1.data.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
class Note{
    @PrimaryKey(autoGenerate = true) var id: Int = 0
    @NonNull @ColumnInfo(name = "title") var title: String = ""
    @NonNull @ColumnInfo(name = "description") var description: String =""
    //@NonNull @ColumnInfo(name = "date") var date: Date = Date()
}