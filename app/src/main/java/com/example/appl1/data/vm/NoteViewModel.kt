package com.example.appl1.data.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.appl1.data.db.NoteDatabase
import com.example.appl1.data.entities.Note
import com.example.appl1.data.repository.NoteRepository
import com.example.appl1.data.service.NoteService
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val noteService: NoteService
    val allNotes: LiveData<List<Note>>

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        val noteRepository = NoteRepository(noteDao)
        noteService = NoteService(noteRepository)
        allNotes = noteService.allNotes
    }

    fun insert(note: Note) = viewModelScope.launch {
        noteService.insert(note)
    }

    fun update(note: Note) = viewModelScope.launch {
        noteService.update(note)
    }

    fun delete(note: Note) = viewModelScope.launch {
        noteService.delete(note)
    }
}