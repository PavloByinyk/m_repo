package com.example.gottgried.loopwiki_java.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.gottgried.loopwiki_java.database.models.Note;
import com.example.gottgried.loopwiki_java.repositories.NotesRepository;

import java.util.List;

public class NotesListViewModel extends AndroidViewModel {
    private LiveData<List<Note>> mAllNotes;
    NotesRepository mNotesRepository;

    public NotesListViewModel(@NonNull Application application) {
        super(application);
        mNotesRepository = new NotesRepository(application);
        mAllNotes = mNotesRepository.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return mAllNotes;
    }

    public void addNote(Note note) {
        mNotesRepository.addNote(note);
    }
}
