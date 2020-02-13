package com.seanshubin.condorcet.relational

import com.seanshubin.condorcet.typealiases.Instant

interface Database {
    fun createVoter(name: String, email: String, password: String): Result
    fun authenticateVoter(email: String, password: String): Result
    fun createElection(voterName: String, electionName: String): Result
    fun updateElection(electionName: String, description: String, start: Instant, end: Instant): Result
    fun updateElectionVoters(electionName: String, voterNames: List<String>): Result
    fun updateCandidates(electionName: String, candidateNames: List<String>): Result
    fun updateCandidateDescription(electionName: String, candidateName: String, candidateDescription: String): Result
    fun createGroup(name: String): Result
    fun updateGroupVoters(name: String, voters: List<String>): Result
}
