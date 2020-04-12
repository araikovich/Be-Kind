package araikovich.inc.bekind.data.mappers

import araikovich.inc.bekind.data.entities.MissionEntity
import araikovich.inc.bekind.ui.home.data.MissionModel

class MissionEntityToModelMapper: Mapper<MissionEntity, MissionModel> {
    override fun map(source: MissionEntity) = MissionModel(
        source.id,
        source.title,
        source.description,
        source.missionCount,
        source.isLocked,
        source.openLevel,
        source.color
    )
}