package com.seanshubin.condorcet.frontend

interface Event {
    data class LoginRequest(val nameOrEmail: String, val password: String) : Event
    data class LoginSuccess(val name: String, val password: String, val electionNames: List<String>) :
        Event

    data class LoginFailure(val reason: String) : Event
    data class NavigateToElection(val credentials: Credentials, val electionName: String) :
        Event

    object Logout : Event
    data class RegisterRequest(val name: String, val email: String, val password: String) :
        Event

    object NavigateToRegisterPage : Event
    data class RegisterSuccess(val name: String, val password: String, val electionNames: List<String>) : Event
    data class RegisterFailure(val reason: String) : Event
    data class CreateElectionRequest(val credentials: Credentials, val electionName: String) :
        Event

    data class CreateElectionSuccess(val principal: String, val electionName: String) :
        Event

    data class CreateElectionFailure(val reason: String) : Event
    data class AddCandidateRequest(val credentials: Credentials, val electionName: String, val candidateName: String) :
        Event

    object AddCandidateSuccess : Event
}
