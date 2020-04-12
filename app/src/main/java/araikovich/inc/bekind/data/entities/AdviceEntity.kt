package araikovich.inc.bekind.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "advices")
data class AdviceEntity(
    @PrimaryKey
    val id: Int,
    val adviceText: String,
    val authorText: String,
    var savedDate: String
)