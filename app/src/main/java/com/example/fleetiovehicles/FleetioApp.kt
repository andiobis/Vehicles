package com.example.fleetiovehicles

import android.app.Application
import com.example.fleetiocore.coreModule
import com.example.fleetiovehicles.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class FleetioApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@FleetioApp)
            modules(listOf(appModule, coreModule))
        }
    }


}