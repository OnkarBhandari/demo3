package com.example.demo

import com.example.demo.dataclass.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User,Long>