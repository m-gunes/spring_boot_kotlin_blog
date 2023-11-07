package com.example.blog

import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/article")
class ArticleController(private val repository: ArticleRepository) {

    @GetMapping("/")
    fun findAll() = repository.findAllByOrderByAddedAtDesc()

    @GetMapping("/{slug}")
    fun findOn(@PathVariable slug: String) = repository.findBySlug(slug)?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist")

}


@RestController
@RequestMapping("/api/user")
class UserController(private val repository: UserRepository) {

    @GetMapping("/")
    fun findAll() = repository.findAll()

    @GetMapping("/{username}")
    fun findOne(@PathVariable username: String) = repository.findByUsername(username)?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist")

//    @GetMapping("/{id}")
//    fun findById(@RequestParam("id") id: Long) = repository.findByIdOrNull(id)?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist")

}