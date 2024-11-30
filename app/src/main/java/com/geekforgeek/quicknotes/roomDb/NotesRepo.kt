package com.geekforgeek.quicknotes.roomDb

import android.icu.util.Calendar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NotesRepo(private val notesDAO: NotesDAO) {

    val notesList = MutableStateFlow<List<NotesModel>>(listOf())

    fun getAllNotes() {
        GlobalScope.launch(Dispatchers.IO) {
            val list = arrayListOf<NotesModel>()
            notesDAO.getAllNotes().forEach { notes ->
                list.add(
                    NotesModel(
                        id = notes.id,
                        title = notes.title,
                        description = notes.description,
                        dateTime = notes.dateTime
                    )
                )
            }

            notesList.value = list
        }
    }

    fun insertNotes(title: String, description: String) {
        val dateTime = Calendar.getInstance()
        GlobalScope.launch(Dispatchers.IO) {

            notesDAO.insertNotes(
                NotesEntity(
                    id = null,
                    title = title,
                    description = description,
                    dateTime = dateTime.timeInMillis
                )
            )
        }
    }

    fun deleteNotes(id: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            notesDAO.deleteNote(id)
        }
    }

    fun updateNotes(id: Int, title: String, description: String){
        val dateTime = Calendar.getInstance()
        GlobalScope.launch(Dispatchers.IO) {
            notesDAO.updateNotes(
                NotesEntity(
                    id = id,
                    title = title,
                    description = description,
                    dateTime = dateTime.timeInMillis
                )
            )
        }
    }
}