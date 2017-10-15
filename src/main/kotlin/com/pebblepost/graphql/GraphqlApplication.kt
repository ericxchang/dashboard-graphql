package com.pebblepost.graphql

import com.pebblepost.graphql.interceptor.AuthInterceptor
import com.pebblepost.graphql.model.Author
import com.pebblepost.graphql.model.Post
import com.pebblepost.graphql.repository.AuthorRepository
import com.pebblepost.graphql.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@SpringBootApplication
class GraphqlApplication : CommandLineRunner {
    @Autowired
    lateinit var postRepo: PostRepository
    @Autowired
    lateinit var authorRepo: AuthorRepository

    override fun run(vararg args: String?) {
        arrayListOf("eric", "john", "mike", "tom").forEach {createAuthor(it)}
        arrayListOf("a", "b", "c").forEach {writePost(it)}

        postRepo.findAll().forEach { println(it) }
    }

    private fun createAuthor(name: String) {
        authorRepo.save( Author(name, 40, "USA") )
    }

    private fun writePost(id: String) {
        val myPost = Post(1, "title ${id}", "graphdl")
        postRepo.save(myPost)
    }
}

@Configuration
class appConfiguration: WebMvcConfigurerAdapter() {
    @Autowired
    lateinit var authInterceptor: AuthInterceptor

    override fun addInterceptors(registry: InterceptorRegistry?) {
        registry!!.addInterceptor(authInterceptor)
        super.addInterceptors(registry)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(GraphqlApplication::class.java, *args)
}
