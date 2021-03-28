package com.siziksu.framework

import android.app.Application
import com.siziksu.framework.di.appModule
import com.siziksu.port.di.portModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
            modules(portModule)
        }
    }
}
