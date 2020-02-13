package com.seanshubin.condorcet.data

import com.seanshubin.condorcet.typealiases.Instant

data class Voter(
    val id: Int,
    val name: String,
    val email: String
)

data class Election(
    val id: Int,
    val creatorId: Int,
    val name: String,
    val start: Instant,
    val end: Instant,
    val secretBallot: Boolean
)

data class Candidate(
    val id: Int,
    val name: String,
    val electionId: Int
)

data class Ballot(
    val id: Int,
    val voterId: Int,
    val electionId: Int
)

data class Ranking(
    val id: Int,
    val ballotId: Int,
    val rank: Int,
    val candidateId: Int
)

data class Tally(
    val id: Int,
    val electionId: Int
)

data class TallyRanking(
    val tallyId: Int,
    val rank: Int,
    val candidateId: Int
)
