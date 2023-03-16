package com.example.summer.data.repository

import android.net.Uri
import com.example.summer.data.dto.HomeDto
import com.example.summer.model.Home

interface HomeRepository {

    suspend fun getHomes() : List<Home>

    suspend fun createHome(home: HomeDto) : HomeDto

    suspend fun uploadHomeImages(imageUri: List<Uri>): String
}