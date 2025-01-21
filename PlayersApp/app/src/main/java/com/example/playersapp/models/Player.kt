package com.example.playersapp.models

import com.example.playersapp.R

data class Player(
    val id: Int,
    val name: String,
    val team: String,
    val naciolity: String,
    val imageRes: Int,
    val position: String,
    val age: Int,
    val height: String,
    val isFavorite: Boolean = false
)

val 