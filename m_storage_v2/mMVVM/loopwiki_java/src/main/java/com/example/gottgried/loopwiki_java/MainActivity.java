package com.example.gottgried.loopwiki_java;

import android.app.Dialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;


import com.example.gottgried.loopwiki_java.adapters.NotesAdapter;
import com.example.gottgried.loopwiki_java.database.models.Note;
import com.example.gottgried.loopwiki_java.utils.Space;
import com.example.gottgried.loopwiki_java.viewModels.NotesListViewModel;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    NotesListViewModel mNotesListViewModel;
    FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize floating action button
        fab = (FloatingActionButton) findViewById(R.id.fab);
        //show add notes dialogue
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });


        // bind recyclerview to object
        RecyclerView mNotesRecyclerView = findViewById(R.id.recyclerViewNotes);
        // set layout manager
        mNotesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // create new notes adapter
        final NotesAdapter notesAdapter = new NotesAdapter();
        // set adapter to recyclerview
        mNotesRecyclerView.setAdapter(notesAdapter);
        // add decoration to recyclerview
        mNotesRecyclerView.addItemDecoration(new Space(20));
        // get ViewModel of this activity using ViewModelProviders
        mNotesListViewModel = ViewModelProviders.of(this).get(NotesListViewModel.class);
        // observe for notes data changes
        mNotesListViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                //add notes to adapter
                notesAdapter.addNotes(notes);
            }
        });
    }

    public void showDialog() {
        fab.hide();
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.add_note_dialog);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final EditText editTextTitle = dialog.findViewById(R.id.editTextTitle);
        final EditText editTextDescription = dialog.findViewById(R.id.editTextDescription);
        TextView textViewAdd = dialog.findViewById(R.id.textViewAdd);
        TextView textViewCancel = dialog.findViewById(R.id.textViewCancel);
        textViewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Title = editTextTitle.getText().toString();
                String Description = editTextDescription.getText().toString();
                Date createdAt = Calendar.getInstance().getTime();
                //add note
                mNotesListViewModel.addNote(new Note(Title, Description, createdAt));
                fab.show();
                dialog.dismiss();
            }
        });
        textViewCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                fab.show();
            }
        });

        dialog.show();

    }


}
