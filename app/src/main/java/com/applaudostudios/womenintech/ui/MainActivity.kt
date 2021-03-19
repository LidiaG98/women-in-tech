package com.applaudostudios.womenintech.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applaudostudios.womenintech.R
import com.applaudostudios.womenintech.util.connection.Connectivity
import org.koin.java.KoinJavaComponent

class MainActivity : AppCompatActivity() {

    private val connectivity: Connectivity by KoinJavaComponent.inject(
        Connectivity::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectivity.startNetworkCallback()
    }
}