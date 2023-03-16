package com.example.summer.datasource

import android.net.Uri
import com.example.summer.data.dto.HomeDto

interface HomeDataSource {

    suspend fun getHomes() : List<HomeDto>

    suspend fun createHome(home: HomeDto) : HomeDto

    suspend fun uploadHomeImages(imageUri: List<Uri>): String
}