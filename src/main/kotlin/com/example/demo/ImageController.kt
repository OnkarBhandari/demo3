package com.example.demo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1")
class ImageController(private val imageService: ImageService) {
    @PostMapping("/upload")
    fun uploadImage(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
        return try {
            val savedImage = imageService.saveImage(file)
            ResponseEntity("Image uploaded successfully: ${savedImage.fileName}", HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity("Could not upload the image: ${e.message}", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}