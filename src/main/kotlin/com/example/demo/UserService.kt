package com.example.demo

import com.example.demo.dataclass.User
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(val UserRepositoryImpl: UserRepository) {
    fun getAll():List<User> =UserRepositoryImpl.findAll()
    fun getById(id:Long): User =UserRepositoryImpl.findByIdOrNull(id)?:
    throw ResponseStatusException(HttpStatus.NOT_FOUND)
    fun save(user:User):User = UserRepositoryImpl.save(user)
    fun update(id:Long, user:User):User {
        return if (UserRepositoryImpl.existsById(id)){
            user.id=id
            UserRepositoryImpl.save(user)
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
    fun create(user:User):User = UserRepositoryImpl.save(user)
    fun delete(id:Long) {
        if (UserRepositoryImpl.existsById(id)) UserRepositoryImpl.deleteById(id)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

}