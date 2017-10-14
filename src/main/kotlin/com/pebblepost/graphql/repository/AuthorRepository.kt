package com.pebblepost.graphql.repository

import com.pebblepost.graphql.model.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<Author, Long>{
}