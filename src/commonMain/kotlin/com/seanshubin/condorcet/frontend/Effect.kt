package com.seanshubin.condorcet.frontend

interface Effect {
    data class Login(val nameOrEmail: String, val password: String) : Effect
    data class NavigateToElection(val credentials: Credentials, val electionName: String) :
        Effect

    object NavigateToRegister : Effect
    data class Register(val name: String, val email: String, val password: String) :
        Effect
}
