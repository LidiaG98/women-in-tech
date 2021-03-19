package com.applaudostudios.womenintech.di

import com.applaudostudios.womenintech.data.network.WomenAPI
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://sheetsu.com/apis/v1.0bu/"

val networkModule = module {
    single { GsonConverterFactory.create() as Converter.Factory }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(get())
            .build()
    }

    single { get<Retrofit>().create(WomenAPI::class.java) }
}