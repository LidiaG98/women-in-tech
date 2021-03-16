package com.applaudostudios.womenintech.repository

import com.applaudostudios.womenintech.data.database.WomenDao
import com.applaudostudios.womenintech.data.network.WomenAPI
import com.applaudostudios.womenintech.model.Women
import java.net.UnknownHostException

class WomenRepositoryImpl(private val womenAPI: WomenAPI, private val womenDao: WomenDao) :
    WomenRepository {
    override suspend fun getWomenList(): List<Women> {
        return try {
            val womenList = womenAPI.getWomenList()
            if (womenList.isNotEmpty()) {
                womenDao.insertWomenInfoInDb(womenList)
                womenList
            } else {
                womenDao.getWomenList()
            }
        } catch (e: UnknownHostException) {
            listOf()
        }
    }

    override suspend fun getWomanDetails(womanId: Int) = womenDao.getWomanDetails(womanId)
}