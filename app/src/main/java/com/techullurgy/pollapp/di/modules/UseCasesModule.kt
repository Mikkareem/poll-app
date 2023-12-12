package com.techullurgy.pollapp.di.modules

import com.techullurgy.pollapp.domain.usecases.GetPollDetailsByPollId
import com.techullurgy.pollapp.domain.usecases.RegisterUserUseCase
import org.koin.dsl.module

val useCasesModule = module {
    single { RegisterUserUseCase(get()) }
    single { GetPollDetailsByPollId(get()) }
}