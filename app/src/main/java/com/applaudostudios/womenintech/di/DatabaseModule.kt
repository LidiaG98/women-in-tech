package com.applaudostudios.womenintech.di

import androidx.room.Room
import com.applaudostudios.womenintech.data.database.WomenRoomDb
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val DATABASE_NAME = "women_database"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext().applicationContext,
            WomenRoomDb::class.java,
            DATABASE_NAME
        ).build()
    }
    factory { get<WomenRoomDb>().womenDao() }
}