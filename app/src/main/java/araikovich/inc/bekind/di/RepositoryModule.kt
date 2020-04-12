package araikovich.inc.bekind.di

import araikovich.inc.bekind.data.repository.TasksRepository
import araikovich.inc.bekind.data.repository.impl.TasksRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {

    factory<TasksRepository> {
        TasksRepositoryImpl(
            get(),
            get(),
            get(named("2")),
            get(named("3")),
            get(named("1")),
            get(named("4")),
            get(named("5")),
            get(named("6")),
            get(named("8")),
            get(named("7")),
            get(named("9"))
        )
    }
}