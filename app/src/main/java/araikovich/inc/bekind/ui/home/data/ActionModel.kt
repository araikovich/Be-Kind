package araikovich.inc.bekind.ui.home.data

sealed class ActionModel{
    object Call: ActionModel()
    object RealDeed: ActionModel()
}