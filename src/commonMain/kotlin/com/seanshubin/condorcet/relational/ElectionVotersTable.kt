package com.seanshubin.condorcet.relational

interface ElectionVotersTable {
    fun queryVoters(electionName: String): List<String>
    fun deleteVoters(electionName: String, voterNames: List<String>)
    fun insertVoters(electionName: String, voterNames: List<String>)
}
