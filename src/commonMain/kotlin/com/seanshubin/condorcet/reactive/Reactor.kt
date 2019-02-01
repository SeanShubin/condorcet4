package com.seanshubin.condorcet.reactive

class Reactor(initialState: State) {
    private var state = initialState
    fun handleEvent(event: Event): Result {
        val result = event.apply(state)
        state = result.state
        return result
    }
}