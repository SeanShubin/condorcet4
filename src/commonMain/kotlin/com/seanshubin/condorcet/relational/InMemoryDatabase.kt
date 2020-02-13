package com.seanshubin.condorcet.relational

import com.seanshubin.condorcet.relational.Result.Companion.Failure
import com.seanshubin.condorcet.relational.Result.Companion.Success
import com.seanshubin.condorcet.typealiases.Instant

class InMemoryDatabase(
    private val voterTable: VoterTable,
    private val electionTable: ElectionTable,
    private val electionVotersTable: ElectionVotersTable
) : Database {
    override fun createVoter(name: String, email: String, password: String): Result {
        return when {
            voterTable.nameExists(name) -> Failure("Voter with name '$name' already exists")
            voterTable.emailExists(name) -> Failure("Voter with email '$email' already exists")
            else -> {
                voterTable.insertRow(name, email, password)
                Success
            }
        }
    }

    override fun authenticateVoter(email: String, password: String): Result {
        return if (voterTable.emailMatchesPassword(email, password)) {
            Success
        } else {
            Failure("Incorrect password for user '$email'")
        }
    }

    override fun createElection(voterName: String, electionName: String): Result {
        return if (electionTable.nameExists(electionName)) {
            Failure("Election named '$electionName' already exists")
        } else {
            electionTable.insertRow(voterName, electionName)
            Success
        }
    }

    override fun updateElection(
        electionName: String,
        description: String,
        start: Instant,
        end: Instant
    ): Result {
        return if (electionTable.nameExists(electionName)) {
            electionTable.updateRow(electionName, description, start, end)
            Success
        } else {
            Failure("Election named '$electionName' does not exist")
        }
    }

    override fun updateElectionVoters(electionName: String, voterNames: List<String>): Result {
        val existing = electionVotersTable.queryVoters(electionName)

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateCandidates(electionName: String, candidateNames: List<String>): Result {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateCandidateDescription(
        electionName: String,
        candidateName: String,
        candidateDescription: String
    ): Result {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createGroup(name: String): Result {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateGroupVoters(name: String, voters: List<String>): Result {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}