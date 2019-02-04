package com.seanshubin.condorcet.frontend

import kotlin.test.Test
import kotlin.test.assertEquals

class LoginPageTest {
    @Test
    fun loginRequest() {
        // given
        val page = Page.Login()
        val name = "foo"
        val password = "bar"
        val event = Event.LoginRequest(name, password)
        val effect = Effect.Login(name, password)

        // when
        val result = Reactor.reactTo(page, event)

        // then
        assertEquals(Page.Login(), result.page)
        assertEquals(listOf(effect), result.effects)
    }

    @Test
    fun loginSuccess() {
        // given
        val page = Page.Login()
        val name = "foo"
        val password = "bar"
        val credentials = Credentials(name, password)
        val electionNames = listOf("Election 1", "Election 2", "Election 3")
        val event = Event.LoginSuccess(name, password, electionNames)

        // when
        val result = Reactor.reactTo(page, event)

        // then
        assertEquals(Page.Home(credentials, electionNames), result.page)
        assertEquals(emptyList(), result.effects)
    }

    @Test
    fun loginFailure() {
        // given
        val page = Page.Login()
        val reason = "Unable to log in"
        val event = Event.LoginFailure(reason)

        // when
        val result = Reactor.reactTo(page, event)

        // then
        assertEquals(Page.Login(message = "Unable to log in"), result.page)
        assertEquals(emptyList(), result.effects)
    }

    @Test
    fun navigateToRegisterPage() {
        // given
        val page = Page.Login()
        val event = Event.NavigateToRegisterPage

        // when
        val result = Reactor.reactTo(page, event)

        // then
        assertEquals(Page.Register(), result.page)
        assertEquals(emptyList(), result.effects)
    }
}
