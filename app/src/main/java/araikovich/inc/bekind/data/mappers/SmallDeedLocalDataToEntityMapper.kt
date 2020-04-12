package araikovich.inc.bekind.data.mappers

import araikovich.inc.bekind.data.entities.SmallDeedEntity
import araikovich.inc.bekind.data.local_data.SmallDeedLocalData

class SmallDeedLocalDataToEntityMapper : Mapper<SmallDeedLocalData, SmallDeedEntity> {
    override fun map(source: SmallDeedLocalData) = SmallDeedEntity(
        source.id,
        source.title,
        source.action,
        source.color
    )
}