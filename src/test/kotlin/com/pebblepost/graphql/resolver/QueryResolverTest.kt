package com.pebblepost.graphql.resolver

import com.pebblepost.graphql.model.Author
import com.pebblepost.graphql.model.Post
import com.pebblepost.graphql.repository.AuthorRepository
import com.pebblepost.graphql.repository.PostRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
class QueryResolverTest {
    @Autowired
    lateinit  var postRepository: PostRepository

    @Autowired
    lateinit var authorRepository: AuthorRepository

    @Autowired
    lateinit var queryResolver: PostAPIResolver

    @Before
    fun createAuthor() {
        authorRepository.save( Author("eric chang", 40, "USA") )
    }
    @Test
    fun testAddPost() {
        var  myPost = Post(1, "graphql", "technology")
        postRepository.save(myPost)

        postRepository.findAll().forEach { println(it) }

        queryResolver.posts().forEach {println("query resolve return: ${it.title}")}
    }
}