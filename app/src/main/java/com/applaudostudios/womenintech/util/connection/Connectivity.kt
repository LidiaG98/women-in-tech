package com.applaudostudios.womenintech.util.connection

import androidx.lifecycle.MutableLiveData

interface Connectivity {
    var isNetworkConnected: MutableLiveData<Boolean?>
    fun startNetworkCallback()
}