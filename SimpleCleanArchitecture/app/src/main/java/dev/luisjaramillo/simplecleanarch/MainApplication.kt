package dev.luisjaramillo.simplecleanarch

import android.app.Application
import dev.luisjaramillo.simplecleanarch.di.userModule
import dev.luisjaramillo.simplecleanarch.features.user.di.userProfileViewModel
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                userModule,
                userProfileViewModel
            )
        }
    }
}