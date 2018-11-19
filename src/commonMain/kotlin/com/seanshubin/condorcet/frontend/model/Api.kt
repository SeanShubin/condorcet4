package com.seanshubin.condorcet.frontend.model

interface Api {
    fun register(email:Email, name:VoterName, password:Password): Result
    fun login(email:Email, password:Password): Result
    fun createElection(voterName:VoterName, electionName:ElectionName): Result
    fun voters():List<Voter>
}
