package araikovich.inc.bekind.di

import android.content.Context
import araikovich.inc.bekind.App
import org.koin.dsl.module

val appModule = module {
    single<Context>(override = true) { App.instance.applicationContext }
}