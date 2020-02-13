package com.seanshubin.condorcet.relational

import com.seanshubin.condorcet.typealiases.Instant

interface ElectionTable {
    fun nameExists(name: String): Boolean
    fun insertRow(owner: String, name: String)
    fun updateRow(name: String, description: String, start: Instant, end: Instant)
}
