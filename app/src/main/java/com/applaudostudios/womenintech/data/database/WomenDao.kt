package com.applaudostudios.womenintech.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.applaudostudios.womenintech.model.Women

@Dao
interface WomenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWomenInfoInDb(women: List<Women>)

    @Query("DELETE FROM Women")
    suspend fun deleteAllDataInDb()

    @Query("SELECT womanId, name, title FROM Women")
    suspend fun getWomenList(): List<Women>

    @Query("SELECT * FROM Women WHERE womanId=:womanId")
    suspend fun getWomanDetails(womanId: Int): Women
}