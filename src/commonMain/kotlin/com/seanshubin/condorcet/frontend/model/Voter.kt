package com.seanshubin.condorcet.frontend.model

data class Voter(
    val email: Email,
    val name: VoterName,
    val password: Password,
    val groups: List<GroupName> = emptyList()
)
