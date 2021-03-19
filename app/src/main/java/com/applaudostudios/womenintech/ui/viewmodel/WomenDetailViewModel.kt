package com.applaudostudios.womenintech.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applaudostudios.womenintech.model.Women
import com.applaudostudios.womenintech.repository.WomenRepository
import kotlinx.coroutines.launch

class WomenDetailViewModel(private val womenRepository: WomenRepository, private val womanId: Int) :
    ViewModel() {
    val womanDetails = MutableLiveData<Women>()

    init {
        viewModelScope.launch {
            womanDetails.postValue(womenRepository.getWomanDetails(womanId))
        }
    }
}