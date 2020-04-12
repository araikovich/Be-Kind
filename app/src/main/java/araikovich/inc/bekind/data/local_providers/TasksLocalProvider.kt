package araikovich.inc.bekind.data.local_providers

import araikovich.inc.bekind.data.local_data.AdviceLocalDataModel
import araikovich.inc.bekind.data.local_data.MissionLocalData
import araikovich.inc.bekind.data.local_data.SmallDeedLocalData

interface TasksLocalProvider {

    suspend fun provideDayAdvice(): AdviceLocalDataModel

    suspend fun provideAllAdvices(): MutableList<AdviceLocalDataModel>

    suspend fun provideSmallDeedsList(): MutableList<SmallDeedLocalData>

    suspend fun provideMissions(): MutableList<MissionLocalData>
}