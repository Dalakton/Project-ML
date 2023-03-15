package com.example.summer.data.dto

data class HomeDto(
    val id: String = "",
    val nomeDoLocal: String = "",
    val descricao: String = "",
    val numeroDecontao: String = "",
    val preco: Double = 0.0,
    var imageUrl: String = ""
)
