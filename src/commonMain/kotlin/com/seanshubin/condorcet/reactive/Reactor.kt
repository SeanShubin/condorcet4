package com.seanshubin.condorcet.reactive

import com.seanshubin.condorcet.reactive.Effect.FireEvent
import com.seanshubin.condorcet.reactive.Event.*

object Reactor {
    fun handleEvent(state: State, event: Event): Result {
        return when (event) {
            is Register -> register(state, event.name, event.email, event.password)
            is Login -> login(state, event.name, event.password)
            else -> throw UnsupportedEventException(event)
        }
    }

    private fun register(state: State, name: String, email: String, password: String): Result =
        try {
            val newState = state.register(name, email, password)
            val effect = FireEvent(RegisterSuccess(name))
            Result(newState, listOf(effect))
        } catch (ex: StateException) {
            val effect = FireEvent(RegisterFailure(name, ex.reason))
            Result(state, listOf(effect))
        }

    private fun login(state: State, name: String, password: String): Result =
        try {
            state.login(name, password)
            val effect = FireEvent(LoginSuccess(name))
            Result(state, listOf(effect))
        } catch (ex: StateException) {
            val effect = FireEvent(LoginFailure(name, ex.reason))
            Result(state, listOf(effect))
        }
}
