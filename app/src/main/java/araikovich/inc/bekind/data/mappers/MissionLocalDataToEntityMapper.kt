package araikovich.inc.bekind.data.mappers

import araikovich.inc.bekind.data.entities.MissionEntity
import araikovich.inc.bekind.data.local_data.MissionLocalData

class MissionLocalDataToEntityMapper: Mapper<MissionLocalData, MissionEntity> {
    override fun map(source: MissionLocalData) = MissionEntity(
        source.id,
        source.title,
        source.description,
        source.missionCount,
        source.isLocked,
        source.openLevel,
        source.color
    )
}