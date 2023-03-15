package com.example.summer.data.datasource

import android.net.Uri
import com.example.summer.data.dto.HomeDto

class FireBaseHomeDataSource(
) : HomeDataSource {

    override suspend fun getHomes(): List<HomeDto> {
        TODO("Not yet implemented")
    }

    override suspend fun uploadHomeImages(imageUri: Uri): String {
        TODO("Not yet implemented")
    }

    override suspend fun createHome(home: HomeDto): HomeDto {
        TODO("Not yet implemented")
    }
}