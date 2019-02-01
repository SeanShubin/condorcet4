package com.seanshubin.condorcet.reactive

interface Event {
    companion object {
        data class Register(val name: String, val email: String, val password: String) : Event
        data class Login(val name: String, val password: String) : Event
        data class CreateElection(val ownerName: String, val electionName: String)
        data class AddCandidate(val electionName: String, val candidateName: String)
    }
}
