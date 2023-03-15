package com.example.summer.data.repository

import android.net.Uri
import com.example.summer.data.dto.HomeDto

interface HomeRepository {

    suspend fun getHomes() : List<HomeDto>

    suspend fun uploadHomeImages(imageUri: Uri): String

    suspend fun createHome(home: HomeDto) : HomeDto

}