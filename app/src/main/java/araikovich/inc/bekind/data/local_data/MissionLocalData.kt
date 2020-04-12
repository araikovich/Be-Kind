package araikovich.inc.bekind.data.local_data

data class MissionLocalData(
    val id: Int,
    val title: String,
    val description: String,
    val missionCount: Int,
    val isLocked: Boolean,
    val openLevel: Int,
    val color: Int
)