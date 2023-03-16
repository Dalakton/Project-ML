package com.example.summer.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Home(
    val id: String,
    val nomeDoLocal: String,
    val descricao: String,
    val numeroDecontato: String,
    val preco: Double,
    var imageUrl: List<String>
) : Parcelable
