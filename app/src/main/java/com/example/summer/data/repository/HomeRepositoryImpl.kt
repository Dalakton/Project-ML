package com.example.summer.data.repository

import android.net.Uri
import com.example.summer.datasource.HomeDataSource
import com.example.summer.data.dto.HomeDto
import com.example.summer.data.dto.toHome
import com.example.summer.model.Home

class HomeRepositoryImpl(
    private val homeDataSource: HomeDataSource
) : HomeRepository {

    override suspend fun getHomes(): List<Home> {
        val home = homeDataSource.getHomes().map {
            it.toHome()
        }
        return home
    }

    override suspend fun uploadHomeImages(imageUri: List<Uri>): String {
        return homeDataSource.uploadHomeImages(imageUri)
    }

    override suspend fun createHome(home: HomeDto): HomeDto {
        return homeDataSource.createHome(home)
    }
}