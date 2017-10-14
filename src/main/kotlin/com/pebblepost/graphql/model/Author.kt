package com.pebblepost.graphql.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data  class Author (
        @Id @GeneratedValue val id: Long? = null,
        val name: String? = null,
        val age: Int? = null,
        val country: String? = null
) {
    constructor(name: String, age: Int, country: String) : this(null, name, age, country)
}