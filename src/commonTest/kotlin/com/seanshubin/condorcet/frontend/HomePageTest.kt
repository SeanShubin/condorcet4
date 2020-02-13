package com.seanshubin.condorcet.frontend

import kotlin.test.Test
import kotlin.test.assertEquals

class HomePageTest {
    @Test
    fun navigateToElection() {
        // given
        val name = "foo"
        val password = "bar"
        val credentials = Credentials(name, password)
        val electionNames = listOf("Election 1", "Election 2", "Election 3")
        val page = Page.Home(credentials, electionNames)
        val event = Event.NavigateToElection(credentials, "Election 2")
        val effect = Effect.NavigateToElection(credentials, "Election 2")

        // when
        val result = Reactor.reactTo(page, event)

        // then
        assertEquals(page, result.page)
        assertEquals(listOf(effect), result.effects)
    }

    @Test
    fun logout() {
        // given
        val name = "foo"
        val password = "bar"
        val credentials = Credentials(name, password)
        val electionNames = listOf("Election 1", "Election 2", "Election 3")
        val page = Page.Home(credentials, electionNames)
        val event = Event.Logout

        // when
        val result = Reactor.reactTo(page, event)

        // then
        assertEquals(Page.Login(), result.page)
        assertEquals(emptyList(), result.effects)
    }


    @Test
    fun createElectionRequest() {
        // given
        val name = "foo"
        val password = "bar"
        val credentials = Credentials(name, password)
        val electionNames = listOf("Election 1", "Election 2", "Election 3")
        val page = Page.Home(credentials, electionNames)
        val event = Event.CreateElectionRequest(credentials, "Election 4")
        val effect = Effect.CreateElection(credentials, "Election 4")

        // when
        val result = Reactor.reactTo(page, event)

        // then
        assertEquals(page, result.page)
        assertEquals(listOf(effect), result.effects)
    }

    @Test
    fun createElectionSuccess() {
        // given
        val name = "foo"
        val password = "bar"
        val credentials = Credentials(name, password)
        val electionNames = listOf("Election 1", "Election 2", "Election 3")
        val page = Page.Home(credentials, electionNames)
        val event = Event.CreateElectionSuccess(credentials, "Election 4")

        // when
        val result = Reactor.reactTo(page, event)

        // then
        assertEquals(
            Page.Election(
                credentials = credentials,
                electionName = "Election 4"
            ), result.page
        )
        assertEquals(emptyList(), result.effects)
    }

    @Test
    fun createElectionFailure() {
        // given
        val name = "foo"
        val password = "bar"
        val credentials = Credentials(name, password)
        val electionNames = listOf("Election 1", "Election 2", "Election 3")
        val page = Page.Home(credentials, electionNames)
        val event = Event.CreateElectionFailure("There is already an election named 'Election 4'")

        // when
        val result = Reactor.reactTo(page, event)

        // then
        assertEquals(
            Page.Home(
                credentials,
                electionNames,
                "There is already an election named 'Election 4'"
            ), result.page
        )
        assertEquals(emptyList(), result.effects)
    }
}
