package com.seanshubin.condorcet.persistence

import com.seanshubin.condorcet.frontend.model.*

interface Persistence {
    fun createVoter(voter: Voter)
    fun listVoterNames():List<VoterName>
    fun listVoterEmails():List<Email>
    fun voterEmailExists(email: Email):Boolean
    fun voterNameExists(name:VoterName):Boolean
    fun loadVoterByEmail(email:Email):Voter?
    fun loadVoterByName(name:VoterName):Voter?
    fun listElectionNames():List<ElectionName>
    fun createElection(election: Election)
}
