package com.applaudostudios.womenintech.util.connection

import android.content.Context
import android.net.*
import androidx.lifecycle.MutableLiveData
import com.applaudostudios.womenintech.util.connection.Connectivity

class ConnectivityImpl(private val context: Context) :
    Connectivity {

    override var isNetworkConnected: MutableLiveData<Boolean?> = MutableLiveData()

    override fun startNetworkCallback() {
        val cm: ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        isNetworkConnected.value = cm.getNetworkCapabilities(cm.activeNetwork)?.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)

        val builder: NetworkRequest.Builder = NetworkRequest.Builder()

        cm.registerNetworkCallback(
            builder.build(),
            object : ConnectivityManager.NetworkCallback() {

                override fun onAvailable(network: Network) {
                    isNetworkConnected.postValue(true)
                }

                override fun onLost(network: Network) {
                    isNetworkConnected.postValue(false)
                }
            })
    }
}