package com.seanshubin.condorcet.reactive

data class State(val users: Users) {
    fun register(name: String, email: String, password: String): State =
        copy(users = users.register(name, email, password))

    fun login(name: String, password: String) {
        users.login(name, password)
    }
}
