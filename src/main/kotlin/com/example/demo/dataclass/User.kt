package com.example.demo.dataclass

import jakarta.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
    val name: String,
    val age: Int,
    val nationality: String
)
