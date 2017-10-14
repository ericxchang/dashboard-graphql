package com.pebblepost.graphql.resolver

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.pebblepost.graphql.model.Post
import com.pebblepost.graphql.repository.PostRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class PostAPIResolver(val postRepository: PostRepository) : GraphQLQueryResolver, GraphQLMutationResolver {
    @GetMapping("/posts")
    fun posts(): List<Post> = postRepository!!.findAll()

    @GetMapping("/post/{id}")
    fun postById(@PathVariable id: Long): Post? = postRepository.getOne(id)

    fun writePost(authorId: Long, title: String, category: String): Post {
        var  myPost = Post(authorId, title, category)
        return postRepository!!.save(myPost)
    }

    @PostMapping("/post/save")
    fun writePost(@RequestBody post: Post): Post {
        return postRepository.save(post)
    }

}