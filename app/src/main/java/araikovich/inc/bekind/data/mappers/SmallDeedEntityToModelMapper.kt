package araikovich.inc.bekind.data.mappers

import araikovich.inc.bekind.data.entities.SmallDeedEntity
import araikovich.inc.bekind.ui.home.data.SmallDeedModel

class SmallDeedEntityToModelMapper: Mapper<SmallDeedEntity, SmallDeedModel> {
    override fun map(source: SmallDeedEntity) = SmallDeedModel(
        source.id,
        source.title,
        source.action,
        source.color
    )
}