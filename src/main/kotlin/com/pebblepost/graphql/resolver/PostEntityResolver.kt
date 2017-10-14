package com.pebblepost.graphql.resolver

import com.coxautodev.graphql.tools.GraphQLResolver
import com.pebblepost.graphql.model.Author
import com.pebblepost.graphql.model.Post
import com.pebblepost.graphql.repository.AuthorRepository
import org.springframework.stereotype.Component

@Component
class PostEntityResolver(val authorRepository: AuthorRepository) : GraphQLResolver<Post>{
    fun author(post: Post): Author {
        val myAuthor = authorRepository.findOne(post.authorId)
        println(myAuthor)

        return myAuthor
    }
}