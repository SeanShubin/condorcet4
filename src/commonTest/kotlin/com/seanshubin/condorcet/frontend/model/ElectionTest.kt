package com.seanshubin.condorcet.frontend.model

import kotlin.test.Test
import kotlin.test.assertEquals
import com.seanshubin.condorcet.frontend.model.Result.Companion.Success
import com.seanshubin.condorcet.frontend.model.Result.Companion.Failure
import com.seanshubin.condorcet.frontend.model.TestApiFactory.createApi
import com.seanshubin.condorcet.frontend.model.TestApiFactory.createApiWithVoter

class ElectionTest {
    @Test
    fun createElection(){
        // given
        val (api, voterName) = createApiWithVoter()
        val electionName = ElectionName("My Election")

        // when
        val result = api.createElection(voterName,electionName)

        // then
        assertEquals(Success, result)
    }
}