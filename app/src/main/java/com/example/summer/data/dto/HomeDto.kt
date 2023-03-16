package com.example.summer.data.dto

import android.os.Parcelable
import com.example.summer.model.Home
import com.google.firebase.firestore.PropertyName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeDto(
    val id: String = "",
    val nomeDoLocal: String = "",
    val descricao: String = "",
    val numeroDecontato: String = "",
    val preco: Double = 0.0,
    @get:PropertyName("image_url")
    @set:PropertyName("image_url")
    var imageUrl: List<String> = arrayListOf()
) : Parcelable

fun HomeDto.toHome() = Home(
    id = this.id,
    nomeDoLocal = this.nomeDoLocal,
    descricao = this.descricao,
    numeroDecontato = this.numeroDecontato,
    preco = this.preco,
    imageUrl = this.imageUrl
)