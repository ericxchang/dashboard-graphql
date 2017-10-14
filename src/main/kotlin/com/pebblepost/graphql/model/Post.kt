package com.pebblepost.graphql.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data  class Post (

        @Id @GeneratedValue val id: Long? = null,
        val authorId: Long? = null,
        val title: String? = null,
        val category: String? = null,
        @Transient
        val author: Author? = null

) {
    constructor(authorId: Long, title: String, category: String) : this(null, authorId, title, category)
}