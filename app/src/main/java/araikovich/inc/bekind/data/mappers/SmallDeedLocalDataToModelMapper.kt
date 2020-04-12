package araikovich.inc.bekind.data.mappers

import araikovich.inc.bekind.data.local_data.SmallDeedLocalData
import araikovich.inc.bekind.ui.home.data.SmallDeedModel

class SmallDeedLocalDataToModelMapper : Mapper<SmallDeedLocalData, SmallDeedModel> {
    override fun map(source: SmallDeedLocalData) = SmallDeedModel(
        source.id,
        source.title,
        source.action,
        source.color
    )
}