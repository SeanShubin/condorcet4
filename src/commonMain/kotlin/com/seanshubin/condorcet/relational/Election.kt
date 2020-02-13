package com.seanshubin.condorcet.relational

import com.seanshubin.condorcet.typealiases.Instant

data class Election(
    val owner: String,
    val name: String,
    val description: String,
    val created: Instant,
    val start: Instant,
    val end: Instant
)
