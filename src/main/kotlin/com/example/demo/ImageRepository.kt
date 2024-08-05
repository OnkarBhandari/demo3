package com.example.demo

import com.example.demo.dataclass.Image
import org.springframework.data.jpa.repository.JpaRepository


interface ImageRepository : JpaRepository<Image, Long>