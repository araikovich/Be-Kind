package araikovich.inc.bekind.data.mappers

import araikovich.inc.bekind.data.entities.AdviceEntity
import araikovich.inc.bekind.ui.home.data.AdviceModel

class AdviceEntityToModelMapper: Mapper<AdviceEntity, AdviceModel> {
    override fun map(source: AdviceEntity) = AdviceModel(
        source.id,
        source.adviceText,
        source.authorText
    )
}