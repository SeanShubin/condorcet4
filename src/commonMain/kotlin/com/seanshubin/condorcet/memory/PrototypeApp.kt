package com.seanshubin.condorcet.memory

fun main(args: Array<String>) {
    val memDb = MemDb()
    memDb.createTable(
        "user",
        Pair("id", Int::class),
        Pair("name", String::class),
        Pair("email", String::class)
    )
    memDb.insert("user", 123, "Alice", "alice@email.com")
    memDb.insert("user", 234, "Bob", "bob@email.com")
    memDb.insert("user", 345, "Carol", "carol@email.com")
    memDb.insert("user", 456, "Dave", "dave@email.com")
    println(memDb.query("user") { it["name"].string == "Bob" })
    val bob = memDb.queryOne("user") { it["name"].string == "Bob" }
    println(bob["id"].int)
    println(bob["name"].string)
    println(bob["email"].string)
}
