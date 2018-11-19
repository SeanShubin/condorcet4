package com.seanshubin.condorcet.frontend.model

import kotlin.test.Test
import kotlin.test.assertEquals
import com.seanshubin.condorcet.frontend.model.Result.Companion.Success
import com.seanshubin.condorcet.frontend.model.Result.Companion.Failure
import com.seanshubin.condorcet.frontend.model.TestApiFactory.createApi

class LoginTest {
    @Test
    fun loginVoter(){
        // given
        val api = createApi()
        val email = Email("foo@email")
        val name = VoterName("foo")
        val password = Password("correctPassword")
        api.register(email, name, password)

        // when
        val result = api.login(email, password)

        // then
        assertEquals(Success, result)
    }

    @Test
    fun loginVoterIncorrectPassword(){
        // given
        val api = createApi()
        val email = Email("foo@email")
        val name = VoterName("foo")
        val password = Password("correctPassword")
        val incorrectPassword = Password("incorrectPassword")
        api.register(email, name, password)

        // when
        val result = api.login(email, incorrectPassword)

        // then
        assertEquals(Failure("Incorrect password for email '$email'"), result)
    }

    @Test
    fun loginVoterDoesNotExist(){
        // given
        val api = createApi()
        val email = Email("foo@email")
        val password = Password("correctPassword")

        // when
        val result = api.login(email, password)

        // then
        assertEquals(Failure("Email 'foo@email' is not registered"), result)
    }
}