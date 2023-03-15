package com.example.summer.data.repository

import android.net.Uri
import com.example.summer.data.datasource.HomeDataSource
import com.example.summer.data.dto.HomeDto

class HomeRepositoryImpl(
    private val homeDataSource: HomeDataSource
) : HomeRepository {

    override suspend fun getHomes(): List<HomeDto> {
        return homeDataSource.getHomes()
    }

    override suspend fun uploadHomeImages(imageUri: Uri): String {
        return homeDataSource.uploadHomeImages(imageUri)
    }

    override suspend fun createHome(home: HomeDto): HomeDto {
        return homeDataSource.createHome(home)
    }
}