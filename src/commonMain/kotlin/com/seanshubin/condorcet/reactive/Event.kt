package com.seanshubin.condorcet.reactive

interface Event {
    data class Register(val name: String, val email: String, val password: String) : Event
    data class RegisterSuccess(val name: String) : Event
    data class RegisterFailure(val name: String, val reason: String) : Event
    data class Login(val name: String, val password: String) : Event
    data class LoginSuccess(val name: String) : Event
    data class LoginFailure(val name: String, val reason: String) : Event
}
