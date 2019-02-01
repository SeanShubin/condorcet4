package com.seanshubin.condorcet.memory

class MemTable(val columns: List<MemColumn>) {
    val rows = mutableListOf<MemRow>()
    val indexMap: Map<String, Int> = columns.mapIndexed(::toIndexEntry).toMap()
    fun insert(vararg cells: Any) {
        validateSize(*cells)
        validateDataTypes(*cells)
        rows.add(MemRow(indexMap, cells.toList()))
    }

    fun query(filter: (MemRow) -> Boolean): List<MemRow> = rows.filter(filter)
    private fun validateSize(vararg cells: Any) {
        if (cells.size != columns.size) {
            throw RuntimeException("Expected ${columns.size}, got ${cells.size}")
        }
    }

    private fun validateDataTypes(vararg cells: Any) {
        val columnsAndCells = columns zip cells
        columnsAndCells.forEach(::validateColumnAndCell)
    }

    private fun validateColumnAndCell(columnAndCell: Pair<MemColumn, Any>) {
        val (column, cell) = columnAndCell
        column.validateCell(cell)
    }

    private fun toIndexEntry(index: Int, column: MemColumn): Pair<String, Int> =
        Pair(column.name, index)
}
