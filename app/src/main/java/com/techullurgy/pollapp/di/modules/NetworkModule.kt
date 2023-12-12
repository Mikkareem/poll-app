package com.techullurgy.pollapp.di.modules

import com.techullurgy.pollapp.network.responses.AnsweredPollResponse
import com.techullurgy.pollapp.network.responses.NonAnsweredPollResponse
import com.techullurgy.pollapp.network.responses.PollResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.plugin
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(
                    Json {
                        serializersModule = SerializersModule {
                            polymorphic(PollResponse::class) {
                                subclass(AnsweredPollResponse::class, AnsweredPollResponse.serializer())
                                subclass(NonAnsweredPollResponse::class, NonAnsweredPollResponse.serializer())
                            }
                        }
                    }
                )
            }
        }.also {
            it.plugin(HttpSend).intercept { request ->
                val call = execute(request)
                call
            }
        }
    }
}