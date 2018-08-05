package com.example.gottgried.loopwiki.utils

import android.arch.persistence.room.TypeConverter
import android.text.format.DateFormat
import java.util.*

object DateConverter {

    @TypeConverter
    fun toDate(timestamp: Long): Date? {
        return  if(timestamp == null)  null else Date(timestamp)
    }

    @TypeConverter
    fun toDate(date: Date): Long? {
        return  if(date == null)  null else date.time
    }

    @TypeConverter
    fun getDayMonth(date: Date): String {
        val day = DateFormat.format("dd", date) as String // 20
        val monthString = DateFormat.format("MMM", date) as String// Jun
        return day + monthString
    }

}

//@TypeConverter
//public static Date toDate(Long timestamp) {
//    return timestamp == null ? null : new Date(timestamp);
//}
//
//@TypeConverter
//public static Long toTimestamp(Date date) {
//    return date == null ? null : date.getTime();
//}
//
//
//public static String getDayMonth(Date date) {
//
//    String day = (String) DateFormat.format("dd", date); // 20
//    String monthString = (String) DateFormat.format("MMM", date); // Jun
//    return day + monthString;
//}