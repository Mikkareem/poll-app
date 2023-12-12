package com.techullurgy.pollapp.di.modules

import com.techullurgy.pollapp.data.DataSource
import com.techullurgy.pollapp.data.network.PollNetworkDataSource
import org.koin.dsl.module

val datasourceModule = module {
    single<DataSource> { PollNetworkDataSource(get()) }
}