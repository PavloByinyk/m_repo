package com.example.gottgried.loopwiki.database.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.example.gottgried.loopwiki.utils.DateConverter
import java.util.*

// Entity class model of room database
@Entity
data class Note(
        // room database entity primary key
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val noteTitle: String,
        val noteDescription: String,

        @TypeConverters(DateConverter::class)
        val createdAt: Date
)


//private String noteTitle;
//private String noteDescription;
////type converter for date
//@TypeConverters(DateConverter.class)
//        private Date createdAt;