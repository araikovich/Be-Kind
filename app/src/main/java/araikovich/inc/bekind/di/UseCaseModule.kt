package araikovich.inc.bekind.di

import araikovich.inc.bekind.domain.HomeScreenFetchDataUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory { HomeScreenFetchDataUseCase(get()) }
}