package com.seanshubin.condorcet.frontend

interface Page {
    data class Login(val message: String? = null) : Page

    data class Register(val message: String? = null) : Page

    data class Home(val credentials: Credentials, val electionNames: List<String>) : Page

    class Election(
        val credentials: Credentials,
        val electionName: String,
        val eligibleVoters: List<String>,
        val candidates: List<String>,
        val electionStart: String,
        val electionEnd: String,
        val secretBallot: Boolean
    ) : Page
}
