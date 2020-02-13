package com.seanshubin.condorcet.frontend

import kotlin.test.Test
import kotlin.test.assertEquals

class RegisterPageTest {
    @Test
    fun registerRequest() {
        // given
        val page = Page.Register()
        val name = "foo"
        val email = "foo@bar.com"
        val password = "bar"
        val event = Event.RegisterRequest(name, email, password)
        val effect = Effect.Register(name, email, password)

        // when
        val result = Reactor.reactTo(page, event)

        // then
        assertEquals(Page.Register(), result.page)
        assertEquals(listOf(effect), result.effects)
    }

    @Test
    fun registerSuccess() {
        // given
        val page = Page.Register()
        val name = "foo"
        val password = "bar"
        val credentials = Credentials(name, password)
        val electionNames = listOf("Election 1", "Election 2", "Election 3")
        val event = Event.RegisterSuccess(name, password, electionNames)

        // when
        val result = Reactor.reactTo(page, event)

        // then
        assertEquals(Page.Home(credentials, electionNames), result.page)
        assertEquals(emptyList(), result.effects)
    }

    @Test
    fun registerFailure() {
        // given
        val page = Page.Register()
        val reason = "Unable to register"
        val event = Event.RegisterFailure(reason)

        // when
        val result = Reactor.reactTo(page, event)

        // then
        assertEquals(Page.Register(message = "Unable to register"), result.page)
        assertEquals(emptyList(), result.effects)
    }
}
