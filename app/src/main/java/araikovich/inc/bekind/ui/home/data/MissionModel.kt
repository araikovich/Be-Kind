package araikovich.inc.bekind.ui.home.data

data class MissionModel(
    val id: Int,
    val title: String,
    val description: String,
    val missionCount: Int,
    val isLocked: Boolean,
    val openLevel: Int,
    val color: Int
)