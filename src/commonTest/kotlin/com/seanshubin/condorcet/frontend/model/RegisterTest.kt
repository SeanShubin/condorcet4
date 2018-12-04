package com.seanshubin.condorcet.frontend.model

import kotlin.test.Test
import kotlin.test.assertEquals
import com.seanshubin.condorcet.frontend.model.Result.Companion.Success
import com.seanshubin.condorcet.frontend.model.Result.Companion.Failure
import com.seanshubin.condorcet.frontend.model.TestApiFactory.createApi

class RegisterTest {
    @Test
    fun registerUser(){
        // given
        val api = createApi()
        val email = Email("foo@mail.com")
        val name = VoterName("Foo")
        val password = Password("foo-password")
        val groups = listOf<GroupName>()
        val expectedVoter = Voter(email, name, password, groups)

        // when
        val result = api.register(email, name, password)
        val voters = api.voters()

        // then
        assertEquals(Success, result)
        assertEquals(1, voters.size)
        assertEquals(expectedVoter, voters[0])
    }

    @Test
    fun dontAllowVoterDuplicateEmail(){
        // given
        val api = createApi()
        val email = Email("foo@mail.com")
        val name1 = VoterName("Foo")
        val name2 = VoterName("Bar")
        val password = Password("password")
        val groups = listOf<GroupName>()
        val expectedVoter = Voter(email, name1, password, groups)

        // when
        api.register(email, name1, password)
        val result = api.register(email, name2, password)
        val voters = api.voters()

        // then
        assertEquals(Failure("A user with email '$email' is already registered"), result)
        assertEquals(1, voters.size)
        assertEquals(expectedVoter, voters[0])
    }

    @Test
    fun dontAllowVoterDuplicateName() {
        // given
        val api = createApi()
        val email1 = Email("foo@mail.com")
        val email2 = Email("bar@mail.com")
        val name = VoterName("Foo")
        val password = Password("password")
        val groups = listOf<GroupName>()
        val expectedVoter = Voter(email1, name, password, groups)

        // when
        api.register(email1, name, password)
        val result = api.register(email2, name, password)
        val voters = api.voters()

        // then
        assertEquals(Failure("A user with name '$name' is already registered"), result)
        assertEquals(1, voters.size)
        assertEquals(expectedVoter, voters[0])
    }
}