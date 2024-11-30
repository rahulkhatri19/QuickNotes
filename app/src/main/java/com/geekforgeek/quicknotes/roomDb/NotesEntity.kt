package com.geekforgeek.quicknotes.roomDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.geekforgeek.quicknotes.Utility.DATE_TIME
import com.geekforgeek.quicknotes.Utility.DESCRIPTION
import com.geekforgeek.quicknotes.Utility.NOTES_TABLE
import com.geekforgeek.quicknotes.Utility.TITLE

@Entity(tableName = NOTES_TABLE)
class NotesEntity(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = TITLE) val title: String,
    @ColumnInfo(name = DESCRIPTION) val description: String,
    @ColumnInfo(name = DATE_TIME) val dateTime: Long
)