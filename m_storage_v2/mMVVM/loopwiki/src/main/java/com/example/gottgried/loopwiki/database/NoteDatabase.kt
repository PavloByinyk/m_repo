package com.example.gottgried.loopwiki.database

import android.arch.persistence.db.SupportSQLiteOpenHelper
import android.arch.persistence.room.Database
import android.arch.persistence.room.DatabaseConfiguration
import android.arch.persistence.room.InvalidationTracker
import android.arch.persistence.room.RoomDatabase
import com.example.gottgried.loopwiki.database.models.Note
import com.example.gottgried.loopwiki.database.daos.NoteDao
import android.arch.persistence.room.Room
import android.content.Context


// Room database class
@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
abstract class NoteDatabase(var context: Context) : RoomDatabase() {

    //define static instance
    private var mInstance: NoteDatabase? = null


    init {
        if (mInstance == null)
            mInstance = Room.databaseBuilder(context.applicationContext,
                    NoteDatabase::class.java, "notes_db")
                    .build()
    }



    //method to remove instance
    fun closeDatabase() {
        mInstance = null
    }

    //define note dao ( data access object )
    abstract fun noteDao(): NoteDao



    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}