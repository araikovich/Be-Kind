package araikovich.inc.bekind.di

import araikovich.inc.bekind.ui.home.HomeScreenViewModel
import org.koin.dsl.module

val homeScreenViewModel = module {
    single { HomeScreenViewModel(get()) }
}