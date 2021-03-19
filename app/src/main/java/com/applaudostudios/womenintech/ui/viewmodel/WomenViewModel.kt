package com.applaudostudios.womenintech.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applaudostudios.womenintech.model.Women
import com.applaudostudios.womenintech.repository.WomenRepository
import com.applaudostudios.womenintech.util.connection.Connectivity
import com.applaudostudios.womenintech.util.Status
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class WomenViewModel(private val womenRepository: WomenRepository) : ViewModel() {

    val womenList = MutableLiveData<List<Women>>()
    val status = MutableLiveData(Status.LOADING)

    private val connectivity: Connectivity by inject(
        Connectivity::class.java)
    val isConnected = connectivity.isNetworkConnected

    private suspend fun fetchWomenInApi() = womenRepository.getWomenList()
    fun fetchList() {
        viewModelScope.launch {
            womenList.postValue(fetchWomenInApi())
            status.postValue(Status.SUCCESS)
        }
    }
}