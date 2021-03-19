package com.applaudostudios.womenintech.data.network

import com.applaudostudios.womenintech.model.Women
import retrofit2.http.GET

interface WomenAPI {
    companion object {
        const val API_URL = "4c9d0f52b552/"
    }

    @GET(API_URL)
    suspend fun getWomenList(): List<Women>
}