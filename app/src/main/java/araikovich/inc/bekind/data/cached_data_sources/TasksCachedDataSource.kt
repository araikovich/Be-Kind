package araikovich.inc.bekind.data.cached_data_sources

import araikovich.inc.bekind.data.entities.AdviceEntity
import araikovich.inc.bekind.data.entities.MissionEntity
import araikovich.inc.bekind.data.entities.SmallDeedEntity

interface TasksCachedDataSource {

    suspend fun getAdvices(): List<AdviceEntity>

    suspend fun getSmallDeeds(): List<SmallDeedEntity>

    suspend fun getMissions(): List<MissionEntity>

    suspend fun saveAdvices(items: List<AdviceEntity>)

    suspend fun saveAdvice(item: AdviceEntity)

    suspend fun saveSmallDeeds(items: List<SmallDeedEntity>)

    suspend fun saveSmallDeed(item: SmallDeedEntity)

    suspend fun saveMissions(items: List<MissionEntity>)

    suspend fun saveMission(item: MissionEntity)

    suspend fun getAdviceById(id: Int): AdviceEntity?
}