package com.seanshubin.condorcet.frontend.model

import com.seanshubin.condorcet.persistence.Persistence

class FakePersistence : Persistence {
    private val voters = mutableListOf<Voter>()
    override fun createVoter(voter: Voter) {
        voters.add(voter)
    }

    override fun voterEmailExists(email: Email): Boolean =voters.any { it.email == email }

    override fun voterNameExists(name: VoterName): Boolean = voters.any { it.name == name }

    override fun listVoterNames(): List<VoterName> = voters.map{it.name}

    override fun loadVoterByEmail(email: Email): Voter? = voters.find {it.email == email}
    override fun listVoterEmails(): List<Email> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadVoterByName(name: VoterName): Voter? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listElectionNames(): List<ElectionName> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createElection(election: Election) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}