package com.seanshubin.condorcet.frontend

interface Api {
    fun sendLoginRequest(nameOrEmail: String, password: String)
}