package com.seanshubin.condorcet.memory

import kotlin.reflect.KClass

data class MemColumn(val name: String, val type: KClass<*>) {
    fun validateCell(cell: Any) {
//        if (cell::class != type) {
//            throw RuntimeException("Expected class '$type', got '${cell::class}'")
//        }
    }

    companion object {
        fun fromNameAndType(nameAndType: Pair<String, KClass<*>>): MemColumn {
            val (name, type) = nameAndType
            return MemColumn(name, type)
        }
    }
}
