package com.seanshubin.condorcet.model.system

import com.seanshubin.condorcet.model.event.Event.Companion.VoterCreate
import com.seanshubin.condorcet.model.event.Event.Companion.ElectionCreate
import com.seanshubin.condorcet.model.event.Event.Companion.ElectionUpdate
import com.seanshubin.condorcet.model.event.Event.Companion.CandidateCreate
import com.seanshubin.condorcet.model.event.Event.Companion.RankingUpdate
import com.seanshubin.condorcet.model.event.Event.Companion.ElectionVoter
import com.seanshubin.condorcet.model.event.Event.Companion.ElectionTally

object SampleData {
    val list = listOf(
        VoterCreate("alice@email.com", "Alice", "alice-password"),
        VoterCreate("bob@email.com", "Bob", "bob-password"),
        VoterCreate("carol@email.com", "Carol", "carol-password"),
        VoterCreate("dave@email.com", "Dave", "dave-password"),
        ElectionCreate("Alice", "Ice Cream"),
        ElectionUpdate("Ice Cream", "Best flavor of ice cream", "2018-11-05", "2018-11-05"),
        ElectionVoter("Ice Cream", "Alice"),
        CandidateCreate("Ice Cream", "Vanilla"),
        CandidateCreate("Ice Cream", "Chocolate"),
        CandidateCreate("Ice Cream", "Strawberry"),
        RankingUpdate("Ice Cream", "Alice", "Vanilla", 1),
        RankingUpdate("Ice Cream", "Alice", "Chocolate", 2),
        RankingUpdate("Ice Cream", "Alice", "Strawberry", 3),
        ElectionTally("Ice Cream")
    )
}
