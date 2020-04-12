package araikovich.inc.bekind.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "missions")
data class MissionEntity (
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val missionCount: Int,
    val isLocked: Boolean,
    val openLevel: Int,
    val color: Int
)