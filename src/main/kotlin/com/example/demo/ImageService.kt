package com.example.demo

import com.example.demo.dataclass.Image
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.IOException


@Service
class ImageService(
    private val imageRepository: ImageRepository,

    @Value("\${image.upload.dir}") private val uploadDir: String
) {

    @Throws(IOException::class)
    fun saveImage(file: MultipartFile): Image {
        val fileName = file.originalFilename ?: "unknown"
        val destinationFile = File("$uploadDir${File.separator}$fileName")
        file.transferTo(destinationFile)

        val image = Image(
            fileName = fileName,
            fileType = file.contentType ?: "unknown",
            data = ByteArray(0) // Not storing the file data in the DB
        )
        return imageRepository.save(image)
    }

}