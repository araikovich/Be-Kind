package araikovich.inc.bekind.data.mappers

import araikovich.inc.bekind.data.entities.AdviceEntity
import araikovich.inc.bekind.data.local_data.AdviceLocalDataModel

class AdviceLocalDataToEntityMapper : Mapper<AdviceLocalDataModel, AdviceEntity> {
    override fun map(source: AdviceLocalDataModel) = AdviceEntity(
        source.id,
        source.adviceText,
        source.authorText,
        ""
    )
}