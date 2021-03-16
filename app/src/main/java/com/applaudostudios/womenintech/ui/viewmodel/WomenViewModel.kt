package com.applaudostudios.womenintech.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applaudostudios.womenintech.model.Women
import com.applaudostudios.womenintech.repository.WomenRepository
import kotlinx.coroutines.launch

class WomenViewModel(private val womenRepository: WomenRepository) : ViewModel() {
    val womenList = MutableLiveData<List<Women>>()

    private suspend fun fetchWomen() = womenRepository.getWomenList()

    init {
        viewModelScope.launch { womenList.postValue(fetchWomen()) }
    }
}