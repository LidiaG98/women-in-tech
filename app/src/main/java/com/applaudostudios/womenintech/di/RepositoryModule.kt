package com.applaudostudios.womenintech.di

import com.applaudostudios.womenintech.repository.WomenRepository
import com.applaudostudios.womenintech.repository.WomenRepositoryImpl
import com.applaudostudios.womenintech.util.connection.Connectivity
import com.applaudostudios.womenintech.util.connection.ConnectivityImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    factory<WomenRepository> { WomenRepositoryImpl(womenAPI = get(), womenDao = get()) }
    single<Connectivity> {
        ConnectivityImpl(
            androidContext()
        )
    }
}