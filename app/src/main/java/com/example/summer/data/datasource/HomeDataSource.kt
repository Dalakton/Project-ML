package com.example.summer.data.datasource

import android.net.Uri
import com.example.summer.data.dto.HomeDto

interface HomeDataSource {

    suspend fun getHomes() : List<HomeDto>

    suspend fun uploadHomeImages(imageUri: Uri): String

    suspend fun createHome(home: HomeDto) : HomeDto
}