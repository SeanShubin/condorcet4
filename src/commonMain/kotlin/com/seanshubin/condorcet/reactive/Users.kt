package com.seanshubin.condorcet.reactive

data class Users(val list: List<User>) {
    fun register(rawName: String, rawEmail: String, password: String): Users {
        val name = normalize(rawName)
        val email = normalize(rawEmail)
        if (list.any(nameMatches(name))) throw StateException("User named '$name' already exists")
        if (list.any(emailMatches(email))) throw StateException("User with email '$email' already exists")
        val user = User(name, email, password)
        val newList = list + user
        return copy(list = newList)
    }

    fun login(rawName: String, password: String) {
        val name = normalize(rawName)
        val user = list.find(nameMatches(name))
        if (user == null) {
            throw StateException("user/password combination does not exist")
        } else {
            if (user.password != password) {
                throw StateException("user/password combination does not exist")
            }
        }
    }

    private fun nameMatches(name: String): (User) -> Boolean = { it.name == name }
    private fun emailMatches(email: String): (User) -> Boolean = { it.email == email }
    private fun normalize(s: String): String = s.trim().toLowerCase().replace(Regex("""\s+"""), " ")
}
