package com.example.blog

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {
    @Bean
    fun databaseInitializer(userRepository: UserRepository, articleRepository: ArticleRepository) = ApplicationRunner{
        val mgunes = userRepository.save(User("mgunes", "mustagfa", "gunes"))
        articleRepository.save(Article(title="lorem", headline = "lorem ipsum", content = "dolor sit amet", author=mgunes))
        articleRepository.save(Article(title = "ipsum", headline = "ipsum lorem", content = "dolor sit amet lorem ipsum", author = mgunes))
    }
}