package com.example.gottgried.loopwiki.database.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.example.gottgried.loopwiki.database.models.Note
import com.example.gottgried.loopwiki.utils.DateConverter

//note dao(data access object)
@Dao
@TypeConverters(DateConverter::class)
interface NoteDao {

    // Dao method to get all notes
    @Query("SELECT * FROM Note")
    fun getAllNotes(): LiveData<List<Note>>

    // Dao method to insert note
    @Insert(onConflict = REPLACE)
    fun insertNote(note: Note)

    // Dao method to delete note
    @Delete()
    fun deleteNote(note: Note)

}


//// Dao method to get all notes
//@Query("SELECT * FROM Note")
//LiveData<List<Note>> getAllNotes();
//
//// Dao method to insert note
//@Insert(onConflict = REPLACE)
//void insertNote(Note note);
//
//// Dao method to delete note
//@Delete
//void deleteNote(Note note);