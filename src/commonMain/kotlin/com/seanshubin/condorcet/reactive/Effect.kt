package com.seanshubin.condorcet.reactive

interface Effect {
    data class FireEvent(val event: Event) : Effect
}
