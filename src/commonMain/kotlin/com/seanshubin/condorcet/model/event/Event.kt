package com.seanshubin.condorcet.model.event

import com.seanshubin.condorcet.model.system.Environment
import com.seanshubin.condorcet.typealiases.Instant

interface Event {
    fun pack(): Map<String, String>
    fun unpack(s: String): Event?
    fun invoke(e: Environment)

    companion object {
        data class VoterCreate(
            val email: String,
            val name: String,
            val password: String
        )

        data class VoterUpdatePassword(
            val voterEmail: String,
            val password: String
        )

        data class GroupCreate(
            val name: String
        )

        data class ElectionCreate(
            val owner: String,
            val name: String
        )

        data class ElectionUpdate(
            val name: String,
            val description: String,
            val start: String,
            val end: String
        )

        data class CandidateCreate(
            val election: String,
            val name: String
        )

        data class CandidateUpdate(
            val election: String,
            val name: String,
            val description: String
        )

        data class RankingUpdate(
            val election: String,
            val voter: String,
            val candidate: String,
            val ranking: Int
        )

        data class ElectionVoter(
            val election:String,
            val voter:String
        )

        data class ElectionTally(
            val election: String
        )
    }
}

