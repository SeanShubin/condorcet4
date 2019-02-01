package com.seanshubin.condorcet.memory

class MemCell(val value: Any) {
    val int: Int get() = value as Int
    val string: String get() = value as String
}
