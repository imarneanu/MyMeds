package com.imarneanu.mymeds.domain.model

data class Medicine(
    val id: Int,
    val name: String,
    val quantity: String,
    val expirationDate: Long,
    val isExpired: Boolean = false,
)
