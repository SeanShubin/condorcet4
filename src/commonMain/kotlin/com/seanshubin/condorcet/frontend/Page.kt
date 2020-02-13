package com.seanshubin.condorcet.frontend

interface Page {
    fun createElectionFailure(message: String): Page = TODO()
    data class Login(val message: String? = null) : Page

    data class Register(val message: String? = null) : Page

    data class Home(
        val credentials: Credentials,
        val electionNames: List<String>,
        val message: String? = null
    ) : Page {
        override fun createElectionFailure(message: String): Page = copy(message = message)
    }

    data class Election(
        val credentials: Credentials,
        val electionName: String,
        val eligibleVoters: List<String> = emptyList(),
        val candidates: List<String> = emptyList(),
        val electionStart: String? = null,
        val electionEnd: String? = null,
        val secretBallot: Boolean = true
    ) : Page
}
