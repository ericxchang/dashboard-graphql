package com.pebblepost.graphql.repository

import com.pebblepost.graphql.model.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository: JpaRepository<Post, Long> {
}