package araikovich.inc.bekind.data.mappers

import araikovich.inc.bekind.data.local_data.MissionLocalData
import araikovich.inc.bekind.ui.home.data.MissionModel

class MissionLocalDataToModelMapper : Mapper<MissionLocalData, MissionModel> {
    override fun map(source: MissionLocalData) = MissionModel(
        source.id,
        source.title,
        source.description,
        source.missionCount,
        source.isLocked,
        source.openLevel,
        source.color
    )
}