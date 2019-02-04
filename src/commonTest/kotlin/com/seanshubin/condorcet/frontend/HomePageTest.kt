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
}
