package com.example.gottgried.loopwiki_java.repositories;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.gottgried.loopwiki_java.database.NoteDatabase;
import com.example.gottgried.loopwiki_java.database.daos.NoteDao;
import com.example.gottgried.loopwiki_java.database.models.Note;

import java.util.List;

//Notes repository
public class NotesRepository {
    //Live Data of List of all notes
    private LiveData<List<Note>> mAllNotes;
    //Define Notes Dao
    NoteDao mNoteDao;

    public NotesRepository(@NonNull Application application) {
        NoteDatabase noteDatabase = NoteDatabase.getDatabase(application);
        //init Notes Dao
        mNoteDao = noteDatabase.noteDao();
        //get all notes
        mAllNotes = mNoteDao.getAllNotes();
    }
    //method to get all notes
    public LiveData<List<Note>> getAllNotes() {
        return mAllNotes;
    }

    //method to add note
    public void addNote(Note note) {
        new AddNote().execute(note);
    }

    //Async task to add note
    public class AddNote extends AsyncTask<Note, Void, Void> {
        @Override
        protected Void doInBackground(Note... notes) {
            mNoteDao.insertNote(notes[0]);
            return null;
        }
    }
}
