package com.pebblepost.graphql.resolver

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.pebblepost.graphql.model.Author
import com.pebblepost.graphql.repository.AuthorRepository
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorResolver(val authorRepository: AuthorRepository) : GraphQLQueryResolver, GraphQLMutationResolver{
    @GetMapping("/authors")
    fun authors(): List<Author> = authorRepository.findAll()

    fun addAuthor(name: String, age: Int, country: String): Author {
        var  author = Author(name, age, country)
        return authorRepository.save(author)
    }
}