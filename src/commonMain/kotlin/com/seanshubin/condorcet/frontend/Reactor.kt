package com.seanshubin.condorcet.frontend

object Reactor {
    fun reactTo(page: Page, event: Event): Result {
        return when (event) {
            is Event.LoginRequest -> loginRequest(page, event)
            is Event.LoginSuccess -> loginSuccess(event)
            is Event.LoginFailure -> loginFailure(event)
            is Event.RegisterRequest -> registerRequest(page, event)
            is Event.RegisterSuccess -> registerSuccess(event)
            is Event.RegisterFailure -> registerFailure(event)
            is Event.Logout -> logout()
            is Event.NavigateToElection -> navigateToElection(page, event)
            is Event.NavigateToRegisterPage -> navigateToRegisterPage()
            else -> unsupportedEvent(event)
        }
    }

    private fun loginRequest(page: Page, event: Event.LoginRequest): Result {
        val effect = Effect.Login(event.nameOrEmail, event.password)
        return Result(page, listOf(effect))
    }

    private fun loginSuccess(event: Event.LoginSuccess): Result {
        val credentials = Credentials(event.name, event.password)
        val page = Page.Home(credentials, event.electionNames)
        return Result(page, emptyList())
    }

    private fun loginFailure(event: Event.LoginFailure): Result {
        val page = Page.Login(message = event.reason)
        return Result(page, emptyList())
    }

    private fun logout(): Result = Result(Page.Login(), emptyList())

    private fun navigateToElection(page: Page, event: Event.NavigateToElection): Result {
        val effect = Effect.NavigateToElection(event.credentials, event.electionName)
        return Result(page, listOf(effect))
    }

    private fun registerRequest(page: Page, event: Event.RegisterRequest): Result {
        val effect = Effect.Register(event.name, event.email, event.password)
        return Result(page, listOf(effect))
    }

    private fun registerSuccess(event: Event.RegisterSuccess): Result {
        val credentials = Credentials(event.name, event.password)
        val page = Page.Home(credentials, event.electionNames)
        return Result(page, emptyList())
    }

    private fun registerFailure(event: Event.RegisterFailure): Result {
        val page = Page.Register(message = event.reason)
        return Result(page, emptyList())
    }

    private fun navigateToRegisterPage(): Result = Result(Page.Register(), emptyList())

    private fun unsupportedEvent(event: Event): Result = throw RuntimeException("Unsupported event: $event")
}
