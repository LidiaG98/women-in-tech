package com.applaudostudios.womenintech.di

import com.applaudostudios.womenintech.ui.viewmodel.WomenDetailViewModel
import com.applaudostudios.womenintech.ui.viewmodel.WomenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { WomenViewModel(womenRepository = get()) }
    viewModel { (womanId: Int) -> WomenDetailViewModel(womenRepository = get(), womanId = womanId) }
}