package com.applaudostudios.womenintech.repository

import com.applaudostudios.womenintech.data.database.WomenDao
import com.applaudostudios.womenintech.data.network.WomenAPI
import com.applaudostudios.womenintech.model.Women
import com.applaudostudios.womenintech.util.connection.Connectivity
import org.koin.java.KoinJavaComponent
import java.util.concurrent.TimeoutException

class WomenRepositoryImpl(private val womenAPI: WomenAPI, private val womenDao: WomenDao) :
    WomenRepository {

    private val connectivity: Connectivity by KoinJavaComponent.inject(
        Connectivity::class.java)

    override suspend fun getWomenList(): List<Women> {
        return try {
            if (connectivity.isNetworkConnected.value == true) {
                val women = womenAPI.getWomenList()
                womenDao.insertWomenInfoInDb(women)
                women
            }
            else womenDao.getWomenList()
        } catch (e: TimeoutException) {
            womenDao.getWomenList()
        }
    }

    override suspend fun getWomanDetails(womanId: Int) = womenDao.getWomanDetails(womanId)
}