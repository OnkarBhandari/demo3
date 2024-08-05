package com.example.demo

import com.example.demo.dataclass.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("api/v1/user")
@RestController
class UserController(val userService: UserService) {
    @GetMapping
    fun getAllUsers() : List<User>  =userService.getAll()

    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") id:Long) : User = userService.getById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveUser(@RequestBody user: User) : User = userService.create(user)

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id:Long, @RequestBody user: User) : User = userService.update(id, user)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id:Long) =userService.delete(id)

}