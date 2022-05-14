package com.davahamka.kinder.domain.model

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val no_hp: String,
    val password: String,
    val created_at: String,
    val updated_at: String,
    val xp_points: String,
    val xp_points_pencari: String,
    val level_donatur: String,
    val level_pencari: String,
    //TODO: change type of donate
    val Donate: Unit,
    val lat: Double,
    val lng: Double,
)
