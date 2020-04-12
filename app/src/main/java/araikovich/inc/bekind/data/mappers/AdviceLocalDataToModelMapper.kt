package araikovich.inc.bekind.data.mappers

import araikovich.inc.bekind.data.local_data.AdviceLocalDataModel
import araikovich.inc.bekind.ui.home.data.AdviceModel

class AdviceLocalDataToModelMapper : Mapper<AdviceLocalDataModel, AdviceModel> {
    override fun map(source: AdviceLocalDataModel) = AdviceModel(
        source.id,
        source.adviceText,
        source.authorText
    )
}