package com.seanshubin.condorcet.relational

interface VoterTable {
    fun insertRow(name: String, email: String, password: String)
    fun nameExists(name: String): Boolean
    fun emailExists(email: String): Boolean
    fun emailMatchesPassword(email: String, password: String): Boolean
}
