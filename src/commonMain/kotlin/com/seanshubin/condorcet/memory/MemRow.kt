package com.seanshubin.condorcet.memory

data class MemRow(val columnIndex: Map<String, Int>, val cells: List<Any>) {
    operator fun get(name: String): MemCell =
        MemCell(cells[columnIndex[name]!!])

    override fun toString(): String = cells.joinToString(", ")
}
