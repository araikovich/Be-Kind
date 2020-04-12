package araikovich.inc.bekind.di

import android.content.Context
import androidx.room.Room
import araikovich.inc.bekind.data.storage.BeKindDataBase
import org.koin.dsl.module

private const val BE_KIND_DATABASE = "be_kind_database"

val storageModule = module {
    single {
        return@single Room.databaseBuilder(
            get() as Context,
            BeKindDataBase::class.java,
            BE_KIND_DATABASE
        ).fallbackToDestructiveMigration().build()
    }
}