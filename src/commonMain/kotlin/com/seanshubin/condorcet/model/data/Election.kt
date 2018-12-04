package com.seanshubin.condorcet.model.data

import com.seanshubin.condorcet.typealiases.Instant

data class Election(val name:String,
                    val description:String,
                    val candidates:List<Candidate>,
                    val created: Instant,
                    val start: Instant,
                    val end: Instant,
                    val group:String)
