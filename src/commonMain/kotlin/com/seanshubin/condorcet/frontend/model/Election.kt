package com.seanshubin.condorcet.frontend.model

import com.seanshubin.condorcet.typealiases.Instant

data class Election(
    val name:ElectionName,
    val description: String,
    val created: Instant,
    val owner: VoterName
)
