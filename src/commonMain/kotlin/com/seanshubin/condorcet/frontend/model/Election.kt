package com.seanshubin.condorcet.frontend.model

data class Election(
    val name:ElectionName,
    val description: String,
    val created: Instant,
    val owner: VoterName
)
