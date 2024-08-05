package com.example.demo.dataclass

import jakarta.persistence.*

@Entity
data class Image(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val fileName: String,
    val fileType: String,
    @Lob
    val data: ByteArray
)
