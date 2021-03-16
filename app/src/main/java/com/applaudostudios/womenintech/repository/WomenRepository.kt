package com.applaudostudios.womenintech.repository

import com.applaudostudios.womenintech.model.Women

interface WomenRepository {
    suspend fun getWomenList(): List<Women>
    suspend fun getWomanDetails(womanId: Int): Women
}