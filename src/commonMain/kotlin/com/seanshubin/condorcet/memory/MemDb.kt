package com.seanshubin.condorcet.memory


import com.seanshubin.condorcet.memory.MemColumn.Companion.fromNameAndType
import kotlin.reflect.KClass

class MemDb {
    val tableMap = mutableMapOf<String, MemTable>()
    fun createTable(name: String, vararg columnPairs: Pair<String, KClass<*>>) {
        val columns = columnPairs.map(::fromNameAndType)
        tableMap[name] = MemTable(columns)
    }

    fun insert(tableName: String, vararg cell: Any) {
        table(tableName).insert(*cell)
    }

    fun query(tableName: String, filter: (MemRow) -> Boolean): List<MemRow> =
        table(tableName).query(filter)

    fun queryOne(tableName: String, filter: (MemRow) -> Boolean): MemRow {
        val results = query(tableName, filter)
        if (results.size == 1) {
            return results[0]
        } else {
            throw RuntimeException("Expected exactly one result, got ${results.size}")
        }
    }

    fun table(tableName: String): MemTable {
        val table = tableMap[tableName]
        if (table == null) {
            throw RuntimeException("Table '$tableName' does not exist")
        } else {
            return table
        }
    }
}
