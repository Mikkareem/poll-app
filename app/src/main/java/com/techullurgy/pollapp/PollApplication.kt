package com.techullurgy.pollapp

import android.app.Application
import com.techullurgy.pollapp.di.modules.appModule
import com.techullurgy.pollapp.di.modules.datasourceModule
import com.techullurgy.pollapp.di.modules.networkModule
import com.techullurgy.pollapp.di.modules.useCasesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PollApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PollApplication)
            modules(appModule, networkModule, datasourceModule, useCasesModule)
        }
    }
}