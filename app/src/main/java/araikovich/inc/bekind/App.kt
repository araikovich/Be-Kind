package araikovich.inc.bekind

import android.app.Application
import araikovich.inc.bekind.di.*
import org.koin.android.ext.koin.androidContext

class App : Application() {

    companion object {

        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin()
    }

    private fun startKoin() {
        org.koin.core.context.startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    homeScreenViewModel, useCaseModule, storageModule,
                    repositoryModule, mapperModule, dataSourceModule, appModule
                )
            )
        }
    }
}