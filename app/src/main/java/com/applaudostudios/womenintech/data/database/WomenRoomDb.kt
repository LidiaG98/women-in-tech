package com.applaudostudios.womenintech.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.applaudostudios.womenintech.model.Women

@Database(entities = [Women::class], version = 1, exportSchema = false)
abstract class WomenRoomDb : RoomDatabase(){
    abstract fun womenDao(): WomenDao
}