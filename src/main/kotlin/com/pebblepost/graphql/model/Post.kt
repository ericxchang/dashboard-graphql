package com.pebblepost.graphql.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data  class Post (
        @Id @GeneratedValue val id: Long? = null,
        val author: String? = null,
        val title: String? = null,
        val category: String? = null
) {
    constructor(author: String, title: String, category: String) : this(null, author, title, category)
}