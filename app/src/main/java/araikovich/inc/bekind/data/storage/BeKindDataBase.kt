package araikovich.inc.bekind.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import araikovich.inc.bekind.data.entities.AdviceEntity
import araikovich.inc.bekind.data.entities.MissionEntity
import araikovich.inc.bekind.data.entities.SmallDeedEntity
import araikovich.inc.bekind.data.storage.dao.AdviceDao
import araikovich.inc.bekind.data.storage.dao.MissionDao
import araikovich.inc.bekind.data.storage.dao.SmallDeedsDao
import araikovich.inc.bekind.data.typeconverters.ActionModelTypeConverter

@Database(
    entities = [
        AdviceEntity::class,
        SmallDeedEntity::class,
        MissionEntity::class
    ],
    version = 1
)
@TypeConverters(
    ActionModelTypeConverter::class
)
abstract class BeKindDataBase : RoomDatabase() {

    abstract fun advicesDao(): AdviceDao

    abstract fun smallDeedsDao(): SmallDeedsDao

    abstract fun missionsDao(): MissionDao
}