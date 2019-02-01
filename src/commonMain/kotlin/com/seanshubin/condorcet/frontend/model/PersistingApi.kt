package com.seanshubin.condorcet.frontend.model

import com.seanshubin.condorcet.frontend.model.Result.Companion.Failure
import com.seanshubin.condorcet.frontend.model.Result.Companion.Success
import com.seanshubin.condorcet.persistence.Persistence

class PersistingApi(val persistence: Persistence):Api{
    override fun register(email: Email, name: VoterName, password: Password): Result {
        return when {
            emailExists(email) -> Result.Companion.Failure("A user with email '$email' is already registered")
            nameExists(name) -> Result.Companion.Failure("A user with name '$name' is already registered")
            else -> addVoter(email, name, password)
        }
    }

    override fun login(email: Email, password: Password): Result {
        val voter = persistence.loadVoterByEmail(email)
        return when {
            voter == null -> Failure("Email '$email' is not registered")
            voter.password == password -> Success
            else -> Failure("Incorrect password for email '$email'")
        }
    }

    override fun createElection(voterName: VoterName, electionName: ElectionName): Result {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun voters(): List<Voter> = TODO()

    private fun emailExists(email: Email): Boolean = persistence.voterEmailExists(email)
    private fun nameExists(name: VoterName): Boolean = persistence.voterNameExists(name)
    private fun addVoter(email: Email, name: VoterName, password: Password):Result {
        persistence.createVoter(Voter(email, name, password))
        return Result.Companion.Success
    }
}
