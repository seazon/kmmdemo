package com.vickikbt.kmptemplate.android

import android.app.Application
import com.vickikbt.kmptemplate.android.di.androidModule
import com.vickikbt.kmptemplate.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class AndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val androidModules = listOf(androidModule)
        initKoin {
            androidLogger(level = if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(androidContext = this@AndroidApplication)
            modules(androidModules)
        }
    }
}
