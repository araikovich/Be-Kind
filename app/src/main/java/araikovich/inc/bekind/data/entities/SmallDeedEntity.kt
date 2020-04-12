package araikovich.inc.bekind.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import araikovich.inc.bekind.ui.home.data.ActionModel

@Entity(tableName = "small_deeds")
data class SmallDeedEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val action: ActionModel,
    val color: Int
)