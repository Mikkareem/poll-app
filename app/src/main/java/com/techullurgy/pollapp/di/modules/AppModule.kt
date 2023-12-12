package com.techullurgy.pollapp.di.modules

import com.techullurgy.pollapp.storage.SessionStorage
import org.koin.dsl.module

val appModule = module {
    single { SessionStorage(get()) }
}