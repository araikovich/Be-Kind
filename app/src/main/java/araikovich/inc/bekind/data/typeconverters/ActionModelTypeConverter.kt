package araikovich.inc.bekind.data.typeconverters

import androidx.room.TypeConverter
import araikovich.inc.bekind.ui.home.data.ActionModel

class ActionModelTypeConverter {

    @TypeConverter
    fun convertActionModelToInt(actionModel: ActionModel) = when (actionModel) {
        ActionModel.Call -> 1
        ActionModel.RealDeed -> 2
    }

    @TypeConverter
    fun actionModelFromInt(action: Int) = when (action) {
        1 -> ActionModel.Call
        2 -> ActionModel.RealDeed
        else -> ActionModel.RealDeed
    }
}