package araikovich.inc.bekind.data.cached_data_sources.impl

import araikovich.inc.bekind.data.cached_data_sources.TasksCachedDataSource
import araikovich.inc.bekind.data.entities.AdviceEntity
import araikovich.inc.bekind.data.entities.MissionEntity
import araikovich.inc.bekind.data.entities.SmallDeedEntity
import araikovich.inc.bekind.data.storage.BeKindDataBase

class TasksCachedDataSourceImpl(private val db: BeKindDataBase) : TasksCachedDataSource {

    override suspend fun getAdvices(): List<AdviceEntity> =
        db.advicesDao().getAll()

    override suspend fun getSmallDeeds(): List<SmallDeedEntity> =
        db.smallDeedsDao().getAll()

    override suspend fun getMissions(): List<MissionEntity> =
        db.missionsDao().getAll()

    override suspend fun saveAdvices(items: List<AdviceEntity>) {
        items.forEach {
            db.advicesDao().insertAll(it)
        }
    }

    override suspend fun saveAdvice(item: AdviceEntity) {
        db.advicesDao().insertAll(item)
    }

    override suspend fun saveSmallDeeds(items: List<SmallDeedEntity>) {
        items.forEach {
            db.smallDeedsDao().insertAll(it)
        }
    }

    override suspend fun saveSmallDeed(item: SmallDeedEntity) {
        db.smallDeedsDao().insertAll(item)
    }

    override suspend fun saveMissions(items: List<MissionEntity>) {
        items.forEach {
            db.missionsDao().insertAll(it)
        }
    }

    override suspend fun saveMission(item: MissionEntity) {
        db.missionsDao().insertAll(item)
    }

    override suspend fun getAdviceById(id: Int): AdviceEntity? =
        db.advicesDao().

            getAdvice(id)
}