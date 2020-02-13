package com.seanshubin.condorcet.relational

interface Result {
    companion object {
        object Success : Result
        data class Failure(val reason: String) : Result
    }
}
