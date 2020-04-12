package araikovich.inc.bekind.di

import araikovich.inc.bekind.data.cached_data_sources.TasksCachedDataSource
import araikovich.inc.bekind.data.cached_data_sources.impl.TasksCachedDataSourceImpl
import araikovich.inc.bekind.data.local_providers.TasksLocalProvider
import araikovich.inc.bekind.data.local_providers.impl.TasksLocalProviderImpl
import org.koin.dsl.module

val dataSourceModule = module {
    factory { TasksLocalProviderImpl() as TasksLocalProvider }
    factory { TasksCachedDataSourceImpl(get()) as TasksCachedDataSource }
}