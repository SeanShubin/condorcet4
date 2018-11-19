package com.seanshubin.condorcet.frontend.model

sealed class Result {
     companion object {
         object Success: Result()
         data class Failure(val message:String): Result()
     }
}
