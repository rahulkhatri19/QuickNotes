package com.geekforgeek.quicknotes.roomDb

data class NotesModel(
    val id: Int?,
    val title: String,
    val description: String,
    val dateTime: Long
)