package com.applaudostudios.womenintech.di

import com.applaudostudios.womenintech.repository.WomenRepository
import com.applaudostudios.womenintech.repository.WomenRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<WomenRepository> { WomenRepositoryImpl(womenAPI = get(), womenDao = get()) }
}