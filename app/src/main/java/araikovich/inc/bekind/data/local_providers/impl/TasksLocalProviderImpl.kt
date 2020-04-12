package araikovich.inc.bekind.data.local_providers.impl

import androidx.core.graphics.toColorInt
import araikovich.inc.bekind.data.local_data.AdviceLocalDataModel
import araikovich.inc.bekind.data.local_data.MissionLocalData
import araikovich.inc.bekind.data.local_data.SmallDeedLocalData
import araikovich.inc.bekind.data.local_providers.TasksLocalProvider
import araikovich.inc.bekind.ui.home.data.ActionModel

class TasksLocalProviderImpl():
    TasksLocalProvider {

    override suspend fun provideDayAdvice(): AdviceLocalDataModel {
        val allAdvices = provideAllAdvices()
        return allAdvices.random()
    }

    override suspend fun provideAllAdvices(): MutableList<AdviceLocalDataModel> {
        val allAdvices = mutableListOf<AdviceLocalDataModel>()
        allAdvices.add(
            AdviceLocalDataModel(
                0,
                "Если у тебя получилось обмануть человека, это не значит, что он дурак, это значит, что тебе доверяли больше, чем ты этого заслуживаешь.",
                "Gete"
            )
        )
        return allAdvices
    }

    override suspend fun provideSmallDeedsList(): MutableList<SmallDeedLocalData> {
        return mutableListOf(
            SmallDeedLocalData(
                0,
                "Call\nFriend",
                ActionModel.Call,
                "#e67e22".toColorInt()
            ),
            SmallDeedLocalData(
                1,
                "Call\nFriend",
                ActionModel.Call,
                "#e67e22".toColorInt()
            ),
            SmallDeedLocalData(
                2,
                "Call\nFriend",
                ActionModel.Call,
                "#e67e22".toColorInt()
            ),
            SmallDeedLocalData(
                3,
                "Call\nFriend",
                ActionModel.Call,
                "#e67e22".toColorInt()
            ),
            SmallDeedLocalData(
                4,
                "Call\nFriend",
                ActionModel.Call,
                "#e67e22".toColorInt()
            )
        )
    }

    override suspend fun provideMissions(): MutableList<MissionLocalData> {
        return mutableListOf(
            MissionLocalData(
                0,
                "Partnership",
                "Love is a partnership of two unique people who bring out the very best in each other",
                7,
                false,
                1,
                "#3498db".toColorInt()
            ),
            MissionLocalData(
                1,
                "Partnership",
                "Love is a partnership of two unique people who bring out the very best in each other",
                7,
                false,
                1,
                "#3498db".toColorInt()
            ),
            MissionLocalData(
                2,
                "Partnership",
                "Love is a partnership of two unique people who bring out the very best in each other",
                7,
                false,
                1,
                "#3498db".toColorInt()
            ),
            MissionLocalData(
                3,
                "Partnership",
                "Love is a partnership of two unique people who bring out the very best in each other",
                7,
                false,
                1,
                "#3498db".toColorInt()
            ),
            MissionLocalData(
                4,
                "Partnership",
                "Love is a partnership of two unique people who bring out the very best in each other",
                7,
                false,
                1,
                "#3498db".toColorInt()
            )
        )
    }
}