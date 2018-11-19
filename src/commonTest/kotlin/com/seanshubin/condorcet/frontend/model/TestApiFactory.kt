package com.seanshubin.condorcet.frontend.model

object TestApiFactory{
    fun createApi():Api {
        val persistence = FakePersistence()
        return PersistingApi(persistence)
    }
    fun createApiWithVoter():Pair<Api, VoterName> {
        val api = createApi()
        val email = Email("alice@email.com")
        val name = VoterName("Alice")
        val password = Password("password")
        api.register(email, name, password)
        return Pair(api, name)
    }
}