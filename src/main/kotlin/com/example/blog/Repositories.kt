package com.example.blog

import org.springframework.data.repository.CrudRepository
import java.util.*

interface ArticleRepository: CrudRepository<Article,Long> {
    fun findBySlug(slug: String): Article?
    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}

interface UserRepository: CrudRepository<User, Long>{
    fun findByUsername(username: String): User?
}