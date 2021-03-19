package com.applaudostudios.womenintech.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WomenApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WomenApplication)
            modules(modules)
        }
    }

}

val modules = listOf(databaseModule, networkModule, repositoryModule, presentationModule)